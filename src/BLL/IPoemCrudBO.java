package src.BLL;

import src.TransferObject.PoemTO;

public interface IPoemCrudBO {

	public Object[][] getBooksFromDB();
	public Object[][] getPoemsFromDB(int bookID);
	
	public void addPoemVersesInDB(PoemTO poem);
	public void updatePoemVersesInDB(PoemTO poem);
	public void deletePoemVersesFromDB(PoemTO poem);
}
