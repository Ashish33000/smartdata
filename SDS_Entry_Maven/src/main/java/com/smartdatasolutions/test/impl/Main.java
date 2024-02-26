package com.smartdatasolutions.test.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		  return membersFromFile;
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		   Map<String, List<Member>> membersByState = new HashMap<>();

	        for (Member member : validMembers) {
	            String state = member.getState();
	            membersByState.computeIfAbsent(state, k -> new java.util.ArrayList<>()).add(member);
	        }

	        return membersByState;
	}

	public static void main( String[] args ) {
		
		 Main main = new Main();

	        try {
	            File inputMemberFile = new File("C:\\Users\\hi\\Desktop\\Sds\\SDS_Entry_Maven\\Members.txt");
	            String outputFilePath = "C:\\Users\\hi\\Desktop\\Sds\\SDS_Entry_Maven";  
	            String outputFileName = "outputFile.csv";

	            main.convert(inputMemberFile, outputFilePath, outputFileName);
	        } catch (Exception e) {
	           System.out.println(e.getMessage());
	        }
	}

}
