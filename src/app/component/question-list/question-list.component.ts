import { Component, OnInit } from '@angular/core';
import { Answer } from 'src/app/model/answer';
import { AnswerList } from 'src/app/model/answer-list';
import { Question } from 'src/app/model/question';
import { QuestionService } from 'src/app/service/question.service';

@Component({
  selector: 'app-question-list',
  templateUrl: './question-list.component.html',
  styleUrls: ['./question-list.component.css']
})
export class QuestionListComponent implements OnInit {

  questions: Question[] = [];
  answers : any = [];
  answersList : AnswerList = new AnswerList();
 
  
  
  constructor(private questionService: QuestionService) { 

  }

  ngOnInit() {
    this.questionService.findAll().subscribe(data => {
      this.questions = data;
      console.log(data);
    });
  }

  submit(answers:string[]) {
    for(let i = 0; i < this.answers.length; i++) {
        this.answersList.answerList[i] = new Answer(answers[i+1]);
    }
    
      //this.answersList.push(new Answer(answer))
    
    this.questionService.save(this.answersList);
  
  }

}
