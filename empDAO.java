import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class empDAO{
	public static Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.18.40:1521:ascend";
		String user ="arkumar";
		String password ="arkumar";
		Connection conne = DriverManager.getConnection(url,user,password);
		return conne;
		
		
	}
	public static void closeConn(Connection connection) throws Exception {
		connection.close();
	}
	public ArrayList<Employee> getEmployee() throws Exception{
		//Connection conne = DriverManager.getConnection(url,user,password);
		
		Connection con = getConn();
		ArrayList<Employee> al = new ArrayList<>();
		Statement stmt = con.createStatement();
		ResultSet r = stmt.executeQuery("select * from employees");
		String FIRST,LAST,EMAIL,phone;
        int salary,comm,mid,dept;
        
        while(r.next()) {
        		Employee e = new Employee();
        	   e.setEmployeeId(r.getInt("employee_id"));
        	   e.setFirstName(r.getString("first_name"));
        	   e.setLastName(r.getString("last_name"));
        	   //System.out.println(e.EmployeeId+ " "+e.FirstName+" "+e.LastName);
        	   
        	   al.add(e);
        	   
        }
       
//        for(Employee al1 : al) {
//            System.out.println(al1.getEmployeeId());
//            System.out.println(al1.getFirstName());
//            System.out.println(al1.getLastName());
//        }
        r.close();

        closeConn(con);
        
        
        return al;   
}
}