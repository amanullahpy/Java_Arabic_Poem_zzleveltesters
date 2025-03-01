package src.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import src.TransferObject.PoemTO;


public class PoemCrudDAO extends DALFascade {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/arabic_poem_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "";

	public PoemCrudDAO(IPoemCrudDAO ipoem) {
		super(ipoem);
	}

	
	// Function to take Data of Books from DB
	public Object[][] getBooksFromDB(){
		
		int rowCount = getTotalRowsInBooks();
		Object[][] bookData = new Object[rowCount][4];
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			String selectQuery = "SELECT * FROM books";
			
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			if (connection != null) {
				System.out.println("Connected to Database");
				
				int i = 0;
				while (resultSet.next()) {
					// Retrieve data from the result set
					int id = resultSet.getInt("id");
					String bookName = resultSet.getString("name");
					String bookAuthor = resultSet.getString("author");
					String yearAuthorDied = resultSet.getString("year_author_died");
					bookData[i][0] = id;
					bookData[i][1] = bookName;
					bookData[i][2] = bookAuthor;
					bookData[i][3] = yearAuthorDied;
					
					i++;
				}

				return bookData;
			}
				resultSet.close();
				statement.close();
				connection.close();
			}
			catch(SQLException e) {
				System.err.println("Connection error: " + e.getMessage());
			}
		return bookData;
	}
	
	// Function to used No. of Rows in 2D Array
	public int getTotalRowsInBooks() {
		
		int rowCount = 0;
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			String countQuery = "SELECT COUNT(*) FROM books"; // To make a 2D Array
			
			ResultSet rowCountQuery = statement.executeQuery(countQuery);
			
            if (rowCountQuery.next()) {
                rowCount = rowCountQuery.getInt(1);
            }
			
			statement.close();
			connection.close();
		}
		catch(SQLException e) {
			System.err.println("Connection error: " + e.getMessage());
		}
		
		return rowCount;
	}
	
	
	// Function to take Data of Poems from DB
		public Object[][] getPoemsFromDB(int bookID){
			
			int rowCount = getTotalRowsInPoemsVerses(bookID);
			Object[][] bookData = new Object[rowCount][4];
			
			System.out.println(" Book ID : " + bookID);
			
			try {
				Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				java.sql.Statement statement = connection.createStatement();
				
				String selectQuery = "SELECT p.id as id, p.title as title, v.misra_1 as misra_1, v.misra_2 as misra_2 "
		                  + "FROM books b "
		                  + "JOIN poems p ON p.book_id = b.id "
		                  + "JOIN verse v ON v.poem_id = p.id "
		                  + "WHERE b.id = " + bookID;

				
				ResultSet resultSet = statement.executeQuery(selectQuery);
				
				if (connection != null) {
					System.out.println("Connected to Database");
					
					int i = 0;
					while (resultSet.next()) {
						// Retrieve data from the result set
						int id = resultSet.getInt("id");
						String poemTitle = resultSet.getString("title");
						String misra_1 = resultSet.getString("misra_1");
						String misra_2 = resultSet.getString("misra_2");
						bookData[i][0] = id;
						bookData[i][1] = poemTitle;
						bookData[i][2] = misra_1;
						bookData[i][3] = misra_2;
						
						i++;
					}

					return bookData;
				}
					resultSet.close();
					statement.close();
					connection.close();
				}
				catch(SQLException e) {
					System.err.println("Connection error: " + e.getMessage());
				}
			return bookData;
		}
		
		
		// Function to used No. of Rows in 2D Array
		public int getTotalRowsInPoemsVerses(int bookID) {
			
			int rowCount = 0;
			try {
				Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				java.sql.Statement statement = connection.createStatement();
				
				String countQuery = "SELECT COUNT(*) "
						+ "FROM books b "
						+ "JOIN poems p ON p.book_id = b.id "
						+ "JOIN verse v ON v.poem_id = p.id "
						+ "WHERE b.id = " + bookID; // To make a 2D Array
				
				ResultSet rowCountQuery = statement.executeQuery(countQuery);
				
	            if (rowCountQuery.next()) {
	                rowCount = rowCountQuery.getInt(1);
	            }
				
				statement.close();
				connection.close();
			}
			catch(SQLException e) {
				System.err.println("Connection error: " + e.getMessage());
			}
			
			return rowCount;
		}
		
		
		
		// Function to insert Poem Data/Verse/Misra in DB
		public void addPoemInDB(PoemTO poem) {
			
			try {
				Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				java.sql.Statement statement = connection.createStatement();
				
				if (connection != null) {
					System.out.println("Connected to Database");
					
					String createBookSQLSquery = "INSERT INTO verse (misra_1, misra_2, poem_id) "
							+ "VALUES ('" + poem.getMisra_1() + "', '" + poem.getMisra_2() + "', '" + poem.getPoem_id() + "')";
					
					int rowsAffected = statement.executeUpdate(createBookSQLSquery);
					
					System.out.println("Rows affected: " + rowsAffected);
				}
				
				statement.close();
				connection.close();
			} 
			catch(SQLException e) {
				System.err.println("Connection error: " + e.getMessage());
			}
		}
		
		
		public void updatePoemInDB(PoemTO poem) {
			
			try {
				Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				java.sql.Statement statement = connection.createStatement();
				
				if (connection != null) {
					System.out.println("Connected to Database");
					
					String createBookSQLSquery = "UPDATE verse "
									+ "SET misra_1 = '" + poem.getMisra_1() + "', misra_2 = '" + poem.getMisra_2() + "' "
									+ "WHERE poem_id = " + poem.getPoem_id();
					int rowsAffected = statement.executeUpdate(createBookSQLSquery);
					
					System.out.println("Rows affected: " + rowsAffected);
				}
				
				statement.close();
				connection.close();
			} 
			catch(SQLException e) {
				System.err.println("Connection error: " + e.getMessage());
			}
		}
		
		
		public void deletePoemFromDB(PoemTO poem) {
			
			try {
				Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				java.sql.Statement statement = connection.createStatement();
				
				if (connection != null) {
					System.out.println("Connected to Database");
					
					String createBookSQLSquery = "DELETE FROM verse "
									+ "WHERE poem_id = " + poem.getPoem_id();
					int rowsAffected = statement.executeUpdate(createBookSQLSquery);
					
					System.out.println("Rows affected: " + rowsAffected);
				}
				
				statement.close();
				connection.close();
			} 
			catch(SQLException e) {
				System.err.println("Connection error: " + e.getMessage());
			}
		}
}
