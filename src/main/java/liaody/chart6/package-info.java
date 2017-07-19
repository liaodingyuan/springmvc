/**
 * 
 */
/**
* <p>Title:package-info </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017��7��18��
*/
package liaody.chart6;



/**
���ݵİ󶨣�ת������֤

6.1���ݰ�����

ServletRequest������������ζ���-��DataBinder-��ConversionService(��������װ���� ��������ζ�����ȥ)-��Validator->BindingResult

����ת����java.beans���ṩ����һ��PropertyEditor�ӿ�����������ת����ȱ����ֻ�ܹ���Stringת����Object��
���ܹ�ֱ�Ӷ��������������������ת����


��spring3.0��ʼ���������ת��ģ��
ConversionService�ӿ�һ�����ĸ�������
	boolean canConvert(Class<?> sourceType, Class<?> targetType);
	boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType);
	<T> T convert(Object source, Class<T> targetType);
	Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);

������spring-mvc��װ��һ��ConversionServiceFactoryBean������������converters����
<!-- װ���Զ��������ת���� ,ע��ע��������Ҫ����conversion-service -->
	<bean id="conversionService"
		class="org.springframework.context.support.ConversionServiceFactoryBean">

		<property name="converters">
			<list>
				<bean class="liaody.converter.StringToDateConverter"
					p:datePattern="yyyy-mm-dd"></bean>
			</list>
		</property>
	</bean>
	
	public class StringToDateConverter implements Converter<String,Date>
	
spring֧�ֵ�����ת����һ�����֣�
Converter<S,T>:���ֻ��һ�� T convert(S source)������������ΪS�Ķ���ת��Ϊ����ΪT�Ķ���
ConverterFactory<S,R>:����ͬϵ�е��ϸ�Converter��װ��һ�𡣸ýӿ���ֻ��һ��������
	<T extends R> Converter<S,T> getConverter(Class<T> targetType);
	S:ת����Դ���ͣ�R��Ŀ�����͵Ļ��࣬TΪR������
GenericConverter��
	Set<ConvertiblePair> getConvertibleTypes();
	Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);
	final class ConvertiblePair {
		private final Class<?> sourceType;
		private final Class<?> targetType;	
		public ConvertiblePair(Class<?> sourceType, Class<?> targetType) {
			Assert.notNull(sourceType, "Source type must not be null");
			Assert.notNull(targetType, "Target type must not be null");
			this.sourceType = sourceType;
			this.targetType = targetType;
		}
		public Class<?> getSourceType() {
			return this.sourceType;
		}
		public Class<?> getTargetType() {
			return this.targetType;
		}
		@Override
		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (other == null || other.getClass() != ConvertiblePair.class) {
				return false;
			}
			ConvertiblePair otherPair = (ConvertiblePair) other;
			return (this.sourceType == otherPair.sourceType && this.targetType == otherPair.targetType);
		}
		@Override
		public int hashCode() {
			return (this.sourceType.hashCode() * 31 + this.targetType.hashCode());
		}
		@Override
		public String toString() {
			return (this.sourceType.getName() + " -> " + this.targetType.getName());
		}
	}













*/