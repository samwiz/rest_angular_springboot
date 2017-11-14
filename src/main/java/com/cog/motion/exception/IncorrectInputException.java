package com.cog.motion.exception;

public class IncorrectInputException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	// Parameterless Constructor
    public IncorrectInputException() {}

    // Constructor that accepts a message
    public IncorrectInputException(String message)
    {
       super(message);
    }
	

}
