package com.cache.survey.service;

import com.cache.survey.data.Answer;
import com.cache.survey.repository.AnswerRepository;
import com.cache.survey.repository.QuestionRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    @Autowired
    QuestionRepository questionRepository;

//    public Answer saveAnswer(Answer entity) throws Exception
//    {
//        System.out.println(entity.getAnswerId());
//        Optional<Answer> answer = answerRepository.findById(entity.getAnswerId());
//        if(answer.isPresent())
//        {
//            Answer newAnswer = answer.get();
//            newAnswer.setAnswerId(entity.getAnswerId());
//            newAnswer.setAnswer(entity.getAnswer());
//
//            newAnswer = answerRepository.save(newAnswer);
//
//            return newAnswer;
//        } else {
//            entity = answerRepository.save(entity);
//
//            return entity;
//        }
//
//    }


    public Answer saveAnswer(Integer questionId, Answer answer) {
        return questionRepository.findById(questionId).map(question -> {
            answer.setQuestion(question);
            return answerRepository.save(answer);
        }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
    }

//    public Answer saveAnswers(List<Answer> answerList) {
//        for(Answer answer : answerList) {
//            Integer questionId = answerList.indexOf(answer);
//            return questionRepository.findById(questionId).map(question -> {
//                answer.setQuestion(question);
//                return answerRepository.save(answer);
//            }).orElseThrow(() -> new ResourceNotFoundException("QuestionId " + questionId + " not found"));
//        }
//        return null;
//    }
}

