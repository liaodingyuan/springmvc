/**
 * 
 */
package redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
* <p>Title:RedisTest </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018��3��11��
*/
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate redisTemplate;

	@Test
	public void testSpringRedis() {
		
		  ApplicationContext ac =  new ClassPathXmlApplicationContext("classpath:/spring-mvc.xml");
		// StringRedisTemplate�Ĳ���
		// String��д
		redisTemplate.delete("myStr");
		redisTemplate.opsForValue().set("myStr","skyLine");
		
		System.out.println(redisTemplate.opsForValue().get("myStr"));
		System.out.println("----------");	
		
	}
}
