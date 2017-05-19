package assignment2;

 class Official
{
	//Written by Aditya Vijayakumar
		//Student ID: s3632205


		public String officialId=null;
		public String name=null;
		public String role;
		public int age=0;
		public String state=null;
		
		public Official(String officialId,String name,String role, int age, String state)
		{
			this.role=role;
			this.officialId=officialId;
			this.name=name;
			this.age=age;
			this.state=state;
		}
		public Official(){}

	public static Official[] chooseReferee(Game game){
		Official[] list=new Official[game.listOfAthletes.length];
		Official [] list1=null;
		int i=0;
		int count=0;
		for(i=0;i<game.listOfAthletes.length;i++)
		{
			if(game.listOfAthletes[i].role.matches("officer"))
			{
				list[count]=new Official(game.listOfAthletes[i].athleteId,game.listOfAthletes[i].name,game.listOfAthletes[i].role,game.listOfAthletes[i].age,game.listOfAthletes[i].state);
				count++;
			}
		}
		
		list1=new Official[count];
		for(int j=0;j<count;j++)
		     list1[j]=list[j];
		return list1;
	}
}
