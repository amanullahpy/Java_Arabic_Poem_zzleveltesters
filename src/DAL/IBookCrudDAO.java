package src.DAL;

import src.TransferObject.BookTO;

public interface IBookCrudDAO {
	
	public void createBookInDB(BookTO book);
	public void updateBookInDB(BookTO book);
	public void deleteBookInDB(BookTO book);
	public void readBookInDB(BookTO book);
}
