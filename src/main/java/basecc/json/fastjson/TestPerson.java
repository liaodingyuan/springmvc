/**
 * 
 */
package basecc.json.fastjson;

/**
* <p>Title:TestPerson </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018Äê5ÔÂ7ÈÕ
*/
public class TestPerson {

	private int age;
    private String name;
     
    public TestPerson(){
         
    }
    
    public TestPerson(String name ,int age) {
    	this.name = name;
    	this.age = age;
    }
     
    public TestPerson(int age,String name){
        this.age=age;
        this.name=name;
    }
     
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString () {
    	return this.name+"::::"+this.age;
    }
}
