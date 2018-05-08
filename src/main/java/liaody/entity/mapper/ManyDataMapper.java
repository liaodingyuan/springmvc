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
* @date 2018年3月8日
*/
public interface ManyDataMapper {
	/**
	 *  当数据不存在的时候就执行插入操作，如果有数据就更新，使用批量更新
	 * @param manyDataList
	 */
	public void saveOrUpdateDate(List<UserInfo> manyDataList);

}
