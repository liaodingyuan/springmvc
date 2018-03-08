/**
 * 
 */
package basecc.pattern.proxy.dynamicProxy.impl;

import com.itextpdf.text.log.SysoCounter;

import basecc.pattern.proxy.dynamicProxy.UserMgr;

/**
* <p>Title:UserMgrImpl </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê1ÔÂ21ÈÕ
*/
public class UserMgrImpl implements UserMgr{

	@Override
	public void addUser() {
		System.out.println("add user");
		
	}

	@Override
	public void delUser() {
		System.out.println("delete user");
		
	}

}
