package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Resource
    private StudentRepository studentRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Student student = new Student(
                "000-61-0001",
                "Anna",
                "Lynn",
                "Smith",
                3.45,
                LocalDate.of(2019, 5, 24)
        );
        saveStudent(student);
    }

    void saveStudent(Student student) {
        studentRepository.save(student);
    }
}
