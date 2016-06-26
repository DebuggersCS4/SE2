/*
/// Software Engineering project II
/// Date                      Author/(Reviewer)                  Description
/// --------------------------------------------------------------------------         
/// 12 Jun 2016               Vishan Abeyrathna                  Creation
/// 17 Jun 2016               Shanalie Silva                     Modification (Line 27-33)
/// 25 Jun 2016               Shanalie Silva                     Added (Line 37)
 */
package com.sspas.domain;

import java.util.Random;

public class Main {

	protected static Random RND = new Random();
	
	public static void main(String[] args) {
		PreferenceTable p = new PreferenceTable("Project allocation data.tsv");
		
//		p.printVectorContents();
//		
//		System.out.println(p.getEntryFor("Alan Turing"));
//		for(StudentEntry element:p.getAllStudentEntries()) {
//			System.out.println(element);
//		}
//		System.out.println(p.getRandomStudent());
		
		System.out.println(p.getAllStudentEntries());
		p.fillPreferencesOfAll(10);
		System.out.println(p.getAllStudentEntries());
		CandidateSolution sol = new CandidateSolution(p);
		String name = p.getRandomStudent().getStudentName();
		System.out.println("Assignment: "+sol.getAssignmentFor(name));
		System.out.println("Randon Assignment: "+sol.getRandomAssignment());
		
	
		System.out.println("Fitness "+sol.getFitness());
		
	}

}
