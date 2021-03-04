package com.cache.survey.controller;

import com.cache.survey.data.Answer;
import com.cache.survey.data.AnswerList;
import com.cache.survey.service.AnswerService;
import com.cache.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @Autowired
    QuestionService questionService;


//    @RequestMapping(value = "/questions/{questionId}/answers", method = RequestMethod.PUT)
//    public ResponseEntity<Answer> createOrUpdateEmployee(@PathVariable("questionId") Integer questionId, @RequestBody Answer answer) throws Exception {
//
//        Answer updated = answerService.saveAnswer(questionId, answer);
//        return new ResponseEntity<Answer>(updated, new HttpHeaders(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/questions/answers", method = RequestMethod.POST)
    public ResponseEntity<List<Answer>> saveAnswers(@RequestBody AnswerList answerList) {
        List<Answer> updatedList = new ArrayList<Answer>();
        for(int i = 0; i < answerList.getAnswerList().length - 1; i++) {
            Answer updated = answerService.saveAnswer(i + 1, answerList.getAnswerList()[i]);
            updatedList.add(updated);
        }

        return new ResponseEntity<List<Answer>>(updatedList, new HttpHeaders(), HttpStatus.OK);

    }

}
