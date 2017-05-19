package assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnection {

	Connection con = null;
	Statement stmt = null;
	int result = 0;
	public Connection databaseCreate()
	{
	
	try {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		con = DriverManager.getConnection("jdbc:hsqldb:MyDB//localhost/SAMPLE", "sa", "");
		if(con==null)
		{
			return null;
		}
		
		stmt = con.createStatement();
		result = stmt.executeUpdate("DROP TABLE Athletes");
		
		result = stmt.executeUpdate("CREATE TABLE Athletes (athleteId VARCHAR(6) NOT NULL, name VARCHAR(50) NOT NULL,age INT NOT NULL,state VARCHAR(3),points INT,PRIMARY KEY (athleteId));");
		//Warning, your compiler might not like the newlines in the SQL query
		stmt = con.createStatement();
        result = stmt.executeUpdate("INSERT INTO Athletes VALUES ('oz1114','Java',28, 'VIC',0)");
        
      
        
        con.commit();
        
        return con;
}
	catch (Exception e) {
		e.printStackTrace(System.out);
	}
	return con;	
}
}
