/**
 * 
 */
package mybatis.chart9.mapper;

import mybatis.chart9.domain.Person;

/**
* <p>Title:PersonMapper </p>
* <p>Description:Mybatis �ٷ��ֲὨ��ͨ���ӿڵĴ���������Mybatis </p>
* <p>Company: </p>
* @author liaody
* @date 2017��7��30��
*/
public interface PersonMapper {

	/**
	 * ����id��ѯperson��
	 * �������Ͳ����������xml�����ļ��е�select����id���Ժ�parameterType��ֵһ����
	 * ���ܹ���λ��xml�е�sql��䡣
	 * @param id
	 * @return
	 */
	Person selectPersonById(Integer id);
}
