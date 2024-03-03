package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class MyController {
	 @Autowired
     StudentRepo studentRepo;
	 @RequestMapping("login")
	 public int login(@RequestBody String [] sa)
	 {
		 String username=sa[0];
		 String password=sa[1];
		 if(username.equals("abc")&&password.equals("pqr"))
		 {
			 return 1;
		 }
		 else
		 {
			 return 0;
		 }
	 }
	     //read all student
	     @RequestMapping("read")
	     public List<Student> read()
	     {
	    	 List<Student>list=studentRepo.findAll();
	    	 return list;
	     }
	     
	     @RequestMapping("add")
	     public Student add(@RequestBody Student student)
	     {
	    	 try 
	    	 {
	    		Student dbstudent=studentRepo.save(student);
		    	 return dbstudent;
	         } 
	    	 catch (Exception e)
	    	 {
				e.printStackTrace();
				return null;
			 }
	     }
	     
	     @RequestMapping("delete{id}")
	     public boolean delete(@PathVariable int id)
	     {
	    	 try {
				studentRepo.deleteById(id);
				return true;
			     }
	    	 catch (Exception e) 
	    	  {
	    		 e.printStackTrace();
	    		 return false;
			  }
	     }
}
