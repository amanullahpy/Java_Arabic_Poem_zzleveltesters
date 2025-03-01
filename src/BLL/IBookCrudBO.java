package src.BLL;

import src.TransferObject.BookTO;

public interface IBookCrudBO {
	
	public void createBook(BookTO book);
	public void updateBook(BookTO book);
	public void deleteBook(BookTO book);
	public void readBook(BookTO book);
}
