/**
 * 
 */
package basecc.java8.stram;

import java.util.HashSet;
import java.util.Set;

/**
* <p>Title:Student </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê5ÔÂ8ÈÕ
*/
public class Student {

	 private String name;
	    private Set<String> book;

	    /**
		 * @return the book
		 */
		public Set<String> getBook() {
			return book;
		}

		/**
		 * @param book the book to set
		 */
		public void setBook(Set<String> book) {
			this.book = book;
		}

		public void addBook(String book) {
	        if (this.book == null) {
	            this.book = new HashSet<>();
	        }
	        this.book.add(book);
	    }

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}
	    
	    
}
