/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
* <p>Title:OzWitch </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��11��11��
*/
public enum OzWitch {
// ���е�ö��ʵ�����붨���ڷ���֮ǰ��ʵ���������֮����Ҫʹ�÷ֺø������ܹ���������
	WEST("������������"), // The constructor OzWitch(String) is undefined
	NORTH("���Ǳ�������"),
	EAST("���Ƕ�������"),
	SOUTH("�����ϲ�����");
	private String description;
	// ����ö�����͵Ĺ�������
	private OzWitch(String description) {
		this.description = description;
	}
	// return constructor information
	public String getDescription() {
		return this.description;
	}
	public static void main(String[] args) {
		for(OzWitch witch:OzWitch.values()) {
			System.out.println(witch.getDescription());
		}
	}
}
