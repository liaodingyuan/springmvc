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
 * @date 2018��5��8��
 */
public class FastJTest {
	// json�ַ���-�򵥶�����
	private static final String JSON_OBJ_STR = "{\"studentName\":\"lily\",\"studentAge\":12}";
	// json�ַ���-��������
	private static final String JSON_ARRAY_STR = "[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]";
	// ���Ӹ�ʽjson�ַ���
	private static final String COMPLEX_JSON_STR = "{\"teacherName\":\"crystall\",\"teacherAge\":27,\"course\":{\"courseName\":\"english\",\"code\":1270},\"students\":[{\"studentName\":\"lily\",\"studentAge\":12},{\"studentName\":\"lucy\",\"studentAge\":15}]}";

	// ��һ���֣�JSON��ʽ�ַ�����JSON����֮���ת��
	/**
	 * json�ַ���-�򵥶����͵�JSONObject��ת��
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
	 * JSONObject��json�ַ���-�򵥶����͵�ת��
	 */
	@Test
	public void testJSONObjectToJSONStr() {

		// ��֪JSONObject,Ŀ��Ҫת��Ϊjson�ַ���
		JSONObject jsonObject = JSONObject.parseObject(JSON_OBJ_STR);
		// ��һ�ַ�ʽ
		System.out.println(jsonObject.toJSONString());
		// �ڶ��ַ�ʽ
		System.out.println(JSONObject.toJSON(jsonObject));
	}

	/**
	 * json�ַ���-�������͵�JSONArray��ת��
	 */
	@Test
	public void testJSONStrToJSONArray() {
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		jsonArray.forEach(System.out::println);
	}

	/**
	 * JSONArray��json�ַ���-�������͵�ת��
	 */
	@Test
	public void testJSONArrayToJSONStr() {
		JSONArray jsonArray = JSONArray.parseArray(JSON_ARRAY_STR);
		// ���ֵȼ۵ķ���
		System.out.println(jsonArray.toJSONString());
		System.out.println(JSONArray.toJSONString(jsonArray));
	}

	/**
	 * ����json��ʽ�ַ�����JSONObject��ת��
	 */
	@Test
	public void testComplexJSONStrToJSONObject() {
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
		// ��������teacherName���ַ�������
		String teacherName = jsonObject.getString("teacherName");
		// ��������teacherAge����������
		Integer teacherAge = jsonObject.getInteger("teacherAge");
		System.out.println("teacherName:" + teacherName + " teacherAge:" + teacherAge);

		// �����������һ������
		JSONObject jsonObjectCourse = jsonObject.getJSONObject("course");
		// ��ȡJSONObject�е�����
		String courseName = jsonObjectCourse.getString("courseName");
		int code = jsonObjectCourse.getIntValue("code");// getInteger����Ҳ����
		System.out.println("courseName��" + courseName + " code:" + code);

		// �����������һ������
		JSONArray jsonArraystudents = jsonObject.getJSONArray("students");
		jsonArraystudents.forEach(System.out::println);
	}

	/**
	 * ����JSONObject��json��ʽ�ַ�����ת��
	 */
	@Test
	public void testJSONObjectToComplexJSONStr() {
		// ����JSONObject,Ŀ��Ҫת��Ϊjson�ַ���
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);

		// ��һ�ַ�ʽ
		// String jsonString = JSONObject.toJSONString(jsonObject);

		// �ڶ��ַ�ʽ
		String jsonString = jsonObject.toJSONString();
		System.out.println(jsonString);
	}

	// �ڶ����֣�JSON��ʽ�ַ�����javaBean֮���ת��
	/**
	 * json�ַ���-�򵥶���JavaBean֮���ת��
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
	 * json�ַ���-�������͵�JavaBean_List��ת��
	 */
	@Test
	public void testJSONStrToJavaBeanList() {
		JSONObject jsonObject = JSONObject.parseObject(COMPLEX_JSON_STR);
		JSONArray jsonArray = jsonObject.getJSONArray("students");
		 //����JSONArray.��˼�������ʹ��stream��ô���д���
	    List<Student> students = new ArrayList<Student>();
	    Student student = null;
		 for (Object object : jsonArray) {

		        JSONObject jsonObjectone = (JSONObject) object;
		        String studentName = jsonObjectone.getString("studentName");
		        Integer studentAge = jsonObjectone.getInteger("studentAge");
		        student = new Student(studentName,studentAge);
		        students.add(student);
		    }
		 
		//�ڶ��ַ�ʽ,ʹ��TypeReference<T>��,�����乹�췽��ʹ��protected��������,�ʴ���������
		    List<Student> studentList = JSONArray.parseObject(JSON_ARRAY_STR, new TypeReference<ArrayList<Student>>() {});
		    System.out.println("studentList:  " + studentList);
		    
		  //�����ַ�ʽ,ʹ��Gson��˼��
		    List<Student> studentList1 = JSONArray.parseArray(JSON_ARRAY_STR, Student.class);
		    System.out.println("studentList1:  " + studentList1);
	}
}