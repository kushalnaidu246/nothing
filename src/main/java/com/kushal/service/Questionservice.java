package com.kushal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.kushal.dao.Questiondao;
import com.kushal.model.Question;
import com.kushal.model.Questionwrapper;
import com.kushal.model.Response;

@Service
public class Questionservice {

	@Autowired
	Questiondao questiondao; 
	public ResponseEntity< List<Question>> getallquestion(){
		try {
		return new ResponseEntity<>(questiondao.findAll(),HttpStatus.OK);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Question>> getbycategory(String category) {
		// TODO Auto-generated method stub
		try {
		return new ResponseEntity( questiondao.findByCategory(category),HttpStatus.ACCEPTED);
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
	}
	public String addquestion(Question question) {
		// TODO Auto-generated method stub
		 questiondao.save(question);
		 return "success";
		
	}
	public ResponseEntity<List<Integer>> getquestionforquiz(String catergoryname, Integer numofquestion) {
		
		List<Integer> questions=questiondao.findRandomQuestionByCategory(catergoryname, numofquestion);
		
		return new ResponseEntity<>(questions,HttpStatus.OK);
	}
	public ResponseEntity<List<Questionwrapper>> getquestionfromid(List<Integer> questionids) {
	
		List<Questionwrapper> wrapper=new ArrayList<>();
		List<Question> questions = new ArrayList<>();

        for(Integer id : questionids){
            questions.add(questiondao.findById(id).get());
        }

        for(Question question : questions){
            Questionwrapper wrapper1 = new Questionwrapper();
            wrapper1.setQuestionId(question.getQuestionId());
            wrapper1.setQuestionTitle(question.getQuestionTitle());
            wrapper1.setOption1(question.getOption1());
            wrapper1.setOption2(question.getOption2());
            wrapper1.setOption3(question.getOption3());
            wrapper1.setOption4(question.getOption4());
            
            wrapper.add(wrapper1);
        }

		
		return new ResponseEntity<>(wrapper,HttpStatus.OK);
	}
	public ResponseEntity<Integer> getScore(List<Response> responses) {


        int right = 0;

        for(Response response : responses){
            Question question = questiondao.findById(response.getId()).get();
            if(response.getResponse().equals(question.getRightAnswer()))
                right++;
        }
        return new ResponseEntity<>(right, HttpStatus.OK);
    }

}
