package test.whileBean.bean2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Student {
	
	
	
    @Autowired
    private Teacher teacher;

    public Student () {
        System.out.println("Student init:" + teacher);
    }

    public void learn () {
        System.out.println("Student learn");
    }
}