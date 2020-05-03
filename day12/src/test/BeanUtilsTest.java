package test;

import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsTest {
    @Test
    public void test(){
        User user = new User();
        /*
            是这样的：在User中，他这个属性是怎么来的呢？现在假设private String gender；Getter and Setter ；如果你将gender的Getter and Setter 自己改为
            gethehe(String gender){this.gender = gender}，他的属性是 hehe ，而成员变量是 gender
            他截取规则是 去掉get、set，剩下全部小写，留下来的就是属性，属性一般和成员变量名一样，你【不做骚操作】，自己写Getter and Setter就一般没事
            BeanUtils重要的populate中也就调用了setProperty()
         */

        try {
            //  参数：对象、【属性】名、属性值
            BeanUtils.setProperty(user,"username","zhangsan");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
