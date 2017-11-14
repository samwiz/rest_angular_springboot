package com.cog.motion.controller;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cog.motion.exception.IncorrectInputException;
import com.cog.motion.model.Input;
import com.cog.motion.model.LinearMotionModel;
import com.cog.motion.service.LinearMotionService;

@RestController
public class LinearMotionController {
	
	@Autowired
	LinearMotionService service;
	
	@RequestMapping(value ="/linearmotion/process", method = RequestMethod.POST)
	public ResponseEntity<LinearMotionModel> processInput(@RequestBody Input input) throws IncorrectInputException{
		if(input != null){
			System.out.println("inside LM controller");
			System.out.println(" Input input.initialVelocity" + input.getInitialVelocity());
			System.out.println(" Input input.acceleration" + input.getAcceleration());
			System.out.println(" Input input.time" + input.getTime());
			System.out.println("Input input.finalVelocity" + input.getFinalVelocity());
			System.out.println("Input input.distance" + input.getDistance());

		}
		System.out.println("inside LinearMotionController --- ");
		
		LinearMotionModel model = new LinearMotionModel();
		
		if(input.getInitialVelocity()!=null){
			model.setInitialVelocity(new BigDecimal(input.getInitialVelocity()));
		}
		if(input.getAcceleration() !=null){
			model.setAcceleration(new BigDecimal(input.getAcceleration()));
		}
		if(input.getTime() !=null){
			model.setTime(new BigDecimal(input.getTime()));
		}
		if(input.getFinalVelocity() !=null){
			model.setFinalVelocity(new BigDecimal(input.getFinalVelocity()));
		}
		
		if(input.getDistance() !=null){
			model.setDistance(new BigDecimal(input.getDistance()));
		}
	
		
			model = service.calculateOutput(model);
//			System.out.println("Output "+model.getInitialVelocity());
//			System.out.println("Output"+model.getFinalVelocity());
//			System.out.println("Output"+model.getAcceleration());
//			System.out.println("Output"+model.getDistance());
//			
//			System.out.println(model.getTime());
			
		
		
		
		
		return new ResponseEntity<>(model, HttpStatus.OK);
	}
	
	
	@ExceptionHandler(IncorrectInputException.class)
	public ResponseEntity<ErrorDetail> errorResponse(IncorrectInputException ex, HttpServletResponse response){
		String errorMessage = ex.getMessage();
		ErrorDetail ed = new ErrorDetail(errorMessage);
		ex.printStackTrace();
		System.out.println(" errorMessage in controller java " + errorMessage);
		return new ResponseEntity<ErrorDetail>(ed,HttpStatus.BAD_REQUEST);
	}
	
	private class ErrorDetail{
		String message;
		public ErrorDetail(String msg){
			this.message = msg;
		}
		public String getMessage(){
			return message;
		}
	}
	}


	
	


