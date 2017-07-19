/**
 * 
 */
package liaody.validation.spring;

import org.springframework.stereotype.Repository;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import liaody.entity.User;

/**
 * <p>
 * Title:UserValidation
 * </p>
 * <p>
 * Description:使用Spring自带的验证框架
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017年7月16日
 */
// 实现的是spring的validatoir接口
@Repository("userValidator")
public class UserValidartor implements Validator {
	/**
	 * default constructor
	 */
	public UserValidartor() {

	}

	// 该校验器能够对class类型的对象进行转换
	@Override
	public boolean supports(Class<?> clazz) {

		// User指定Class参数锁表示的类或者接口是否相同，或者是否是其超类或者超接口
		return User.class.isAssignableFrom(clazz);

	}

	/**
	 * 对target进行验证，将结果封装在error里面
	 */
	@Override
	public void validate(Object target, Errors errors) {
//		使用ValidationUtils.rejectIfEmpty来进行非空验证
		ValidationUtils.rejectIfEmpty(errors, "loginname", null,"登录名不能够不为空");
		ValidationUtils.rejectIfEmpty(errors, "email", null,"密码不能够为空");
		 User user = (User)target;
		 if(user.getLoginname().length()>10) {
			 errors.rejectValue("loginname",null,"用户名不能够超过10字符");
		 }


	}

}
