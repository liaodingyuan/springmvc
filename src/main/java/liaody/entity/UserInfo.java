/**
 * 
 */
package liaody.entity;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * Title:UserInfo
 * </p>
 * <p>
 * Description:用户对象实体类。 *
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月9日
 */
// 使用JSR303注解对数据域进行验证，由hibernate-validator实现
@Repository
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 869386680479362227L;

	/** 数据库自行分配的用户id */
	private int userId;
	/** 用户名 */
	@NotBlank(message = "用户名不能够为空")
	@Length(min = 6, max = 18, message = "用户名长度必须大于等于6字符，小于等于15字符")
	private String username;
	/** 用户密码 */
	@NotBlank(message = "密码不能够为空")
	@Length(min = 6, max = 18, message = "密码长度必须大于等于6字符，小于等于15字符")
	private String password;
	/** 用户邮件 */
	@NotBlank(message = "邮件地址不能够为空")
	@Email(message = "请输入合法的邮箱地址")
	private String userEmail;
	/** 用户出生日期 */
//	// @Past 验证birthDay是否在当前对象之前
//	@Past
//	private Date birthDay;
	/** 用户年龄 */
	@Range(min = 18, max = 60, message = "用户年龄需在18到60岁之间")
	private int age;
//	/** 用户头像 */
//	private MultipartFile profilePicture;
	public UserInfo() {
		
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username =  username==null?username:username.trim();
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password==null?null:password.trim();
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return userEmail;
	}

	/**
	 * @param userEmail
	 *            the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail==null?null:userEmail.trim();
	}

//	/**
//	 * @return the birthDay
//	 */
//	public Date getBirthDay() {
//		return birthDay;
//	}
//
//	/**
//	 * @param birthDay
//	 *            the birthDay to set
//	 */
//	public void setBirthDay(Date birthDay) {
//		this.birthDay = birthDay;
//	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

//	/**
//	 * @return the profilePicture
//	 */
//	public MultipartFile getProfilePicture() {
//		return profilePicture;
//	}
//
//	/**
//	 * @param profilePicture
//	 *            the profilePicture to set
//	 */
//	public void setProfilePicture(MultipartFile profilePicture) {
//		this.profilePicture = profilePicture;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
//	@Override
//	public String toString() {
//		return "UserInfo [userId=" + userId + ", username=" + username + ", password=" + password + ", userEmail="
//				+ userEmail + ", birthDay=" + birthDay + ", age=" + age + ", profilePicture=" + profilePicture + "]";
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + age;
//		result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
//		result = prime * result + ((password == null) ? 0 : password.hashCode());
//		result = prime * result + ((profilePicture == null) ? 0 : profilePicture.hashCode());
//		result = prime * result + ((userEmail == null) ? 0 : userEmail.hashCode());
//		result = prime * result + userId;
//		result = prime * result + ((username == null) ? 0 : username.hashCode());
//		return result;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserInfo other = (UserInfo) obj;
		if (age != other.age)
			return false;
//		if (birthDay == null) {
//			if (other.birthDay != null)
//				return false;
//		} else if (!birthDay.equals(other.birthDay))
//			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
//		if (profilePicture == null) {
//			if (other.profilePicture != null)
//				return false;
//		} else if (!profilePicture.equals(other.profilePicture))
//			return false;
		if (userEmail == null) {
			if (other.userEmail != null)
				return false;
		} else if (!userEmail.equals(other.userEmail))
			return false;
		if (userId != other.userId)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", username=" + username + ", password=" + password + ", userEmail="
				+ userEmail + ", age=" + age + "]";
	}

}
