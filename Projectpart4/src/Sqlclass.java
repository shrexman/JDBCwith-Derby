import java.sql.*;


public class Sqlclass {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String DB_URL = "jdbc:derby://localhost:1527/cegep";
	
	// Database credentials
	static final String USER = "student"; 
	static final String PASS = "cegepgim";
	
	public static void main(String[] args) { 
	Connection conn = null;
	Statement stmt = null;
	try{
	//STEP 2: Register JDBC driver
	Class.forName(JDBC_DRIVER);
	
	//STEP 3: Open a connection
	System.out.println("Connecting to database...");
	conn = DriverManager.getConnection(DB_URL,USER,PASS);
	
	//STEP 4: Execute a query
	System.out.println("Creating statement...");
	stmt = conn.createStatement();
	String sql;
	sql = "SELECT id, name, address FROM students"; 
	ResultSet rs = stmt.executeQuery(sql);
	
	//STEP 5: Extract data from result set
	while(rs.next()){
	//Retrieve by column name
	int id = rs.getInt("id");
	String name = rs.getString("name"); 
	String address = rs.getString("address");
	
	//Display values
	System.out.print("ID: " + id); 
	System.out.print(", First: " + name); 
	System.out.println(", Last: " + address);
	}
	
	//STEP 6: Execute an Update - Insert
	sql = "insert into students values(5,'zaier','address 2')"; int number = stmt.executeUpdate(sql);
	System.out.println(" the change 1: " + number);
	
	//STEP 7: Execute an Update - Update
	//sql = "update students set address ='zied address’ where id=3”; number = stmt.executeUpdate(sql);
	//System.out.println(" the change 2: " + number);
	
	//STEP 8: Execute an Update - Delete
	//sql = “Delete from students where id=2’ ";
	//number = stmt.executeUpdate(sql);
	//System.out.println(" the change 2: " + number);
			
	//STEP 9: Clean-up environment
	rs.close(); 
	stmt.close(); 
	conn.close();
	}
	catch(SQLException se)
	{ //Handle errors for JDBC 
		se.printStackTrace();
	}
	catch(Exception e){
	//Handle errors for Class.forName 
		e.printStackTrace();
	}
	System.out.println("Goodbye!"); }//end main
	
}
