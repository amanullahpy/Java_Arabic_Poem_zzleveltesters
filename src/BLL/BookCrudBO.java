package src.BLL;

import src.DAL.BookCRUDDAO;
import src.DAL.DALFascade;
import src.TransferObject.BookTO;
import src.DAL.IBookCrudDAO;

public class BookCrudBO extends BLLFascade {
	
	IBookCrudDAO book1;
	IBookCrudDAO bookDAO = new BookCRUDDAO(book1);
	DALFascade dataAccessFascade = new DALFascade(bookDAO); 
	
	public BookCrudBO(IBookCrudBO ibook, IPoemCrudBO ipoem) {
		super(ibook, ipoem);
	}
	
	public void createBook(BookTO book) {
		
		if( book.getBookName().isEmpty() && book.getBookAuthor().isEmpty() && book.getYearAuthorDied().isEmpty() ) {
			// TODO
		}
		else {
			bookDAO.createBookInDB( book );
		}
	}
	
	public void updateBook(BookTO book) {
		
		if( book.getBookName().isEmpty() && book.getBookAuthor().isEmpty() && book.getYearAuthorDied().isEmpty() ) {
			// TODO
		}
		else {
			bookDAO.updateBookInDB( book );
		}
	}

	public void deleteBook(BookTO book) {
	
		if( book.getBookName().isEmpty() && book.getBookAuthor().isEmpty() && book.getYearAuthorDied().isEmpty() ) {
			// TODO
		}
		else {
			bookDAO.deleteBookInDB( book );
		}
	}
}
