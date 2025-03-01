package src.BLL;


import src.TransferObject.BookTO;
import src.TransferObject.PoemTO;




public class BLLFascade implements IBLLFascade {

	IBookCrudBO ibook;
	IPoemCrudBO ipoem;
	
	PoemCrudBO ipoem2;
	
	public BLLFascade(IBookCrudBO ibook, IPoemCrudBO ipoem) {
		this.ibook = ibook;
		this.ipoem = ipoem;
	}

	public BLLFascade(PoemCrudBO ipoem2) {
		this.ipoem2 = ipoem2;
	}

	@Override
	public void createBook(BookTO book) {
		ibook.createBook(book);
	}

	@Override
	public void updateBook(BookTO book) {
		ibook.updateBook(book);
	}

	@Override
	public void deleteBook(BookTO book) {
		ibook.deleteBook(book);
	}

	@Override
	public void readBook(BookTO book) {
		ibook.readBook(book);
	}
	
	@Override
	public Object[][] getBooksFromDB(){
		return ipoem.getBooksFromDB();
	}

	@Override
	public Object[][] getPoemsFromDB(int bookID) {
		return ipoem.getPoemsFromDB(bookID);
	}

	@Override
	public void addPoemVersesInDB(PoemTO poem) {
		ipoem.addPoemVersesInDB(poem);
	}

	@Override
	public void updatePoemVersesInDB(PoemTO poem) {
		ipoem.updatePoemVersesInDB(poem);
	}

	@Override
	public void deletePoemVersesFromDB(PoemTO poem) {
		ipoem.deletePoemVersesFromDB(poem);
	}

}
