/**
 * 
 */
package liaody.entity.mapper;

import java.util.List;

import liaody.entity.UserInfo;

/**
* <p>Title:ManyDataMapper </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018��3��8��
*/
public interface ManyDataMapper {
	/**
	 *  �����ݲ����ڵ�ʱ���ִ�в����������������ݾ͸��£�ʹ����������
	 * @param manyDataList
	 */
	public void saveOrUpdateDate(List<UserInfo> manyDataList);

}
