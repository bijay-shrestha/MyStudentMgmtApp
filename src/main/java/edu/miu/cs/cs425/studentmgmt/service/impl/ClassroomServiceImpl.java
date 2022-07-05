package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author bijayshrestha on 7/5/22
 * @project MyStudentMgmtApp
 */
@Service
public class ClassroomServiceImpl implements ClassroomService {
    private final ClassroomRepository classroomRepository;

    public ClassroomServiceImpl(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    @Override
    public List<Classroom> saveAllClassrooms(Set<Classroom> classrooms) {
        return classroomRepository.saveAll(classrooms);
    }

    @Override
    public void saveClassroom(Classroom classroom) {
        classroomRepository.save(classroom);
    }
}
