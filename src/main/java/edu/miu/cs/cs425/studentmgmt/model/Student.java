package edu.miu.cs.cs425.studentmgmt.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author bijayshrestha on 7/4/22
 * @project MyStudentMgmtApp
 */
@Entity
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(nullable = false)
    private String studentNumber;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = true)
    private String middleName;
    @Column(nullable = false)
    @NotBlank(message = "Lastname cannot be blank")
    private String lastName;
    @Column(nullable = true)
    private double cgpa;
    private LocalDate dateOfEnrollment;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Transcript> transcripts;

    @ManyToMany
    @JoinTable(
            name="student_classroom",
            joinColumns={@JoinColumn(name="student_id", referencedColumnName="studentId")},
            inverseJoinColumns={@JoinColumn(name="classroom_id", referencedColumnName="classroomId")})
    private Set<Classroom> classrooms;

    public Student() {
    }

    public Student(String studentNumber, String firstName,
                   String middleName, String lastName,
                   double cgpa, LocalDate dateOfEnrollment) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Student(String studentNumber, String firstName, String middleName,
                   String lastName, double cgpa, LocalDate dateOfEnrollment,
                   Set<Transcript> transcripts) {
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcripts = transcripts;
    }

    public Set<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(Set<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa +
                ", dateOfEnrollment=" + dateOfEnrollment +
                '}';
    }

    public Set<Transcript> getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(Set<Transcript> transcripts) {
        this.transcripts = transcripts;
    }
}
