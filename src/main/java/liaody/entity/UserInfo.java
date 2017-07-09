/**
 * 
 */
package liaody.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

/**
* <p>Title:UserInfo </p>
* <p>Description:用户对象实体类 </p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月9日
*/
@Repository
public class UserInfo implements Serializable{


	private static final long serialVersionUID = 869386680479362227L;

	private String username;
	private String password;
	private String userEmail;
	private int userId;
	/**
	 * default constructor
	 */
	public UserInfo() {
		
	}
//	private 
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}
	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
