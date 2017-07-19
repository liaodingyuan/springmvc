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
 * Description:ʹ��Spring�Դ�����֤���
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2017��7��16��
 */
// ʵ�ֵ���spring��validatoir�ӿ�
@Repository("userValidator")
public class UserValidartor implements Validator {
	/**
	 * default constructor
	 */
	public UserValidartor() {

	}

	// ��У�����ܹ���class���͵Ķ������ת��
	@Override
	public boolean supports(Class<?> clazz) {

		// Userָ��Class��������ʾ������߽ӿ��Ƿ���ͬ�������Ƿ����䳬����߳��ӿ�
		return User.class.isAssignableFrom(clazz);

	}

	/**
	 * ��target������֤���������װ��error����
	 */
	@Override
	public void validate(Object target, Errors errors) {
//		ʹ��ValidationUtils.rejectIfEmpty�����зǿ���֤
		ValidationUtils.rejectIfEmpty(errors, "loginname", null,"��¼�����ܹ���Ϊ��");
		ValidationUtils.rejectIfEmpty(errors, "email", null,"���벻�ܹ�Ϊ��");
		 User user = (User)target;
		 if(user.getLoginname().length()>10) {
			 errors.rejectValue("loginname",null,"�û������ܹ�����10�ַ�");
		 }


	}

}
