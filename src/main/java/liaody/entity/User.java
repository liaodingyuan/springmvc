/**
 * 
 */
package liaody.entity;

import java.io.File;
import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
* <p>Title:User </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月16日
*/
@Repository("user")
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loginname;
	private Date birthDay;
	private String email;
	/** 对应上传文件件的类型是MultipartFile*/
	private MultipartFile image;
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
	/**
	 * @return the image
	 */
	public MultipartFile getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	

}
