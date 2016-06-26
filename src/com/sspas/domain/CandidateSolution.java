/*
/// Software Engineering project II - Stochastic Search Project Allocation System
/// Debuggers 
/// Date                      Author/(Reviewer)                  Description
/// --------------------------------------------------------------------------         
/// 19 Jun 2016               Shanalie Silva                     Creation and  Added Line(16-33)
/// 24 Jun 2016               Shanalie Silva                     Added Line(44-69)
 */
package com.sspas.domain;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class CandidateSolution {

	private Hashtable<String, CandidateAssignment> table;
	private final int penalty =1000;
	public CandidateSolution(PreferenceTable p) {
		this.table = new Hashtable<String, CandidateAssignment>();
		for(StudentEntry student : p.getAllStudentEntries()) {
			table.put(student.getStudentName(), new CandidateAssignment(student));
		}
	}
	
	public CandidateAssignment getAssignmentFor(String sname) {
		return table.get(sname);
	}
	
	public CandidateAssignment getRandomAssignment() {
		Vector<String> keySet = new Vector<String>(table.keySet());
		return table.get(keySet.elementAt(Main.RND.nextInt(keySet.size())));
	}
    /**
     * Creates a new hashtable call "assignProjects" 
     * Loop the "table" hastable and each candidateAssignment object
     * Use that object get the relevent Energy and add to the totalEnergy of all candidateAssignments
     * Get the currentpreference of that object and check for replicated occurrences of the same project
     * if its the first occurence add the project to assisgnedprojects hashtable
     * if not charge a pentality for each occurence 
     * @return sum of the energy of every assignment made by sol plus the sum of all penalties applied for violations 
     */
	
	public int getEnergy(){
		Enumeration students = table.keys(); 
		int totalEnergy=0;
		Hashtable<String,String> assignedProjects= new Hashtable<String,String>();
		int totalpenalties =0;
	      while(students.hasMoreElements()) {
	         CandidateAssignment cand = table.get((String) students.nextElement()); 
	         totalEnergy+=cand.getEnergy();
	         
	         String project = cand.getAssignedProject(); 
	         if(!assignedProjects.containsKey(project)){
	        	 assignedProjects.put(project, project);
	         }else{
	        	 totalpenalties+=penalty; 
	         }
	      }
		return totalEnergy+ totalpenalties;
	}
	 /**
     * Call the getEnergy function and get the value 
     * Do a simple inversion so that a high score becomes a low score and so that a low score becomes a high score
     * @return Result value of the inversion
     */
	public int getFitness(){
		return getEnergy()*-1; 
	}
}