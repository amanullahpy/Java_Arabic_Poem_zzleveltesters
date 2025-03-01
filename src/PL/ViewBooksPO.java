package src.PL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.BLL.IPoemCrudBO;
import src.BLL.PoemCrudBO;



//import DAL.BookCRUDDAO;

public class ViewBooksPO extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JLabel bookNameLabel;
	JTextField bookIDTextField;
	JButton seePoems;

    public ViewBooksPO() {
    	
    	// Setting Title, Size, & Location of Window Swing
        setTitle("View Books Page");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialling Buttons for CRUD Operations
        seePoems = new JButton("See Poems");
        
        bookNameLabel = new JLabel("Enter the Book ID to See/Add Poems: ");
        bookIDTextField = new JTextField(20);
        
        // Changing the Colours of the Buttons
        seePoems.setBackground(Color.GREEN);
        
        // Making a Title using Embedded HTML in Swing to make line breaks
        JLabel titleLabel = new JLabel("<html><br>See All Books<br><br></html>", SwingConstants.CENTER);
        // Making Panel for Title of Page
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        
        // Making a Panel for Input Form
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3,1));
        
        inputPanel.add(bookNameLabel);
        inputPanel.add(bookIDTextField);
        inputPanel.add(seePoems);
        
        IPoemCrudBO poem1 = null;
        PoemCrudBO bllFascade = new PoemCrudBO(poem1);
        
        // Changing the Fonts Style, & Size
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font inpFont = new Font("Arial", Font.ITALIC, 16);
        
        // Changing Fonts for Buttons
        seePoems.setFont(buttonFont);
        bookNameLabel.setFont(inpFont);
        bookIDTextField.setFont(inpFont);
        
        // Changing the Fonts for TitlePanel
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        
        // Define the data and column names
        Object[][] data = bllFascade.getBooksFromDB();
        String[] columnNames = {"ID", "Book_Name", "Book_Author", "Year_Author_Passed_Away"};
        
        // Create the JTable
        JTable table = new JTable(data, columnNames);
        
        // Add the JTable to a JScrollPane for scrolling if needed
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Setting Layout of the Application
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        // Add the JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        
        seePoems.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(() -> {
					
					String stringBookId = bookIDTextField.getText();
					int bookID = Integer.parseInt(stringBookId);
					
		            AddPoemPO p = new AddPoemPO(bookID);
		            p.setVisible(true);
		            
		        });
			}
    	});
    }
}
