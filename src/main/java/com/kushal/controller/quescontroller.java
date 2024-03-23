package com.kushal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kushal.model.Question;
import com.kushal.model.Questionwrapper;
import com.kushal.model.Response;
import com.kushal.service.Questionservice;

@RestController
@RequestMapping("question")
public class quescontroller {
	
	@Autowired
	Questionservice questionservice;
	
	@GetMapping("allquestion")
	public ResponseEntity<List<Question>> Ques(){
		return questionservice.getallquestion();
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity< List<Question>> getquestionbycategory(@PathVariable String category){
		return questionservice.getbycategory(category);
	}
	
	@PostMapping("add")
	public String add(@RequestBody Question question) {
		
		return questionservice.addquestion(question);
		
	}
	//generate
	@GetMapping("generate")
	public ResponseEntity<List<Integer>> generatequestion(@RequestParam String catergoryname, @RequestParam Integer numofquestion) {
	    return questionservice.getquestionforquiz(catergoryname, numofquestion);
	}

	
	//question(questionid)
	
	@PostMapping("getQuestion")
	public ResponseEntity<List<Questionwrapper>> getquestion(@RequestBody List<Integer> questionids){
		return questionservice.getquestionfromid(questionids);
		
	}
	
	
	//getscore
	
	  @PostMapping("getScore")
	    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses)
	    {
	        return questionservice.getScore(responses);
	    }
	
	
	
	

}
