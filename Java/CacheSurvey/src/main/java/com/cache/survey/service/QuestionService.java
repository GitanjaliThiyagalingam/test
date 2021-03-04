package com.cache.survey.service;

import com.cache.survey.data.Question;
import com.cache.survey.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    public List<Question> getAllQuestions()
    {
        List<Question> questionList = questionRepository.findAll();
        if(questionList.size() > 0) {
            return questionList;
        } else {
            return new ArrayList<Question>();
        }
    }
}
