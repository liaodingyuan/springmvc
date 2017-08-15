/**
 * 
 */
package basecc.pattern.strategy;

/**
* <p>Title:Strategy </p>
* <p>Description:
* 抽象角色，通常由一个借口或者一个抽象类实现。
* 含有具体的策略所需要的接口。  
*  </p>
* <p>Company: </p>
* @author liaody
* @date 2017年8月11日
*/
public interface Strategy {

//	策略方法，具体的策略类会提报的实现
	void strategyInterface();
}
