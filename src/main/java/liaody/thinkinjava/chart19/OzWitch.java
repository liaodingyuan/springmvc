/**
 * 
 */
package liaody.thinkinjava.chart19;

/**
* <p>Title:OzWitch </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年11月11日
*/
public enum OzWitch {
// 所有的枚举实例必须定义在方法之前，实例定义完成之后需要使用分好隔开才能够创建方法
	WEST("这是西部数据"), // The constructor OzWitch(String) is undefined
	NORTH("这是北部数据"),
	EAST("这是东部数据"),
	SOUTH("这是南部数据");
	private String description;
	// 这是枚举类型的构造器。
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
