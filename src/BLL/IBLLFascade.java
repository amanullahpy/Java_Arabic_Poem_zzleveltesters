package src.BLL;


import src.TransferObject.BookTO;
import src.TransferObject.PoemTO;




public interface IBLLFascade extends IBookCrudBO, IPoemCrudBO {
	
	public void createBook(BookTO book);
	public void updateBook(BookTO book);
	public void deleteBook(BookTO book);
	public void readBook(BookTO book);
	
	public Object[][] getBooksFromDB();
	public Object[][] getPoemsFromDB(int bookID);
	public void addPoemVersesInDB(PoemTO poem);
	public void updatePoemVersesInDB(PoemTO poem);
	public void deletePoemVersesFromDB(PoemTO poem);
}
