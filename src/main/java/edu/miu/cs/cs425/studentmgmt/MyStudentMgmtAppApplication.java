package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Set;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Resource
    private StudentService studentService;

    @Resource
    private TranscriptService transcriptService;

    @Resource
    private ClassroomService classroomService;


    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        saveClassroom();
        Student anna = getStudent("000-61-0001", "Anna", "Lynn",
                "Smith", 3.45, LocalDate.of(2019, 5, 24));
        Student bell = getStudent("000-61-0002", "Bell", "",
                "Hadid", 4, LocalDate.of(1990, 4, 20));
        saveStudent(anna);
        saveStudent(bell);
        saveTranscripts(anna, bell);
    }

    private void saveTranscripts(Student anna, Student bell) {
        Transcript bsComputerScienceProgramAnna = new Transcript("BS Computer Science", anna);
        Transcript msComputerScienceProgramAnna = new Transcript("MS Computer Science", anna);
        Transcript msComputerScienceProgramBell = new Transcript("MS Computer Science", bell);
        transcriptService.saveAllTranscripts(Set.of(bsComputerScienceProgramAnna, msComputerScienceProgramAnna));
        transcriptService.saveTranscript(msComputerScienceProgramBell);
    }

    private Student getStudent(String studentNumber, String firstName, String middleName, String lastName, double cgpa, LocalDate birthDate) {
        return new Student(
                studentNumber,
                firstName,
                middleName,
                lastName,
                cgpa,
                birthDate
        );
    }

    private void saveClassroom() {
        Classroom m115 = new Classroom("McLaughlin Building", "M115");
        Classroom m116 = new Classroom("McLaughlin Building", "M116");
        classroomService.saveAllClassrooms(Set.of(m115, m116));
    }

    void saveStudent(Student student) {
        studentService.saveStudent(student);
    }
}
