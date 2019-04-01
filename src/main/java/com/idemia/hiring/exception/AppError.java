package com.idemia.hiring.exception;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         This class contains the error messages that need to be send in the
 *         API response in case of any exception.
 *
 */
public interface AppError {

	String candPanEmpty = "Please enter your Pan number";
	String candPantExists = "Candidate with this PAN Number already exist ";
	String noCandForEmail = "Candidate with this Email Id does not exist ";
	String candDuplicateEmail = "There are more than one conadidate corresponding to this email ";
	String emailNotExists = "Please provide the email id of the Candidate ";
	String positionNotExists = "Please provide the postion of the Requirement for which Candidate is applying";
	String candFeedPersistError = "Unable to save feedback of Candidate";
	String feedbackAlreadySubmitted = "Feedback Email has already been send for this Round.";
	String fileError = "Un-supported file formate";
}
