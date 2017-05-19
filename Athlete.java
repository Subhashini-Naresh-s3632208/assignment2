package assignment2;

import java.util.Random;


class Athlete 
{
	public String athleteId;
	public String name;
	public int age;
	public String role;
	public String state;
	public int points=0;
	public int time=0;
	
	public Athlete()
	{
		
	}
	public Athlete(String athleteId,String name,String role,String age,String state){
		this.role=role;
		this.state=state;
		
		this.age=Integer.parseInt(age);
		this.name=name;
		this.athleteId=athleteId;
		this.points=0;
	}

	public void compete(String gameId)
	{
		gameId=gameId.toUpperCase();
		if(gameId.startsWith("S"))
		{
			//RANDOM function for swimming 100 - 200 seconds
			Random r= new Random();
	    this.time= r.nextInt((200-100)+1)+100;
		}
		else if(gameId.startsWith("C"))
		{
		//RANDOM function for cycling 500 - 800 seconds
		Random r= new Random();
	    this.time= r.nextInt((800-500)+1)+500;
		
		}
		else if(gameId.startsWith("R"))
		
		{
			//RANDOM function for running 10 - 20 seconds
			Random r= new Random();
	    this.time= r.nextInt((20-10)+1)+10;
		}

}
}

