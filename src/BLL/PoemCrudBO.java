package src.BLL;



import src.TransferObject.PoemTO;

import src.DAL.DALFascade;
import src.DAL.IPoemCrudDAO;
import src.DAL.PoemCrudDAO;


public class PoemCrudBO {
	
	IPoemCrudDAO poem1;
	IPoemCrudDAO dataAccessFascade = new PoemCrudDAO(poem1);
	
	public PoemCrudBO(IPoemCrudBO ipoem) {
		super();
	}
	
	
	public Object[][] getBooksFromDB() {
		
		Object[][] booksData = dataAccessFascade.getBooksFromDB();
		
		if( booksData == null ) {
			return null;
		}

		return booksData;
	}
	
	
	public Object[][] getPoemsFromDB(int bookID) {
		
		Object[][] booksData = dataAccessFascade.getPoemsFromDB(bookID);
		if( booksData == null ) {
			return null;
		}

		return booksData;
	}
	
	
	public void addPoemVersesInDB(PoemTO poem) {
		dataAccessFascade.addPoemInDB(poem);
	}

	public void updatePoemVersesInDB(PoemTO poem) {
		dataAccessFascade.updatePoemInDB(poem);
	}

	public void deletePoemVersesFromDB(PoemTO poem) {
		dataAccessFascade.deletePoemFromDB(poem);
	}
}
