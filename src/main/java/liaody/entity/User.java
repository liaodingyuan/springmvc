/**
 * 
 */
package liaody.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

/**
* <p>Title:User </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017Äê7ÔÂ16ÈÕ
*/
@Repository("user")
public class User implements Serializable{
	
	private String loginname;
	private Date birthDay;
	private String email;
	public User() {
		super();
	}
	/**
	 * @return the loginname
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * @param loginname the loginname to set
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDay;
	}
	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [loginname=" + loginname + ", birthDay=" + birthDay + ", email=" + email + "]";
	}
	
	

}
