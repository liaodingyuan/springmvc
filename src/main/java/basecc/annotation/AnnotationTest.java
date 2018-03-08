package basecc.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
	String[] value() default "unknown";
}

class Person {
	public Person() {

	}

	@MyAnnotation
	@Deprecated
	public void empty() {
		System.out.println("\nempty");

	}

	@MyAnnotation(value = { "girl", "boy" })
	public void somebody(String name, int age) {
		System.out.println("\nsomebody: " + name + ", " + age);
	}
}

/**
 * <p>
 * Title:AnnotationTest
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author liaody
 * @date 2018Äê1ÔÂ23ÈÕ
 */
public class AnnotationTest {

	public static void main(String[] args) {

	}
}
