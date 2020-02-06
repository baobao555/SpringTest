
import com.baobao.springtest.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author baobao
 * @create 2020-01-20 11:22
 * @description
 */
public class AopTest {


    @Test
    public void testAopAnnotation(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aopAnnotation.xml");
        Calculator calculator = context.getBean("calculator", Calculator.class);
        calculator.add(1, 2);
        calculator.div(10, 0);
    }

    @Test
    public void testAopXmlConfig(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-aopXml.xml");
        com.baobao.springtest.aop.xml.Calculator calculator = context.getBean("calculator", com.baobao.springtest.aop.xml.Calculator.class);
        calculator.sub(10, 5);
        calculator.div(5, 0);
    }
}
