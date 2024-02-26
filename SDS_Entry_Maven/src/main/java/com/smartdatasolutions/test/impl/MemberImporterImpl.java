package com.smartdatasolutions.test.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */
		List<Member> members = new ArrayList<>();
        Set<String> unique = new HashSet<>();

		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			String line = br.readLine( );

			while ( line != null ) {
				line = br.readLine( );
				 String id = line.substring(0, 12).trim();
	                String lastName = line.substring(12, 37).trim();
	                String firstName = line.substring(37, 62).trim();
	                String address = line.substring(62, 92).trim();
	                String city = line.substring(92, 112).trim();
	                String state = line.substring(112, 116).trim();
	                String zip = line.substring(116).trim();

	               
	                String memberId = id + state;
	                if (!unique.contains(memberId)) {
	                    unique.add(memberId);

	                   
	                    Member member = new Member();
	                    member.setId(id);
	                    member.setLastName(lastName);
	                    member.setFirstName(firstName);
	                    member.setAddress(address);
	                    member.setCity(city);
	                    member.setState(state);
	                    member.setZip(zip);

	                    members.add(member);

			}
	                line = br.readLine();
		}

			
	}
	
		return members;
	}
}
