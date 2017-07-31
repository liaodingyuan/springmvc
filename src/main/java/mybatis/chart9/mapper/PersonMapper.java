/**
 * 
 */
package mybatis.chart9.mapper;

import mybatis.chart9.domain.Person;

/**
* <p>Title:PersonMapper </p>
* <p>Description:Mybatis 官方手册建议通过接口的代理对象访问Mybatis </p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月30日
*/
public interface PersonMapper {

	/**
	 * 根据id查询person。
	 * 方法名和参数名必须和xml配置文件中的select语句的id属性和parameterType的值一样。
	 * 才能够定位到xml中的sql语句。
	 * @param id
	 * @return
	 */
	Person selectPersonById(Integer id);
}
