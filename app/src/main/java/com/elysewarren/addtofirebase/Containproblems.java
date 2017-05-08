package com.elysewarren.addtofirebase;

import android.view.View;

import java.io.Serializable;

/**
 * Created by elysewarren on 5/5/17.
 */

public class Containproblems implements Serializable{
    public long answer;
    public String problem;
    public boolean correct;

    public Containproblems() {
    }

    public Containproblems(long answer, String problem, boolean correct) {
        this.answer = answer;
        this.problem = problem;
        this.correct = correct;
    }

    public long getAnswer() {
        return answer;
    }

    public void setAnswer(long answer) {
        this.answer = answer;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return problem + "\n" + "\n" + answer ;
    }
}

