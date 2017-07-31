/**
 * 
 */
package liaody.test;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import liaody.entity.Classes;
import liaody.utils.MyBatisUtil;

/**
* <p>Title:TestOneToOne </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��7��29��
*/
public class TestOneToOne {
	
	 @Test
	    public void testGetClass(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getClass��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "liaody.entity.mapper.ClassMapper.getClass";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
	        Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	    }
	    
	    @Test
	    public void testGetClass2(){
	        SqlSession sqlSession = MyBatisUtil.getSqlSession();
	        /**
	         * ӳ��sql�ı�ʶ�ַ�����
	         * me.gacl.mapping.classMapper��classMapper.xml�ļ���mapper��ǩ��namespace���Ե�ֵ��
	         * getClass2��select��ǩ��id����ֵ��ͨ��select��ǩ��id����ֵ�Ϳ����ҵ�Ҫִ�е�SQL
	         */
	        String statement = "liaody.entity.mapper.ClassMapper.getClass2";//ӳ��sql�ı�ʶ�ַ���
	        //ִ�в�ѯ����������ѯ����Զ���װ��Classes���󷵻�
	        Classes clazz = sqlSession.selectOne(statement,1);//��ѯclass����idΪ1�ļ�¼
	        //ʹ��SqlSessionִ����SQL֮����Ҫ�ر�SqlSession
	        sqlSession.close();
	        System.out.println(clazz);//��ӡ�����Classes [id=1, name=class_a, teacher=Teacher [id=1, name=teacher1]]
	    }

}