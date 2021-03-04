package com.cache.survey.data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Question")
public class Question {

    @Id
    @GeneratedValue
    private Integer questionId;

    @Column(name="question")
    private String question;

    @OneToMany(mappedBy="question")
    private List<Answer> answers;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
