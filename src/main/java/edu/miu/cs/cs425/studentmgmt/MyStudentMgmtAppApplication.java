package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.lang.System.out;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Resource
    private StudentRepository studentRepository;

    @Resource
    private TranscriptRepository transcriptRepository;

    @Resource
    private ClassroomRepository classroomRepository;


    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Classroom m115 = new Classroom("McLaughlin Building", "M115");
        Classroom m116 = new Classroom("McLaughlin Building", "M116");
        classroomRepository.saveAll(Set.of(m115, m116));

        Student anna = new Student(
                "000-61-0001",
                "Anna",
                "Lynn",
                "Smith",
                3.45,
                LocalDate.of(2019, 5, 24)
        );
        Student bell = new Student(
                "000-61-0002",
                "Bell",
                "Lynn",
                "Smith",
                4,
                LocalDate.of(2019, 5, 24)

        );
        saveStudent(anna);
        saveStudent(bell);

        Transcript bsComputerScienceProgramAnna = new Transcript("BS Computer Science", anna);
        Transcript msComputerScienceProgramAnna = new Transcript("MS Computer Science", anna);
        Transcript msComputerScienceProgramBell = new Transcript("MS Computer Science", bell);
        transcriptRepository.saveAll(List.of(bsComputerScienceProgramAnna, msComputerScienceProgramAnna));
        transcriptRepository.save(msComputerScienceProgramBell);


    }

    void saveStudent(Student student) {
        studentRepository.save(student);
    }



    public static <T> Set<T> convertListToSet(List<T> list) {
        Set<T> set = new HashSet<>();
        for (T t : list)
            set.add(t);
        return set;
    }
}
