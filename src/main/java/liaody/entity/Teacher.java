/**
 * 
 */
package liaody.entity;

/**
* <p>Title:Teacher </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��7��29��
*/
public class Teacher {

    //����ʵ��������ԣ���teacher���е��ֶζ�Ӧ
    private int id;            //id===>t_id
    private String name;    //name===>t_name

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
        return "Teacher [id=" + id + ", name=" + name + "]";
    }
}