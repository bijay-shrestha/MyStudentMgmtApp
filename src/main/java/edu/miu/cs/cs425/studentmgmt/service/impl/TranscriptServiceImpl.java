package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author bijayshrestha on 7/5/22
 * @project MyStudentMgmtApp
 */
@Service
public class TranscriptServiceImpl implements TranscriptService {

    private final TranscriptRepository transcriptRepository;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepository) {
        this.transcriptRepository = transcriptRepository;
    }

    @Override
    public void saveAllTranscripts(Set<Transcript> transcripts) {
        transcriptRepository.saveAll(transcripts);
    }

    @Override
    public void saveTranscript(Transcript transcript) {
        transcriptRepository.save(transcript);
    }
}
