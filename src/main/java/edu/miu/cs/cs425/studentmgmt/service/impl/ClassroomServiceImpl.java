package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.repository.ClassroomRepository;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import org.springframework.stereotype.Service;
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
    public void saveAllClassrooms(Set<Classroom> classrooms) {
        classroomRepository.saveAll(classrooms);
    }
}
