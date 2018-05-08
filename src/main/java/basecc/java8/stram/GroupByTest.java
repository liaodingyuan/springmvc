/**
 * 
 */
package basecc.java8.stram;

/**
* <p>Title:GroupByTest </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2018年5月8日
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class GroupByTest {

    private int id;
    private String sex;
    private String name;

    public static void main(String[] args) {
        List<GroupByTest> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
        	GroupByTest groupbyTarget = new GroupByTest();
            groupbyTarget.setId(i);
            groupbyTarget.setSex(i % 2 == 0 ? "男" : "女");
            groupbyTarget.setName("zhangsan" + i);
            list.add(groupbyTarget);
        }
        //将所有的学生按照性别进行分组
        Map<String, List<GroupByTest>> collect = list.stream().collect(Collectors.groupingBy(GroupByTest::getSex));

        //用方法引用可读性更好
        Map<String, List<GroupByTest>> collect2 = list.stream().collect(groupingBy(GroupByTest::getSex));

        //按照Id分组
        Map<Integer, List<GroupByTest>> collect3 = list.stream().collect(groupingBy(GroupByTest::getId));

        //自定义函数分组
        Map<Integer, List<GroupByTest>> collect4 = list.stream().collect(groupingBy(stu -> stu.hashCode() % 5));

        System.out.println(collect);
        System.out.println(collect2);
        System.out.println(collect3);
        System.out.println(collect4);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
