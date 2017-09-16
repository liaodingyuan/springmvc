/**
 * 
 */
package basecc.pattern.future;

/**
* <p>Title:Client </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017年9月3日
*/
public class Client {

	public static void main(String[] args) {
		
	}
	public Data request(final String querStr) {
		final FutureData future = new FutureData();
		// 匿名内部类
		new Thread(){
			public void run() {
			RealData realdata = new RealData(querStr);
			future.setResult(realdata);
				
			}
		}.start();
	return null;
	}
}
