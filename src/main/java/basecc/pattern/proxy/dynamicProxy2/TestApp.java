/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy2;

/**
* <p>Title:TestApp </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê1ÔÂ22ÈÕ
*/
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import basecc.pattern.proxy.dynamicProxy2.service.UserService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/leige/proxy/beans.xml")
public class TestApp {
	@Autowired
	UserService userService;
	@Test
	public void test() {
		userService.addUser();
	}
}
