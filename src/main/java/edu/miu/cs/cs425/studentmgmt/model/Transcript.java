package edu.miu.cs.cs425.studentmgmt.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author bijayshrestha on 7/4/22
 * @project MyStudentMgmtApp
 */
@Entity
public class Transcript implements Serializable {
    @Id
    @GeneratedValue
    private int transcriptId;

    private String degreeTitle;

    public Transcript() {
    }

    public Transcript(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    public int getTranscriptId() {
        return transcriptId;
    }

    public void setTranscriptId(int transcriptId) {
        this.transcriptId = transcriptId;
    }

    public String getDegreeTitle() {
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle) {
        this.degreeTitle = degreeTitle;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "transcriptId=" + transcriptId +
                ", degreeTitle='" + degreeTitle + '\'' +
                '}';
    }
}
