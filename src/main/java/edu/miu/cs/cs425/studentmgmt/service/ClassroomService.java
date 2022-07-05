package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;

import java.util.List;
import java.util.Set;

/**
 * @author bijayshrestha on 7/5/22
 * @project MyStudentMgmtApp
 */
public interface ClassroomService {
    List<Classroom> saveAllClassrooms(Set<Classroom> classrooms);
}
