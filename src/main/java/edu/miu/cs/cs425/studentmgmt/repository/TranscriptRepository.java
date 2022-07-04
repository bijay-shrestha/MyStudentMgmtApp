package edu.miu.cs.cs425.studentmgmt.repository;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bijayshrestha on 7/4/22
 * @project MyStudentMgmtApp
 */
@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Integer> {
}
