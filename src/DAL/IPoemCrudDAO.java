package src.DAL;

import src.TransferObject.PoemTO;

public interface IPoemCrudDAO {
	
	public int getTotalRowsInBook();
	public Object[][] getBooksFromDB();
	public int getTotalRowsInPoems(int bookID);
	public Object[][] getPoemsFromDB(int bookID);
	
	public void addPoemInDB(PoemTO poemTO);
	public void updatePoemInDB(PoemTO poemTO);
	public void deletePoemFromDB(PoemTO poemTO);
}
