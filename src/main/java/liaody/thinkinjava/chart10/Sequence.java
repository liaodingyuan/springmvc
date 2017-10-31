/**
 * 
 */
package liaody.thinkinjava.chart10;

/**
* <p>Title:Sequence </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017Äê10ÔÂ29ÈÕ
*/
public class Sequence {
	
	private Object[] item;
	private int next;
	public Sequence(final int size) {
		item = new Object[size];
	}
	public void add(Object x) {
		if(next<item.length) {
			item[next++] = x;
		}
	}
	private class SquenceSelector implements  Selector{

		private int i =0;
		
		@Override
		public boolean end() {
		return i == item.length;
		}

		@Override
		public Object current() {
			return item[i];
		}

		@Override
		public void next() {
			if(i<item.length) {
				i++;
			}
		}		
	}
	
	public Selector selector() {
		return new SquenceSelector();
	}
	public static void main(String[] srgs) {
		Sequence sequence = new Sequence(10);
		for(int index=
				0;index<10;index++) {
			sequence.add(Integer.toString(index));
		}
		Selector selector = sequence.selector(); 
		while(!selector.end()) {
			System.out.println(selector.current());
			selector.next();
		}
	}

}
