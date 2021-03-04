package com.cache.survey.controller;

import com.cache.survey.data.Question;
import com.cache.survey.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/questions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = questionService.getAllQuestions();
        return new ResponseEntity<List<Question>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
