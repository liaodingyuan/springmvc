/**
 * 
 */
package mybatis.chart9.mapper;

import java.util.List;

import mybatis.chart9.domain.Student;



/**
* <p>Title:Clazz </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017Äê7ÔÂ30ÈÕ
*/
public class Clazz {

	private Integer id;
	private String code;
	private String name;
	private List<Student> students;
	
	public Clazz() {
		
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Clazz [id=" + id + ", code=" + code + ", name=" + name + ", students=" + students + "]";
	}
	
}
