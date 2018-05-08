/**
 * 
 */
package basecc.json.fastjson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
* <p>Title:FastJsonTest </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018年5月7日
*/
public class FastJsonTest {

	public static void test001() {
		TestPerson json =new TestPerson(19,"黎明");
		List<TestPerson> list = new ArrayList<>();
		list.add(json);
        list.add(new TestPerson(12,"张三"));
		// 将集合或者对象序列化成JSON
        System.out.println(JSON.toJSON(json));
        System.out.println(JSON.toJSON(list));// 会序列化为一个JSON数组
        
        // Json串反序列化成对象(如果无法匹配就为null)
        TestPerson person = JSON.parseObject("{\"name\":\"李明\",\"age\":12}",TestPerson.class);
        System.out.printf("name:%s,age:%d\n",person.getName(),person.getAge());
        
        // 数组对象反序列化成集合
        String str = "[{\"name\":\"李明\",\"age\":19},{\"name\":\"张三\",\"age\":12}]";
        List<TestPerson> listPerson = JSON.parseArray(str,TestPerson.class);
        listPerson.stream().map(TestPerson::getName).forEach(System.out::println);
        listPerson.stream().map(TestPerson::getAge).forEach(System.out::println);
        
        // 没有对象直接解析诶JSONObject
        JSONObject json2 = JSON.parseObject(str);
        json2.get(null);
      //没有对象直接解析JSON数组
        JSONArray jarr = JSON.parseArray(str);
        //jarr.stream().map(JSONArray.getJSONObject::).forEach(System.out::println);
	}
	
	/**
	 * JSON的序列化（转换为JSON对象）与反序列化
	 */
	public static void str2JsonObject() {
		String jsonObjectStr = "{'zhangxy':'张学友','liudh':'刘德华','lim':'黎明','guofc':'郭富城'}" ;
		JSONObject json = JSONObject.parseObject(jsonObjectStr);
		json.entrySet().stream().sorted().map(entry->entry.getKey()+":"+entry.getValue()).forEach(System.out::println);
	}
	/**
	 */
	public static void str2JsonArray() {
		String jsonArrayStr = "[{'zhangxy':'张学友'}, {'liudh':'刘德华'},{'lim':'黎明'},{'guofc':'郭富城'}]";
		JSONArray jarr = JSONArray.parseArray(jsonArrayStr);
		jarr.forEach(System.out::println);		
	}
	
	public static void jsonStr2Bean() {
		// 把对象转换为json格式的字符串
		TestPerson tp = new TestPerson();
		tp.setName("廖定元");
		tp.setAge(28);
		System.out.println(JSONObject.toJSONString(tp));
		
		// 把json格式字符串转换为对象
		String person = "{'name':'liaody','age':56}";
		TestPerson jsonToObject = JSONObject.parseObject(person,TestPerson.class);
		System.out.println(jsonToObject.getName()+":::"+jsonToObject.getAge());
		
		// 两种用法是相等的
//		 将javaBean转化为json对象 
		JSONObject jsonObj = (JSONObject) JSON.toJSON(tp);  
        System.out.println("bean2Json()方法：jsonObj==" + jsonObj);
		
//		TestPerson pp = JSON.parseObject(person,TestPerson.class);
//		TestPerson p2 = JSONObject.parseObject(person,TestPerson.class);
//		System.out.println(pp.getName());
//		System.out.println(p2.getName());
		
		// List和json相互转换
		List<TestPerson> personList = new ArrayList<>();
		personList.add(new TestPerson("laiwenyun",24));
		personList.add(new TestPerson("weining",27));
		personList.add(new TestPerson("maxiudong",28));
		String listToString = JSON.toJSONString(personList);
		System.out.println(listToString);
		
		// 数组（这里使用String 代替）转换为List
		List<TestPerson> prsonList2 = JSONArray.parseArray(listToString, TestPerson.class);
		prsonList2.forEach(System.out::println);
		
		// Array和json相互转换
		String[] arrStr = {"a","b","c","d"};
		String arrJsonSrt = JSON.toJSONString(arrStr);
		System.out.println(arrJsonSrt);
		
		// 将数组转换为JSONArray的是偶是不能够直接将数组传入的，先将数组toJSONString然后再将这个字符串传入parseArray
		JSONArray jarr = JSON.parseArray(arrJsonSrt);
		jarr.forEach(System.out::println);	
		
		// 对象数组与json的互相转换
		// 和List转换为数组一样
		
		//Map -> JSON 		
		TestPerson p1 = new TestPerson();
		p1.setAge(28);
		p1.setName("mmm");
		TestPerson p22 = new TestPerson();
		p22.setAge(53);
		p22.setName("shiq");
		TestPerson p3 = new TestPerson();
		p3.setAge(23);
		p3.setName("mxd");
		TestPerson p4 = new TestPerson();
		p4.setAge(25);
		p4.setName("wn");
		Map<String ,TestPerson> pMap = new HashMap<>();
		pMap.put("mmm", p1);
		pMap.put("shiq", p22);
		pMap.put("mxd", p3);
		pMap.put("wn", p4);		
		String mapJsonStr = JSON.toJSONString(pMap);
		System.out.println(mapJsonStr);
		
		 //JSON -> Map 需要进行强制转换
		Map<String ,TestPerson> rMap =(Map<String ,TestPerson> ) JSON.parse(mapJsonStr);
		rMap.keySet().stream().forEach(System.out::println);
		
	}
	/**
	 * 简单的Java示例将Strings列表转换为大写。
	 */
	public static void testLambda() {
		List<String> alpha = Arrays.asList("a","b","c");
		// 可以直接使用
		alpha.forEach(System.out::println);
		// 是一样的
		alpha.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		alpha.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// 计算每一个数的平方
		Arrays.asList(1,3,4,5).stream().map(n->n*n).forEach(System.out::println);		
	}
	public static void main(String[] args) {
		jsonStr2Bean();
//		testLambda();
	}
}
