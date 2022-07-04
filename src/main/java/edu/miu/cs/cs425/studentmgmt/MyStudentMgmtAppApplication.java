package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private TranscriptRepository transcriptRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Transcript bsComputerScienceProgram = new Transcript("BS Computer Science");
        Transcript msComputerScienceProgram = new Transcript("MS Computer Science");
        transcriptRepository.saveAll(List.of(bsComputerScienceProgram, msComputerScienceProgram));

        Student student = new Student(
                "000-61-0001",
                "Anna",
                "Lynn",
                "Smith",
                3.45,
                LocalDate.of(2019, 5, 24)
        );
        student.setTranscripts(Set.of(bsComputerScienceProgram, msComputerScienceProgram));
        student = saveStudent(student);
        studentRepository.save(student);
        out.println(student);

    }

    Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
}
