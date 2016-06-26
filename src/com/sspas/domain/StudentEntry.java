/*
/// Software Engineering project II - Stochastic Search Project Allocation System
/// Debuggers 
/// Date                      Author/(Reviewer)                  Description
/// --------------------------------------------------------------------------         
/// 12 Jun 2016               Vishan Abeyrathna                  Creation
/// 17 Jun 2016               Shanalie Silva                     Added (Line 65-76)
/// 24 Jun 2016               Shanalie Silva                     Added (Line 81-104)
 */
package com.sspas.domain;

import java.util.Vector;

public class StudentEntry {

	private String name;
	private boolean hasProjectPreassigned;
	private Vector<String> orderedPreferences;
	private int numberOfStatedPreferences;
	private String projectAssigned = null;
	
	public StudentEntry(String n) {
		name = n;
	}
	
	/**
	 * 
	 * @return a String containing the name of this particular student
	 */
	public String getStudentName() {
		return name;
	}
	
	public void setHasProjectPreassigned(boolean bool) {
		hasProjectPreassigned = bool;
	}
	
	public void setOrderedPreferences(Vector<String> v) {
		orderedPreferences = v;
		numberOfStatedPreferences = orderedPreferences.size();
	}
	
	public Vector<String> getOrderedPreferences() {
		return orderedPreferences;
	}
	
	public void preassignProject(String pname) {
		if(orderedPreferences.size()==1 && hasProjectPreassigned) {
			projectAssigned = pname;
		}
	}
	
	public boolean hasPreassignedProject() {
		if(hasProjectPreassigned && projectAssigned != null) {
			return true;
		}
		return false;
	}
	
	public int getNumberOfStatedPreferences() {
		return numberOfStatedPreferences;
	}
	
	public void addProject(String pname) {
		if(!hasPreference(pname)) {
			orderedPreferences.addElement(pname);
		}
	}
	
	public String getRandomPreference() {
		return orderedPreferences.get(Main.RND.nextInt(orderedPreferences.size()));
	}
	
	public boolean hasPreference(String preference) {
		return orderedPreferences.contains(preference.intern());
	}
	
	public String toString() {
		return "Name: "+name+" prefereces:"+getOrderedPreferences();
	}
	/**
	 * Checks whether the project is in the ordered list of this student
	 * if not return -1
	 * if it is then check whether its already assigned to this student or top-ranked if it is true return 0
	 * if not return the element number in the list 
     * @param project name 
     * @return Return the rank
     */
	public int getRanking(String project){
		if(hasPreference(project.intern())){ 
			if(hasProjectPreassigned || getOrderedPreferences().indexOf(project.intern())==0){ 
				return 0;
			}else{
				return getOrderedPreferences().indexOf(project.intern()); 			
			}
		}else{
			return -1;
		}
	}
}
