package src.DAL;


import src.TransferObject.BookTO;
import src.TransferObject.PoemTO;




public class DALFascade implements IDALFascade {

	private IBookCrudDAO ibook;
	private IPoemCrudDAO ipoem;
	
	public DALFascade(IBookCrudDAO ibook, IPoemCrudDAO ipoem) {
		super();
	}
	
	public DALFascade(IBookCrudDAO ibook) {
		super();
	}
	
	public DALFascade(IPoemCrudDAO ipoem) {
		super();
	}
	
	@Override
	public void createBookInDB(BookTO book) {
		ibook.createBookInDB(book);
	}

	@Override
	public void updateBookInDB(BookTO book) {
		ibook.updateBookInDB(book);
	}

	@Override
	public void deleteBookInDB(BookTO book) {
		ibook.deleteBookInDB(book);
	}

	@Override
	public void readBookInDB(BookTO book) {
		ibook.readBookInDB(book);
		
	}

	@Override
	public int getTotalRowsInBook() {
		return ipoem.getTotalRowsInBook();
	}

	@Override
	public Object[][] getBooksFromDB() {
		return ipoem.getBooksFromDB();
	}

	@Override
	public int getTotalRowsInPoems(int bookID) {
		return ipoem.getTotalRowsInPoems(bookID);
	}

	@Override
	public Object[][] getPoemsFromDB(int bookID) {
		return ipoem.getPoemsFromDB(bookID);
	}
	
	
	@Override
	public void addPoemInDB(PoemTO poemTO) {
		ipoem.addPoemInDB(poemTO);
	}
	
	@Override
	public void updatePoemInDB(PoemTO poemTO) {
		ipoem.updatePoemInDB(poemTO);
	}
	
	@Override
	public void deletePoemFromDB(PoemTO poemTO) {
		ipoem.deletePoemFromDB(poemTO);
	}
}
