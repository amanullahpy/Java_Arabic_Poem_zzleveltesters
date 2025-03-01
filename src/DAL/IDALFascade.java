package src.DAL;


import src.TransferObject.PoemTO;

import src.TransferObject.BookTO;


public interface IDALFascade extends IBookCrudDAO, IPoemCrudDAO {
	
	public void createBookInDB(BookTO book);
	public void updateBookInDB(BookTO book);
	public void deleteBookInDB(BookTO book);
	public void readBookInDB(BookTO book);
	public int getTotalRowsInBook();
	public Object[][] getBooksFromDB();
	public int getTotalRowsInPoems(int bookID);
	public Object[][] getPoemsFromDB(int bookID);
	
	public void addPoemInDB(PoemTO poemTO);
	public void updatePoemInDB(PoemTO poemTO);
	public void deletePoemFromDB(PoemTO poemTO);
}
