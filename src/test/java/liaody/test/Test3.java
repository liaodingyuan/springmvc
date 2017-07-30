/**
 * 
 */
package liaody.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.entity.Order;
import liaody.utils.MyBatisUtil;

/**
 * <p>
 * Title:Test3
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月29日
 */
public class Test3 {

	@Test
	public void testGetOrderById() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * liaody.entity.mapper.OrderMapper是OrderMapper.xml文件中mapper标签的namespace属性的值，
		 * getUser1是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUser1";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Order对象返回
		Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(order);// 打印结果：null，也就是没有查询出相应的记录
	}

	@Test
	public void testGetOrderById2() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * liaody.entity.mapper.OrderMapper是OrderMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserUseAliase是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUserUseAliase";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Order对象返回
		Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
	}

	@Test
	public void testGetOrderById3() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		/**
		 * 映射sql的标识字符串，
		 * liaody.entity.mapper.OrderMapper是OrderMapper.xml文件中mapper标签的namespace属性的值，
		 * getUserUseResultType是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
		 */
		String statement = "liaody.entity.mapper.OrderMapper.getUserUseResultType";// 映射sql的标识字符串
		// 执行查询操作，将查询结果自动封装成Order对象返回
		Order order = sqlSession.selectOne(statement, 1);// 查询orders表中id为1的记录
		// 使用SqlSession执行完SQL之后需要关闭SqlSession
		sqlSession.close();
		System.out.println(order);// 打印结果：Order [id=1, orderNo=aaaa, price=23.0]
	}
}
