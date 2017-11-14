package com.cog.motion.service;

import com.cog.motion.exception.IncorrectInputException;
import com.cog.motion.model.LinearMotionModel;

public interface LinearMotionService {
public LinearMotionModel calculateOutput(LinearMotionModel input)throws IncorrectInputException;
}
