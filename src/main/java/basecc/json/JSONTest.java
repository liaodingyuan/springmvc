/**
 * 
 */
package basecc.json;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
* <p>Title:JSONTest </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018��5��7��
*/
public class JSONTest {
	
	/**
	 * ʹ��fastjson����
	 */
	public static void test001() {
		String s = "{\"name\":\"a\",\"family\":[\"����\",\"����\"]}";
		JSONObject jsonObject = JSON.parseObject(s);		
		JSONArray family = jsonObject.getJSONArray("family");
		family.stream().forEach(System.out::println);
		System.out.println(jsonObject.get("name"));
		
		String str = "[{name:'a',value:'aa'},{name:'b',value:'bb'},{name:'c',value:'cc'},{name:'d',value:'dd'}]" ;  // һ��δת�����ַ���
//		JSONArray arr = JSONArray.fromObject(arg0, arg1);
	}	
	public static void test002() {
		
	}
	public static void main(String[] args) {
		test001();
	}

}
