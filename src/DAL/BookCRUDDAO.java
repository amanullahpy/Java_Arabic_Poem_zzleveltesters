package src.DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import src.TransferObject.BookTO;


public class BookCRUDDAO extends DALFascade {
	
    private static final String DB_URL = "jdbc:mysql://localhost:3306/arabic_poem_db"; 
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
	
	public BookCRUDDAO(IBookCrudDAO ibook) {
		super(ibook);
	}
	
	// Function to Insert Book Details in DB
	public void createBookInDB(BookTO book) {
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			if (connection != null) {
				System.out.println("Connected to Database");
				
				String createBookSQLSquery = "INSERT INTO books (name, author, year_author_died) VALUES ('" + book.getBookName() + "', '" + book.getBookAuthor() + "', '" + book.getYearAuthorDied() + "')";
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
	
	// Function to Update the Book Record
	public void updateBookInDB(BookTO book) {
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			if (connection != null) {
				System.out.println("Connected to Database");
				
				String updateBookSQLSquery = "UPDATE books SET author = '" + book.getBookAuthor() + "', year_author_died = '" + book.getYearAuthorDied() + "' WHERE name = '" + book.getBookName() + "'";     
				int rowsAffected = statement.executeUpdate(updateBookSQLSquery);
				
				System.out.println("Rows affected: " + rowsAffected);
			}
			
			statement.close();
			connection.close();
		} 
		catch(SQLException e) {
			System.err.println("Connection error: " + e.getMessage());
		}
	}
	
	// Function for deleting Specific Book from DB
	public void deleteBookInDB(BookTO book) {
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			java.sql.Statement statement = connection.createStatement();
			
			if (connection != null) {
				System.out.println("Connected to Database");
				
				String deleteBookSQLSquery = "DELETE FROM books WHERE name = '" + book.getBookName() + "'";  
				int rowsAffected = statement.executeUpdate(deleteBookSQLSquery);
				
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
