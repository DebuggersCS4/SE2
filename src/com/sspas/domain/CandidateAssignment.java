/*
/// Software Engineering project II - Stochastic Search Project Allocation System
/// Debuggers 
/// Date                      Author/(Reviewer)                  Description
/// --------------------------------------------------------------------------         
/// 19 Jun 2016               Shanalie Silva                     Creation and Added Line(12-42)
/// 24 Jun 2016               Shanalie Silva                     Added Line(44-46)
 */
package com.sspas.domain;

public class CandidateAssignment {

	private StudentEntry student;
	private String previousPreference, currentPreference;
	
	public CandidateAssignment(StudentEntry s) {
		student = s;
		randomizeAssignment();
	}
	
	public void randomizeAssignment() {
		previousPreference = currentPreference;
		currentPreference = student.getRandomPreference().intern();
	}
	
	public void undoChange() {
		currentPreference = previousPreference;
	}
	
	public String toString() {
		return student.getStudentName()+": "+currentPreference;
	}
	public StudentEntry getStudentEntry(){
		return student;
	}
	public String getAssignedProject(){
		return currentPreference;
	}
	/**
     * Call the getRanking in StudentEntry function and get the value 
     * square of ranking+1 to get the engery of the current candidateAssignment object.
     * @return Return the value of engery
     */
	public int getEnergy(){
		return (int) Math.pow(student.getRanking(currentPreference)+1, 2);
	}
}
