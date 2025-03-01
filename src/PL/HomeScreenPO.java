package src.PL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import src.BLL.PoemProcessor;
import src.DAL.DataBaseManager;
//import DAL.BookCRUDDAO;

public class HomeScreenPO extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JButton manageBook, manageRoots, managePoems, readPoems, importPoems;

    public HomeScreenPO() {
    	
    	// Setting Title, Size, & Location of Window Swing
        setTitle("Arabic Poem App");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialling Buttons for CRUD Operations
        manageBook = new JButton("Manage Books");
        manageRoots = new JButton("Manage Roots");
        managePoems = new JButton("Manage Poems");
        importPoems = new JButton("Import Poems");
        readPoems = new JButton("View Books");
        
        
        // Changing the Colours of the Buttons
        manageBook.setBackground(Color.GREEN);
        manageRoots.setBackground(Color.YELLOW);
        managePoems.setBackground(Color.RED);
        importPoems.setBackground(Color.CYAN);
        readPoems.setBackground(Color.MAGENTA);
        
        // Making a Title using Embedded HTML in Swing to make line breaks
        JLabel titleLabel = new JLabel("<html><br>Home Page<br><br></html>", SwingConstants.CENTER);
        // Making Panel for Title of Page
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        
        // Making a Panel for Buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(manageBook);
        buttonPanel.add(manageRoots);
        buttonPanel.add(managePoems);
        buttonPanel.add(importPoems);
        buttonPanel.add(readPoems);
        
        // Changing the Fonts Style, & Size
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        
        // Changing Fonts for Buttons
        manageBook.setFont(buttonFont);
        manageRoots.setFont(buttonFont);
        managePoems.setFont(buttonFont);
        importPoems.setFont(buttonFont);
        readPoems.setFont(buttonFont);
        
        // Changing the Fonts for TitlePanel
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        
        // Setting Layout of the Application
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        
        
        manageBook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// Creating a Object of BookCRUDPO class to use functionalities of BookCRUDDAO 
				SwingUtilities.invokeLater(() -> {
		            BookCRUDPO p = new BookCRUDPO();
		            p.setVisible(true);
		        });
			}
    	});
        
        manageRoots.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Creating a Object of BookCRUDPO class to use functionalities of BookCRUDDAO 
				SwingUtilities.invokeLater(() -> {
//		            RootCRUDPO p = new RootCRUDPO();
//		            p.setVisible(true);
		        });
			}
    	});
        
        managePoems.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Creating a Object of BookCRUDPO class to use functionalities of BookCRUDDAO 
				SwingUtilities.invokeLater(() -> {
//		            RootCRUDPO p = new RootCRUDPO();
//		            p.setVisible(true);
		        });
			}
    	});
        
        
        importPoems.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// Creating a Object of BookCRUDPO class to use functionalities of BookCRUDDAO 
				SwingUtilities.invokeLater(() -> {
//		            RootCRUDPO p = new RootCRUDPO();
//		            p.setVisible(true);
		        });
			}
    	});
        
        
        readPoems.addActionListener(new ActionListener() {

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
    
    
    
    public static void main(String[] args) {
    	
        SwingUtilities.invokeLater(() -> {
            HomeScreenPO p = new HomeScreenPO();
            p.setVisible(true));
        });
        
        DataBaseManager databaseManager = new DataBaseManager("jdbc:mysql://localhost:3307/scdproject", "username", "password");
        PoemProcessor poemProcessor = new PoemProcessor(databaseManager.getConnection());

        String filePath = "Poem.txt";
        poemProcessor.processFile(filePath);

        databaseManager.close();
        
    }
}
