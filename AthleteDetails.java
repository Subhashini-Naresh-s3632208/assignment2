package assignment2;




import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

//Written by Aditya Vijayakumar
//Student ID: s3632205

import java.util.*;
import java.util.regex.Pattern;


class AthleteDetails extends Athlete {

	
	//Written by Aditya Vijayakumar
	//Student ID: s3632205


	public AthleteDetails(String athleteId, String name, String role,String age, String state) {
		super(athleteId, name, role, age, state);
	}
	public AthleteDetails()
	{
		super();
	}
	public static Athlete[] chosenAthletes=null;
	public static Athlete[] listofAthletes1=null;
	public static Athlete[] listofAthletes=null;
	public static int totalNumberOfAthletes=0;
	
	public static void storeAthletes() throws Exception
	{
		// TODO Auto-generated method stub
		
		listofAthletes1=new Athlete[500];
		int index=0;
		for(int i=0;i<500;i++)
			listofAthletes1[i]=null;
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		BufferedReader br=null;
		DBConnection dbc=new DBConnection();
		con=dbc.databaseCreate();
		try{
		br = new BufferedReader(new FileReader( "src/assignment2/data.txt"));
		}
		catch(Exception e){
			if(br==null && con == null)
				throw new Exception("NO SOURCE FOR ATHLETE DATA");
		}
		try
		{	
			 for(String line; (line = br.readLine()) != null; ) 
			 {
				line=line.toLowerCase();
		        String pattern="\\s*oz[0-9]{4}\\s*,\\s*(swimmer|sprinter|cyclist|super|officer)\\s*,\\s*[a-z]+\\s*[a-z]*\\s*,"
		        		+ "\\s*[0-9]{2}\\s*,\\s*(vic|nsw|qld|act|nt|sa|wa|tas)";
		        
		        if(Pattern.matches(pattern,line))
		        {	
		        	line=line.replaceAll("\\s*,\\s*", ",");
		        	
		        	String details[]=new String[5];
		    
		        	details=line.split(",");
		      
		        	listofAthletes1[index]=new Athlete(details[0],details[2].toUpperCase(),details[1].toLowerCase(),details[3],details[4].toUpperCase());
		            
		        	index+=1;	
		        }
			 }
		 }
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		totalNumberOfAthletes=index;
		listofAthletes=new Athlete[index];
		for(int i = 0;i<index;i++)
			listofAthletes[i]=listofAthletes1[i];
	}

	
	
	
	public static Athlete[] chooseAthletes() throws Exception
	{
		
		
		int index=0;
		
		if(listofAthletes==null){
		storeAthletes();
		
		}
		Athlete[] chosenAthletes1=new Athlete[AthleteDetails.listofAthletes.length];
		for(int i=0;i<listofAthletes.length;i++)
		{
			int flag=0;
			if(listofAthletes[i]!=null)
					for(int k=0;k<i;k++)
					{
						if(listofAthletes[k].athleteId.matches(listofAthletes[i].athleteId))
							{flag=1;
						break;}
					}
					if(flag==0)
					{	
						chosenAthletes1[index]=listofAthletes[i];
						index++;
					}
		}
		
		chosenAthletes=new Athlete[index];
		for(int i = 0;i<index;i++)
			chosenAthletes[i]=chosenAthletes1[i];
	
	return chosenAthletes;
	}
	
	
}

