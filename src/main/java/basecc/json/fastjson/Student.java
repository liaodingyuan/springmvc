/**
 * 
 */
package basecc.json.fastjson;

/**
* <p>Title:Student </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê5ÔÂ8ÈÕ
*/
public class Student {

	private String studentName;
	private int studentAge;
	public Student() {
		
	}
	public Student(String studentName,int studentAge) {
		this.studentName = studentName;
		this.studentAge = studentAge;				
	}
	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	/**
	 * @return the studentAge
	 */
	public int getStudentAge() {
		return studentAge;
	}
	/**
	 * @param studentAge the studentAge to set
	 */
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	
	
	public String toString() {
	
		return this.studentName+"::::"+this.studentAge;
	}
}
