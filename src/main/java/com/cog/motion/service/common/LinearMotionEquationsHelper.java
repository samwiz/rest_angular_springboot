package com.cog.motion.service.common;

import com.cog.motion.exception.IncorrectInputException;

public class LinearMotionEquationsHelper {

	public static double calculateV_from_U_A_and_T (double u, double a, double t)throws IncorrectInputException{
		double v=0;
		if(t<0){
			throw new IncorrectInputException("time is less than zero" +t);
		}
		v = u + (a*t);
		return v;
	}
	
	public static double calculateU_from_V_A_and_T(double v, double a, double t) throws IncorrectInputException{
		double u=0;
		if(t<0){
			throw new IncorrectInputException("time is less than zero " +t);
		}
		u = v -(a*t);
		return u;
	}
	
	public static double calculateA_from_V_U_and_T(double v, double u, double t) throws IncorrectInputException{
		double a=0;
		if(t>0){
			a = (v-u)/t;// assumption t> 0
		}else {
			throw new IncorrectInputException("Invalid time value " + t);
		}
		
		return a;
	}
	
	public static double calculateT_from_V_U_and_A(double v, double u, double a) throws IncorrectInputException{
		double t=0;
		System.out.println("inside calculateT_from_V_U_and_A "  + a);
		if(a != 0){
			t = (v-u)/a;// assumpiton a! =0, This case may need to be handled different based on requirement
			if(t<0){
				throw new IncorrectInputException("Invalid time value " + t);
			}
			return t;
		}else {
			throw new IncorrectInputException("Acceleration is O");
		}
		
	}
	
	public static double calculateS_from_U_T_and_A(double u, double t, double a){
		double s=0;
		s = (u*t) + (0.5)*(a*t*t);
		return s;
	}
	
	public static double calculateV_from_U_A_and_S(double u, double a, double s)throws IncorrectInputException{
		double v=0;
		double x  = (u*u) + (2 *(a*s));
		if(x<0){
			throw new IncorrectInputException("Invalid input combination");// Square of v cannot be negative
		}else{
			v = Math.sqrt(x);
			//sqrt can have answers as +v and -v
			//check if t > 0 with each input , time cannot be negative
			if(calculateT_from_V_U_and_A(v, u,a)>0){
				return v;
			}else {
				return v*(-1);
			}
			
		}
		
	
	}
	
	public static double calculateS_from_V_U_and_A(double v, double u, double a){
		double s=0;
		if(a != 0){
			s = ((v*v)-(u*u))/(2*a);//if a !=0 else if a =0 then v = u and s = 0
		}
		
		return s;
	}
	//check 
	public static double calculateA_from_V_U_and_S(double v, double u, double s)throws IncorrectInputException{
		double a=0;
		if(s !=0 ){
			a = ((v*v)-(u*u))/(2*s); //if s!=0 else if s =0 then v = u and a = 0
		}else{
			throw new IncorrectInputException("Invalid input combination");
		}
		
		return a;
	}
	
	public static double calculateU_from_V_A_and_S(double v, double a, double s)throws IncorrectInputException{
		double u=0;
		double x = (v*v) -(2*a*s);
		if(x <0){
			throw new IncorrectInputException("Invalid Input combination");
		}else{
			u = Math.sqrt(x);
			// sqrt result can be both u and -u
			//calculate t to make sure which value is correct answer
			if(calculateT_from_V_U_and_A(v, u,a)>0){
				return u;
			}else {
				return u*(-1);
			}
		}
	}
	
	public static double calculateU_from_S_A_and_T(double s, double a, double t) throws IncorrectInputException{
		double u=0;
		if (t>0){
			u=((2*s)-(a*t*t))/(2*t);// if t>0
		}else if(t ==0 && s==0){
			throw new IncorrectInputException("output cannot be determined");// u can be 0 or  any other value
		}else if (t==0 && s<0){
			throw new IncorrectInputException("Invalid Input combination");
		}
		else {
			throw new IncorrectInputException("Invalid time value " + t);
		}
		
		return u;
	}
	
	
	public static double calculateA_from_S_U_and_T(double s, double u, double t) throws IncorrectInputException{
		double a=0;
		if(t>0){
			a =((2*s)-(2*u*t))/(t*t);
		}else if(t==0 && s!=0){
			throw new IncorrectInputException("Invalid input combination");
		}
		else if(s ==0 && t==0){
			throw new IncorrectInputException("output cannot be determined"); // a can be 0 or any other value
		}else {
			throw new IncorrectInputException("Invalid time value " + t);
		}
		
		return a;
	}
	
	public static double calculateU_from_V_T_and_S(double v, double t, double s) throws IncorrectInputException{
		double u=0;
		double x = (((v*v*t)+(s*s))-(2*v*s));
		if(x<0){
		throw new IncorrectInputException("Invalid Input combination");
		}else{
			u = s+ Math.sqrt(x);
		}
		return u;
		
	}
}
