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
* @date 2018��5��7��
*/
public class FastJsonTest {

	public static void test001() {
		TestPerson json =new TestPerson(19,"����");
		List<TestPerson> list = new ArrayList<>();
		list.add(json);
        list.add(new TestPerson(12,"����"));
		// �����ϻ��߶������л���JSON
        System.out.println(JSON.toJSON(json));
        System.out.println(JSON.toJSON(list));// �����л�Ϊһ��JSON����
        
        // Json�������л��ɶ���(����޷�ƥ���Ϊnull)
        TestPerson person = JSON.parseObject("{\"name\":\"����\",\"age\":12}",TestPerson.class);
        System.out.printf("name:%s,age:%d\n",person.getName(),person.getAge());
        
        // ����������л��ɼ���
        String str = "[{\"name\":\"����\",\"age\":19},{\"name\":\"����\",\"age\":12}]";
        List<TestPerson> listPerson = JSON.parseArray(str,TestPerson.class);
        listPerson.stream().map(TestPerson::getName).forEach(System.out::println);
        listPerson.stream().map(TestPerson::getAge).forEach(System.out::println);
        
        // û�ж���ֱ�ӽ�����JSONObject
        JSONObject json2 = JSON.parseObject(str);
        json2.get(null);
      //û�ж���ֱ�ӽ���JSON����
        JSONArray jarr = JSON.parseArray(str);
        //jarr.stream().map(JSONArray.getJSONObject::).forEach(System.out::println);
	}
	
	/**
	 * JSON�����л���ת��ΪJSON�����뷴���л�
	 */
	public static void str2JsonObject() {
		String jsonObjectStr = "{'zhangxy':'��ѧ��','liudh':'���»�','lim':'����','guofc':'������'}" ;
		JSONObject json = JSONObject.parseObject(jsonObjectStr);
		json.entrySet().stream().sorted().map(entry->entry.getKey()+":"+entry.getValue()).forEach(System.out::println);
	}
	/**
	 */
	public static void str2JsonArray() {
		String jsonArrayStr = "[{'zhangxy':'��ѧ��'}, {'liudh':'���»�'},{'lim':'����'},{'guofc':'������'}]";
		JSONArray jarr = JSONArray.parseArray(jsonArrayStr);
		jarr.forEach(System.out::println);		
	}
	
	public static void jsonStr2Bean() {
		// �Ѷ���ת��Ϊjson��ʽ���ַ���
		TestPerson tp = new TestPerson();
		tp.setName("�ζ�Ԫ");
		tp.setAge(28);
		System.out.println(JSONObject.toJSONString(tp));
		
		// ��json��ʽ�ַ���ת��Ϊ����
		String person = "{'name':'liaody','age':56}";
		TestPerson jsonToObject = JSONObject.parseObject(person,TestPerson.class);
		System.out.println(jsonToObject.getName()+":::"+jsonToObject.getAge());
		
		// �����÷�����ȵ�
//		 ��javaBeanת��Ϊjson���� 
		JSONObject jsonObj = (JSONObject) JSON.toJSON(tp);  
        System.out.println("bean2Json()������jsonObj==" + jsonObj);
		
//		TestPerson pp = JSON.parseObject(person,TestPerson.class);
//		TestPerson p2 = JSONObject.parseObject(person,TestPerson.class);
//		System.out.println(pp.getName());
//		System.out.println(p2.getName());
		
		// List��json�໥ת��
		List<TestPerson> personList = new ArrayList<>();
		personList.add(new TestPerson("laiwenyun",24));
		personList.add(new TestPerson("weining",27));
		personList.add(new TestPerson("maxiudong",28));
		String listToString = JSON.toJSONString(personList);
		System.out.println(listToString);
		
		// ���飨����ʹ��String ���棩ת��ΪList
		List<TestPerson> prsonList2 = JSONArray.parseArray(listToString, TestPerson.class);
		prsonList2.forEach(System.out::println);
		
		// Array��json�໥ת��
		String[] arrStr = {"a","b","c","d"};
		String arrJsonSrt = JSON.toJSONString(arrStr);
		System.out.println(arrJsonSrt);
		
		// ������ת��ΪJSONArray����ż�ǲ��ܹ�ֱ�ӽ����鴫��ģ��Ƚ�����toJSONStringȻ���ٽ�����ַ�������parseArray
		JSONArray jarr = JSON.parseArray(arrJsonSrt);
		jarr.forEach(System.out::println);	
		
		// ����������json�Ļ���ת��
		// ��Listת��Ϊ����һ��
		
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
		
		 //JSON -> Map ��Ҫ����ǿ��ת��
		Map<String ,TestPerson> rMap =(Map<String ,TestPerson> ) JSON.parse(mapJsonStr);
		rMap.keySet().stream().forEach(System.out::println);
		
	}
	/**
	 * �򵥵�Javaʾ����Strings�б�ת��Ϊ��д��
	 */
	public static void testLambda() {
		List<String> alpha = Arrays.asList("a","b","c");
		// ����ֱ��ʹ��
		alpha.forEach(System.out::println);
		// ��һ����
		alpha.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
		alpha.stream().map(String::toUpperCase).forEach(System.out::println);
		
		// ����ÿһ������ƽ��
		Arrays.asList(1,3,4,5).stream().map(n->n*n).forEach(System.out::println);		
	}
	public static void main(String[] args) {
		jsonStr2Bean();
//		testLambda();
	}
}
