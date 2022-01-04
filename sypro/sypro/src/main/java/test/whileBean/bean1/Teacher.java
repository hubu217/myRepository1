package test.whileBean.bean1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class Teacher {
	
	
	
    @Autowired
    private Student student;

    public Teacher (Student student) {
        System.out.println("Teacher init1:" + student);

    }

    public void teach () {
        System.out.println("teach:");
        student.learn();
    }
}