package assignment2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CRUD {
	
	public static void main(String[] args) {
		
		Connection con = null;
		Statement stmt = null;
		int result = 0;
		
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
			con = DriverManager.getConnection("jdbc:hsqldb:MyDB//localhost/SAMPLE", "sa", "");
			stmt = con.createStatement();
			
			result = stmt.executeUpdate("CREATE TABLE Athletes (athleteId VARCHAR(6) NOT NULL, name VARCHAR(50) NOT NULL,age INT NOT NULL,state VARCHAR(3),points INT,PRIMARY KEY (athleteId));");
			//Warning, your compiler might not like the newlines in the SQL query
			System.out.println("Table created successfully");
			stmt = con.createStatement();
            result = stmt.executeUpdate("INSERT INTO Athletes VALUES ('oz1114','Java',28, 'VIC',0)");
            System.out.println(result + " rows effected");
          
            
            con.commit();
            
            System.out.println("Rows inserted successfully");
            
            ResultSet result1 = stmt.executeQuery("SELECT * FROM Athletes WHERE name LIKE 'Java'");
            
            while(result1.next()){
               System.out.println(result1.getString("athleteId")+" | "+result1.getString("name")+" | "+result1.getString("state"));
            }
           
            result = stmt.executeUpdate(
				"UPDATE Athletes SET name = 'Data Structures' WHERE athleteId LIKE 'oz1114'");
            con.commit();	
            ResultSet output = stmt.executeQuery(
				"SELECT * FROM Athletes");
				
            while(output.next()){
            	  System.out.println(output.getString("athleteId")+" | "+output.getString("name")+" | "+output.getString("state"));
                }
            System.out.println(result+" Rows effected");
           
            Boolean result2=stmt.execute("DROP TABLE Athletes");
            con.commit();
            System.out.println(result2);
		}
		catch (Exception e) {
			e.printStackTrace(System.out);
		}	
		System.out.println(result+" Rows effected");
	}
}