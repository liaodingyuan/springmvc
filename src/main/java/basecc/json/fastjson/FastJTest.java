/**
 * 
 */
package basecc.json.fastjson;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

/**
 * <p>
 * Title:FastJTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018年5月8日
 */
public class FastJTest {
	// json字符串-简单对象型
	private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
	// json字符串-数组类型
	private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
	// 复杂格式json字符串
	private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

	// 第一部分：JSON格式字符串与JSON对象之间的转换
	/**
	 * json字符串-简单对象型到JSONObject的转换
	 */
	@Test
	public void testJSONStrToJSONObject() {

		JSONObject json = JSON.parseObject(JSON_OBJ_STR);
		System.out
				.println("student's name:" + json.getString("studentName") + " age:" + json.getIntValue("studentAge"));
		JSONObject json2 = JSONObject.parseObject(JSON_OBJ_STR);
		System.out.println(
				"student's name:" + json2.getString("studentName") + " age:" + json2.getIntValue("studentAge"));
	}

	/**
	 * JSONObject到json字符串-简单对象型的转换
	 */
	@Test
	public void testJSONObjectToJSONStr() {

		// 已知JSONObject,目标要转换为json字符串
		JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
		// 第一种方式
		System.out.println(jsonObject.toJSONString());
		// 第二种方式
		System.out.println(JSONObject.toJSON(jsonObject));
	}

	/**
	 * json字符串-数组类型到JSONArray的转换
	 */
	@Test
	public void testJSONStrToJSONArray() {
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		jsonArray.forEach(System.out::println);
	}

	/**
	 * JSONArray到json字符串-数组类型的转换
	 */
	@Test
	public void testJSONArrayToJSONStr() {
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		// 两种等价的方法
		System.out.println(jsonArray.toJSONString());
		System.out.println(JSONArray.toJSONString(jsonArray));
	}

	/**
	 * 复杂json格式字符串到JSONObject的转换
	 */
	@Test
	public void testComplexJSONStrToJSONObject() {
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
		// 对象属性teacherName是字符串类型
		String teacherName = jsonObject.getString("teacherName");
		// 对象属性teacherAge是整数类型
		Integer teacherAge = jsonObject.getInteger("teacherAge");
		System.out.println("teacherName:" + teacherName + " teacherAge:" + teacherAge);

		// 对象的属性是一个对象
		JSONObject jsonObjectCourse = jsonObject.getJSONObject("course");
		// 获取JSONObject中的数据
		String courseName = jsonObjectCourse.getString("courseName");
		int code = jsonObjectCourse.getIntValue("code");// getInteger方法也可以
		System.out.println("courseName：" + courseName + " code:" + code);

		// 对象的属性是一个数组
		JSONArray jsonArraystudents = jsonObject.getJSONArray("students");
		jsonArraystudents.forEach(System.out::println);
	}

	/**
	 * 复杂JSONObject到json格式字符串的转换
	 */
	@Test
	public void testJSONObjectToComplexJSONStr() {
		// 复杂JSONObject,目标要转换为json字符串
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

		// 第一种方式
		// String jsonString = JSONObject.toJSONString(jsonObject);

		// 第二种方式
		String jsonString = jsonObject.toJSONString();
		System.out.println(jsonString);
	}

	// 第二部分：JSON格式字符串与javaBean之间的转换
	/**
	 * json字符串-简单对象到JavaBean之间的转换
	 */
	@Test
	public void testJSONStrToJavaBeanObj() {
		JSONObject jsonObject = JSON.parseObject(JSON_OBJ_STR);		
		//JSONObject.parseObject(JSON_OBJ_STR, Student.class);
		Student s1 =JSONObject.parseObject(jsonObject.toJSONString(), Student.class);
		System.out.println(s1.toString());
		System.out.println("test"==("te"+"st"));		
	}

	/**
	 * json字符串-数组类型到JavaBean_List的转换
	 */
	@Test
	public void testJSONStrToJavaBeanList() {
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
		JSONArray jsonArray = jsonObject.getJSONArray("students");
		 //遍历JSONArray.（思考：如果使用stream怎么进行处理）
	    List<Student> students = new ArrayList<Student>();
	    Student student = null;
		 for (Object object : jsonArray) {

		        JSONObject jsonObjectone = (JSONObject) object;
		        String studentName = jsonObjectone.getString("studentName");
		        Integer studentAge = jsonObjectone.getInteger("studentAge");
		        student = new Student(studentName,studentAge);
		        students.add(student);
		    }
		 
		//第二种方式,使用TypeReference<T>类,由于其构造方法使用protected进行修饰,故创建其子类
		    List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
		    System.out.println("studentList:  " + studentList);
		    
		  //第三种方式,使用Gson的思想
		    List<Student> studentList1 = JSONArray.parseArray(JSON_ARRAY_STR, Student.class);
		    System.out.println("studentList1:  " + studentList1);
	}
}