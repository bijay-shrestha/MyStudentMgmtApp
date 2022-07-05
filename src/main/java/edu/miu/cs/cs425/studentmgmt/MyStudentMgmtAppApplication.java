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
import java.util.HashSet;
import java.util.List;
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
        Classroom m115 = new Classroom("McLaughlin Building", "M115");
        Classroom m116 = new Classroom("McLaughlin Building", "M116");
        Classroom m117 = new Classroom("McLaughlin Building", "M117");
        Classroom m215 = new Classroom("McLaughlin Building", "M215");
        Classroom m216 = new Classroom("McLaughlin Building", "M216");
        Classroom m217 = new Classroom("McLaughlin Building", "M217");

        Student anna = getStudent("000-61-0001", "Anna", "Lynn",
                "Smith", 3.45, LocalDate.of(2019, 5, 24));
        Student bell = getStudent("000-61-0002", "Bell", "",
                "Hadid", 4, LocalDate.of(1990, 4, 20));


        //add room reference to student (This works)
        anna.getClassrooms().add(m115);
        anna.getClassrooms().add(m116);
        anna.getClassrooms().add(m117);
        bell.getClassrooms().add(m215);
        bell.getClassrooms().add(m216);
        bell.getClassrooms().add(m217);
        saveStudent(anna);
        saveStudent(bell);

        //WEIRD:: add student reference to classroom (This doesn't work, why??)
//        m115.getStudents().add(anna);
//        m116.getStudents().add(anna);
//        m117.getStudents().add(anna);
//        m215.getStudents().add(bell);
//        m216.getStudents().add(bell);
//        m217.getStudents().add(bell);
//        saveClassrooms(Set.of(m115, m116, m117, m215, m216, m217));


        saveTranscripts(anna, bell);
    }

    private void saveTranscripts(Student anna, Student bell) {
        Transcript bsComputerScienceProgramAnna = new Transcript("BS Computer Science", anna);
        Transcript msComputerScienceProgramAnna = new Transcript("MS Computer Science", anna);
        Transcript msComputerScienceProgramBell = new Transcript("MS Computer Science", bell);
        transcriptService.saveAllTranscripts(Set.of(bsComputerScienceProgramAnna, msComputerScienceProgramAnna));
        transcriptService.saveTranscript(msComputerScienceProgramBell);
    }

    private Student getStudent(String studentNumber, String firstName, String middleName, String lastName, double cgpa,
                               LocalDate dateOfAdmission) {
        return new Student(
                studentNumber,
                firstName,
                middleName,
                lastName,
                cgpa,
                dateOfAdmission
        );
    }

    void saveStudent(Student student) {
        studentService.saveStudent(student);
    }

    void saveClassroom(Classroom classroom){
        classroomService.saveClassroom(classroom);
    }

    List<Classroom> saveClassrooms(Set<Classroom> classrooms){
       return classroomService.saveAllClassrooms(classrooms);
    }

    public static <T> Set<T> convertListToSet(List<T> list) {
        Set<T> set = new HashSet<>();
        for (T t : list)
            set.add(t);
        return set;
    }
}
