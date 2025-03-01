package src.PL;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import src.BLL.BLLFascade;
import src.BLL.BookCrudBO;
import src.BLL.IBookCrudBO;
import src.BLL.IPoemCrudBO;
import src.TransferObject.BookTO;





public class BookCRUDPO extends JFrame {


	private static final long serialVersionUID = 1L;
	
	JLabel bookNameLabel, bookAuthorLabel, yearAuthorDiedLabel, errorLabel;
    JTextField bookNameTextField, bookAuthorTextField, yearAuthorDiedTextField;
    JButton createBook, updateBook, deleteBook, readBook;
    
    IBookCrudBO book1;
    IPoemCrudBO poem1;
    BLLFascade businessFascade = new BLLFascade(book1, poem1);
    BookTO book;

    public BookCRUDPO() {
    	
    	// Setting Title, Size, & Location of Window Swing
        setTitle("Book CRUD");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialising Labels for Input
        bookNameLabel = new JLabel("Enter the Book Name: ");
        bookAuthorLabel = new JLabel("Enter the Author Name: ");
        yearAuthorDiedLabel = new JLabel("Enter the Year Author Died: ");
        errorLabel = new JLabel(" ");
        
        // Initialising TextFields for Input 
        bookNameTextField = new JTextField(20);
        bookAuthorTextField = new JTextField(20);
        yearAuthorDiedTextField = new JTextField(20);

        // Initialling Buttons for CRUD Operations
        createBook = new JButton("Create Book");
        updateBook = new JButton("Update Book");
        deleteBook = new JButton("Delete Book");
        readBook = new JButton("See Books");
        
        // Changing the Colours of the Buttons
        createBook.setBackground(Color.GREEN);
        updateBook.setBackground(Color.YELLOW);
        deleteBook.setBackground(Color.RED);
        createBook.setForeground(Color.WHITE);
        deleteBook.setForeground(Color.WHITE);
        readBook.setBackground(Color.cyan);
        
        // Making a Title using Embedded HTML in Swing to make line breaks
        JLabel titleLabel = new JLabel("<html><br>Book CRUD Operations<br><br></html>", SwingConstants.CENTER);
        // Making Panel for Title of Page
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        
        // Making a Panel for Input
        JPanel inputPanel = new JPanel();
        book = new BookTO();
        inputPanel.setLayout(new GridLayout(4,2));
        // Adding Labels & TextField to the InputPanel
        inputPanel.add(bookNameLabel);
        inputPanel.add(bookNameTextField);
        inputPanel.add(bookAuthorLabel);
        inputPanel.add(bookAuthorTextField);
        inputPanel.add(yearAuthorDiedLabel);
        inputPanel.add(yearAuthorDiedTextField);
        inputPanel.add(errorLabel);
        
        // Making a Panel for Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createBook);
        buttonPanel.add(updateBook);
        buttonPanel.add(deleteBook);
        buttonPanel.add(readBook);
        
        // Changing the Fonts Style, & Size
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font inputFormFont = new Font("Arial", Font.ITALIC, 18);
        
        // Changing Fonts for Buttons
        createBook.setFont(buttonFont);
        updateBook.setFont(buttonFont);
        deleteBook.setFont(buttonFont);
        readBook.setFont(buttonFont);
        
        // Changing Fonts for InputForm
        bookNameLabel.setFont(inputFormFont);
        bookAuthorLabel.setFont(inputFormFont);
        yearAuthorDiedLabel.setFont(inputFormFont);
        bookNameTextField.setFont(inputFormFont);
        bookAuthorTextField.setFont(inputFormFont);
        yearAuthorDiedTextField.setFont(inputFormFont);
        errorLabel.setFont(inputFormFont);
        
        // Changing the Fonts for TitlePanel
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        
        // Setting Layout of the Application
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        
        createBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				book.setBookName(bookNameTextField.getText());
				book.setBookAuthor(bookAuthorTextField.getText());
				book.setYearAuthorDied(yearAuthorDiedTextField.getText());
				
				if( yearAuthorDiedTextField.getText().contains("-") == false && 
						yearAuthorDiedTextField.getText().contains("/") == false ||
						bookAuthorTextField.getText().isEmpty() || bookNameTextField.getText().isEmpty() ) {
						showError();
				}
				else {
					hideError();
					
					businessFascade.createBook(book);
				}
			}
    	});
        
        updateBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				if( yearAuthorDiedTextField.getText().contains("-") == false && 
						yearAuthorDiedTextField.getText().contains("/") == false ||
						bookAuthorTextField.getText() == "" || bookNameTextField.getText() == "" ) {
						showError();
				}
				else {
					
					businessFascade.updateBook(book);
					hideError();
				}
			}
    	});
        
        deleteBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if( yearAuthorDiedTextField.getText().contains("-") == false && 
					yearAuthorDiedTextField.getText().contains("/") == false ||
					bookAuthorTextField.getText() == "" || bookNameTextField.getText() == "" ) {
					showError();
				}
				else {
					
					businessFascade.deleteBook(book);
					hideError();
				}
			}
    	});
        
        readBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Creating a Object of ViewBooksPO class to use functionalities of ViewBooksDAO 
				SwingUtilities.invokeLater(() -> {
					ViewBooksPO p = new ViewBooksPO();
			        p.setVisible(true);
			    });
			}
    	});
    }
    
    
    public void showError() {
    	errorLabel.setText("Error! Something Went Wrong.");
    }
    
    public void hideError() {
    	errorLabel.setText("");
    }
}
