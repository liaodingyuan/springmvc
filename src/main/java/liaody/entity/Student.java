/**
 * 
 */
package liaody.entity;

/**
 * <p>
 * Title:Student
 * </p>
 * <p>
 * Description: һ���༶��Ӧ���ѧ������ʾmybatisһ�Զ�ʱ���ݲ�ѯ
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��29��
 */
public class Student {

	// �������ԣ���student���е��ֶζ�Ӧ
	private int id; // id===>s_id
	private String name; // name===>s_name

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

}
