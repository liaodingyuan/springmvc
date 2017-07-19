/**
 * 
 */
/**
* <p>Title:package-info </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年7月18日
*/
package liaody.chart6;



/**
数据的绑定，转换，验证

6.1数据绑定流程

ServletRequest、处理方法的入参对象-》DataBinder-》ConversionService(还负责填装请求 参数到入参对象中去)-》Validator->BindingResult

数据转换：java.beans包提供了有一个PropertyEditor接口来进行数据转换。缺点是只能够从String转换到Object。
不能够直接对任意两个对象进行数据转换。


从spring3.0开始添加了数据转换模块
ConversionService接口一共有四个方法：
	boolean canConvert(Class<?> sourceType, Class<?> targetType);
	boolean canConvert(TypeDescriptor sourceType, TypeDescriptor targetType);
	<T> T convert(Object source, Class<T> targetType);
	Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType);

首先在spring-mvc中装配一个ConversionServiceFactoryBean，并覆盖它的converters属性
<!-- 装配自定义的类型转换器 ,注意注解驱动需要加上conversion-service -->
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
	
spring支持的类型转换器一共三种：
Converter<S,T>:最简单只有一个 T convert(S source)方法负责将类型为S的对象转换为类型为T的对象。
ConverterFactory<S,R>:将相同系列的拖个Converter封装在一起。该接口中只有一个方法：
	<T extends R> Converter<S,T> getConverter(Class<T> targetType);
	S:转换的源类型，R：目标类型的基类，T为R的子类
GenericConverter：
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