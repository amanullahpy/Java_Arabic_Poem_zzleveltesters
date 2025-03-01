//for processing the text file
package src.BLL;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PoemProcessor {
	  private final Connection connection;
      private String title1;
	  
	    public PoemProcessor(Connection connection) {
	        this.connection = connection;
    }

	    //Identifying the lines containing "_________" and "========== & removing it"
	    public void processFile(String filePath) {
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            boolean isInsideMarker = false; // Flag to check whether we are inside the marker.

	            while ((line = br.readLine()) != null) {
	                if (line.contains("_________")) {
	                    // Start of the marker & set the flag.
	                    isInsideMarker = true;
	                } 
	                else if (line.contains("==========")) {
	                    // End of the marker & reset the flag.
	                    isInsideMarker = false;
	                } 
	                else if (!isInsideMarker) {
	                	//Extracting Poem Titles b/w '[' and ']'
	                	  if (line.matches("\\[.+\\]")) {
	                          // This line is a poem title.
	                          title1 = line.substring(1, line.length() - 1); // Remove brackets.

	                          // Inserting the title into the database.
	                          insertPoemTitle(title1);
	                      }
	                      else if (line.startsWith("(")) {
	                          // This line is a poem verse.
	                          String[] misras = line.substring(1, line.length() - 1).split("\\.\\.\\."); // Remove parentheses.
	                          // Split the verse into misras.
	                        
	                          String firstMisra = (misras.length > 0) ? misras[0] : "";
	                          String secondMisra = (misras.length > 1) ? misras[1] : "";

	                        
							// Insert misras into separate columns in the database.
	                          insertPoemVerse(title1,firstMisra,secondMisra);
	                       }
	          }
	       }
	      }
	            catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    
	   //Extracting Poem Titles b/w '[' and ']'
	        public void insertPoemTitle(String title) {
	            // Inserting the title into the database.
	        	   String sql = "INSERT INTO poem_titles (title) VALUES (?)";

	               try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	                   pstmt.setString(1, title);
	                   pstmt.executeUpdate();
	               } catch (SQLException e) {
	                   e.printStackTrace();
	               }
	        }
	    
	        public void insertPoemVerse(String title, String firstMisra, String secondMisra) {
	            // Inserting the misras into the database.
	        	String sql = "INSERT INTO poem_verses (title, first_misra, second_misra) VALUES (?, ?, ?)";

	            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	                pstmt.setString(1, title);
	                pstmt.setString(2, firstMisra);
	                pstmt.setString(3, secondMisra);
	                pstmt.executeUpdate();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
}
    
    
    
    
    

