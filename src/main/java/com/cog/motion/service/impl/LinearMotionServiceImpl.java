package com.cog.motion.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.cog.motion.exception.IncorrectInputException;
import com.cog.motion.model.LinearMotionModel;
import com.cog.motion.service.LinearMotionService;
import  com.cog.motion.service.common.LinearMotionEquationsHelper;

@Service
public class LinearMotionServiceImpl implements LinearMotionService{
	LinearMotionEquationsHelper eqHelper;

	@Override
	public LinearMotionModel calculateOutput(LinearMotionModel model) throws IncorrectInputException{
		
		
		
		BigDecimal initialVelocityU = model.getInitialVelocity();
		BigDecimal finalVelocityV =model.getFinalVelocity();
		BigDecimal acceleartionA = model.getAcceleration();
		BigDecimal  distanceS = model.getDistance();
		BigDecimal timeT = model.getTime();
		
		System.out.println("initialVelocityU " +initialVelocityU + " acceleartionA  " + acceleartionA + " finalVelocityV " +finalVelocityV + "  timeT " +timeT +"  distanceS " + distanceS);
		
		
		if(initialVelocityU != null && acceleartionA !=null && timeT !=null){
			
			double v = eqHelper.calculateV_from_U_A_and_T(initialVelocityU.doubleValue(),initialVelocityU.doubleValue(), timeT.doubleValue());
			double s = eqHelper.calculateS_from_U_T_and_A(initialVelocityU.doubleValue(), timeT.doubleValue(), acceleartionA.doubleValue());
			model.setFinalVelocity(new BigDecimal(v));
			model.setDistance(new BigDecimal(s));
			return model;
			
		}else if(finalVelocityV != null && initialVelocityU !=null && acceleartionA !=null ){
			System.out.println("inside corrrect");
			double t = eqHelper.calculateT_from_V_U_and_A(finalVelocityV.doubleValue(), initialVelocityU.doubleValue(),acceleartionA.doubleValue() );
			double s = eqHelper.calculateS_from_V_U_and_A(finalVelocityV.doubleValue(), initialVelocityU.doubleValue(),acceleartionA.doubleValue());
			model.setTime(new BigDecimal(t));
			model.setDistance(new BigDecimal(s));
			return model;
			
		}else if(finalVelocityV != null && initialVelocityU !=null && timeT !=null){
			
			double a = eqHelper.calculateA_from_V_U_and_T(finalVelocityV.doubleValue(), initialVelocityU.doubleValue(),timeT.doubleValue());
			double s = eqHelper.calculateS_from_U_T_and_A(initialVelocityU.doubleValue(), timeT.doubleValue(), a);
			model.setAcceleration(new BigDecimal(a));
			model.setDistance(new BigDecimal(s));			
			return model;
			
		}else if(finalVelocityV != null && initialVelocityU !=null && distanceS !=null){
			double a = eqHelper.calculateA_from_V_U_and_S(finalVelocityV.doubleValue(), initialVelocityU.doubleValue(), distanceS.doubleValue());
			double t = eqHelper.calculateT_from_V_U_and_A(finalVelocityV.doubleValue(), initialVelocityU.doubleValue(), a);
			model.setAcceleration(new BigDecimal(a));
			model.setTime(new BigDecimal(t));
			return model;
			
		}else if(finalVelocityV != null &&  acceleartionA !=null && timeT !=null){
			
			double u  = eqHelper.calculateU_from_V_A_and_T(finalVelocityV.doubleValue(), acceleartionA.doubleValue(), timeT.doubleValue());
			double s = eqHelper.calculateS_from_U_T_and_A( u, timeT.doubleValue(), acceleartionA.doubleValue());
			model.setInitialVelocity(new BigDecimal(u));
			model.setDistance(new BigDecimal(s));
			return model;
			
		}else if(finalVelocityV != null &&  acceleartionA !=null && distanceS !=null){
			double u = eqHelper.calculateU_from_V_A_and_S( finalVelocityV.doubleValue(), acceleartionA.doubleValue(), distanceS.doubleValue());
			double t = eqHelper.calculateT_from_V_U_and_A( finalVelocityV.doubleValue(), u, acceleartionA.doubleValue());
			model.setInitialVelocity(new BigDecimal(u));
			model.setTime(new BigDecimal(t));
			return model;
			
		}else if(finalVelocityV != null && timeT !=null && distanceS !=null){
			
			double u  = eqHelper.calculateU_from_V_T_and_S(finalVelocityV.doubleValue(), timeT.doubleValue(), distanceS.doubleValue());
			double a = eqHelper.calculateA_from_V_U_and_T(finalVelocityV.doubleValue(), u, timeT.doubleValue());
			model.setInitialVelocity(new BigDecimal(u));
			model.setAcceleration(new BigDecimal(a));
			return model;
			
		}else if(initialVelocityU != null && acceleartionA !=null && distanceS !=null ){
			
			double v = eqHelper.calculateV_from_U_A_and_S(initialVelocityU.doubleValue(), acceleartionA.doubleValue(), distanceS.doubleValue());
			double t = eqHelper.calculateT_from_V_U_and_A(v, initialVelocityU.doubleValue(), acceleartionA.doubleValue());
			model.setFinalVelocity(new BigDecimal(v));
			model.setTime(new BigDecimal(t));
			return model;
			
		}else if(initialVelocityU != null && timeT !=null && distanceS !=null){
			
			double a = eqHelper.calculateA_from_S_U_and_T(distanceS.doubleValue(), initialVelocityU.doubleValue(), timeT.doubleValue());
			double v = eqHelper.calculateV_from_U_A_and_T( initialVelocityU.doubleValue(), a, timeT.doubleValue());
			model.setAcceleration(new BigDecimal(a));
			model.setFinalVelocity(new BigDecimal(v));
			return model;
			
		}else if(acceleartionA !=null && timeT !=null && distanceS !=null){
			
			double u = eqHelper.calculateU_from_S_A_and_T(distanceS.doubleValue(), acceleartionA.doubleValue(), timeT.doubleValue());
			double v = eqHelper.calculateV_from_U_A_and_T( u, acceleartionA.doubleValue(), timeT.doubleValue());
			model.setInitialVelocity(new BigDecimal(u));
			model.setFinalVelocity(new BigDecimal(v));
			return model;
		}else{
		
			throw new IncorrectInputException("Incorrect Input Combination");
		}
		
		
		
	}
	
	
}
