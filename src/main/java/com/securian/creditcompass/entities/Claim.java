package com.securian.creditcompass.entities;
import com.securian.creditcompass.ClaimState.ClaimStateChangeListener;
import com.securian.creditcompass.ClaimState.ClaimState;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "claims")
public class Claim {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Column(name = "claimType")
    private String claimType;

    @Getter
    @Column(name = "claimDetails")
    private String claimDetails;

    @Getter
    @Column(name = "claimAmt")
    private Float claimAmt;

    @Getter
    @Column(name = "complexityScore")
    private Integer complexityScore; // the two scores will need to be added after, can not be initialized

    @Getter
    @Column(name = "urgencyScore")
    private Integer urgencyScore; // a date perhaps?

    @Column(name = "totalScore")
    private Integer totalScore;

    @Getter
    @Column(name = "creationDateTime")
    private LocalDateTime creationDateTime;

    @Column(name = "processed")
    private Boolean processed;

    @Getter
    @Column(name = "examiner")
    private String examiner;

    private transient ClaimState currentState;

    // TODO We may need read and write objects for ClaimState too, if we want to save
    //  it to the database?

    private transient List<ClaimStateChangeListener> listeners = new ArrayList<>();

    private void writeObject(ObjectOutputStream out) throws IOException, IOException {
        out.defaultWriteObject();
        out.writeInt(listeners.size());
        for (ClaimStateChangeListener listener : listeners) {
            out.writeObject(listener);
        }
    }

    @SuppressWarnings("unchecked")
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int numListeners = in.readInt();
        listeners = new ArrayList<>();
        for (int i = 0; i < numListeners; i++) {
            ClaimStateChangeListener listener = (ClaimStateChangeListener) in.readObject();
            listeners.add(listener);
        }
    }

    // Hibernate expects entities to have a no-arg constructor,
    // though it does not necessarily have to be public.


    public void setComplexityScore(Integer score){this.complexityScore = score;}

    public void setUrgencyScore(Integer score){this.urgencyScore = score;}

    public void setTotalScore(Integer score){this.totalScore = score;}
    public double getTotalScore(){return this.totalScore;}

    public boolean isProcessed(){return this.processed;}

    public boolean processClaim(){return this.processed = true;}

    public void assignToClaimsExaminer(ClaimsExaminer examiner) {
        currentState.assignToClaimsExaminer(examiner, this);
    }

    public void calculateScore() {
        currentState.calculateScore(this);
    }

    public void changeToProcessed() {
        currentState.changeToProcessed(this);
    }

    public void addStateChangeListener(ClaimStateChangeListener listener) {
        listeners.add(listener);
    }

    public void removeStateChangeListener(ClaimStateChangeListener listener) {
        listeners.remove(listener);
    }

    public void setCurrentState(ClaimState newState) {
        if (this.currentState != newState) {
            ClaimState oldState = this.currentState;
            this.currentState = newState;
            notifyStateChangeListeners(oldState, newState);
        }
    }

    private void notifyStateChangeListeners(ClaimState oldState, ClaimState newState) {
        for (ClaimStateChangeListener listener : listeners) {
            listener.stateChanged(this, newState);
        }
    }

    public ClaimsExaminer getExaminerWithMinScore(List<ClaimsExaminer> examiners) {
        ClaimsExaminer minExaminer = examiners.get(0);
        for (ClaimsExaminer examiner : examiners) {
            if (examiner.getExaminerScore() < minExaminer.getExaminerScore()) {
                minExaminer = examiner;
            }
        }
        return minExaminer;
    }

}

