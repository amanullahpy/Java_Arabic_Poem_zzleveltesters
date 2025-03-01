package src.PL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import src.BLL.IPoemCrudBO;
import src.BLL.PoemCrudBO;
import src.TransferObject.PoemTO;

//import DAL.BookCRUDDAO;

public class AddPoemPO extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JLabel poemIDLabel, poemTitleLabel;
	JTextField misra1Field, misra2Field, poemID;
	JButton add, update, del;

    public AddPoemPO(int bookID) {
    	
    	// Setting Title, Size, & Location of Window Swing
        setTitle("Manage Poems Page");
        setSize(700, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialling Buttons for CRUD Operations
        add = new JButton("Add Poem");
        update = new JButton("Update Poem");
        del = new JButton("Delete Poem");
        
        poemIDLabel = new JLabel("Enter the Poems ID to Add  Verses : ");
        poemTitleLabel = new JLabel("Enter the Verses : ");
        misra1Field = new JTextField(20);
        misra2Field = new JTextField(20);
        poemID = new JTextField(20);
        
        // Changing the Colours of the Buttons
        add.setBackground(Color.GREEN);
        update.setBackground(Color.YELLOW);
        del.setBackground(Color.RED);
        del.setForeground(Color.WHITE);
        
        // Making a Title using Embedded HTML in Swing to make line breaks
        JLabel titleLabel = new JLabel("<html><br>Manually Add Poems<br></html>", SwingConstants.CENTER);
        // Making Panel for Title of Page
        JPanel titlePanel = new JPanel();
        titlePanel.add(titleLabel);
        
        // Making a Panel for Input Form
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4,3));
        
        inputPanel.add(poemIDLabel);
        inputPanel.add(poemID);
        inputPanel.add(poemTitleLabel);
        inputPanel.add(misra1Field);
        inputPanel.add(misra2Field);
        
        inputPanel.add(add);
        inputPanel.add(update);
        inputPanel.add(del);
        
        IPoemCrudBO poem1 = null;
        PoemCrudBO bllFascade = new PoemCrudBO(poem1);
        
        // Changing the Fonts Style, & Size
        Font buttonFont = new Font("Arial", Font.BOLD, 20);
        Font inpFont = new Font("Arial", Font.ITALIC, 16);
        
        // Changing Fonts for Buttons
        add.setFont(buttonFont);
        update.setFont(buttonFont);
        del.setFont(buttonFont);
        poemTitleLabel.setFont(inpFont);
        misra1Field.setFont(inpFont);
        misra2Field.setFont(inpFont);
        poemID.setFont(inpFont);
        poemIDLabel.setFont(inpFont);
        
        // Changing the Fonts for TitlePanel
        titleLabel.setFont(new Font("Calibri", Font.BOLD, 30));
        
        // Define the data and column names
        Object[][] data = bllFascade.getPoemsFromDB(bookID);
        String[] columnNames = {"ID", "Poem_Title", "Misra_1", "Misra_2"};
        
        // Create the JTable
        JTable table = new JTable(data, columnNames);
        
        // Add the JTable to a JScrollPane for scrolling if needed
        JScrollPane scrollPane = new JScrollPane(table);
        
        // JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1)); // Set GridLayout for three rows

        // First Row: Label (poemIDLabel) and TextField (poemID)
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row1.add(poemIDLabel);
        row1.add(poemID);

        // Second Row: Label (poemTitleLabel) and Two TextFields (misra1Field, misra2Field)
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row2.add(poemTitleLabel);
        row2.add(misra1Field);
        row2.add(misra2Field);

        // Third Row: Three Buttons (add, update, del)
        JPanel row3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        row3.add(add);
        row3.add(update);
        row3.add(del);

        inputPanel.add(row1);
        inputPanel.add(row2);
        inputPanel.add(row3);
        
        // Setting Layout of the Application
        setLayout(new BorderLayout());
        add(titlePanel, BorderLayout.NORTH);
        // Add the JScrollPane to the frame
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);
        
        
        add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

		        PoemTO poem = new PoemTO();
				poem.setMisra_1(misra1Field.getText());
				poem.setMisra_2(misra2Field.getText());
				
				poem.setPoem_id( Integer.parseInt( poemID.getText() ) );
				
				bllFascade.addPoemVersesInDB(poem);
			}
        });
        
        
        update.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				PoemTO poem = new PoemTO();
				poem.setMisra_1(misra1Field.getText());
				poem.setMisra_2(misra2Field.getText());
				
				poem.setPoem_id( Integer.parseInt( poemID.getText() ) );
				
				bllFascade.updatePoemVersesInDB(poem);
				
			}
        });
        
        
        del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				PoemTO poem = new PoemTO();
				poem.setMisra_1(misra1Field.getText());
				poem.setMisra_2(misra2Field.getText());
				
				poem.setPoem_id( Integer.parseInt( poemID.getText() ) );
				
				bllFascade.deletePoemVersesFromDB(poem);
			}
        });
    }
}



