package test.whileBean.bean1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class Student {
	
	
	
    @Autowired
    private Teacher teacher;

    public Student (Teacher teacher) {
        System.out.println("Student init1:" + teacher);
    }

    public void learn () {
        System.out.println("Student learn");
    }
}