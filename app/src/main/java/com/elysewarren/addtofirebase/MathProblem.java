package com.elysewarren.addtofirebase;

/**
 * Created by elysewarren on 5/3/17.
 */

public class MathProblem {
    private String problem;
    private int answer;
    private boolean correct;

    public MathProblem() {
    }

    public MathProblem(String problem, int answer, boolean correct) {
        this.problem = problem;
        this.answer = answer;
        this.correct = correct;
    }

    public String getProblem() {
        return problem;
    }

    public int getAnswer() {
        return answer;
    }

    public boolean isCorrect() {
        return correct;
    }

    @Override
    public String toString() {
        return "Problem: " + problem + "\n" +
                "Answer: " + answer + "\n";
    }
}



