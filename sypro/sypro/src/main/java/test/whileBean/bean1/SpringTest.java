package test.whileBean.bean1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScanConfig.class);
        Teacher teacher = applicationContext.getBean(Teacher.class);
        teacher.teach();

    }
}