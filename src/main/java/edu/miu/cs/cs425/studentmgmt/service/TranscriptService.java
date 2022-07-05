package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import java.util.Set;

/**
 * @author bijayshrestha on 7/5/22
 * @project MyStudentMgmtApp
 */
public interface TranscriptService {

    void saveAllTranscripts(Set<Transcript> transcripts);

    void saveTranscript(Transcript transcript);
}
