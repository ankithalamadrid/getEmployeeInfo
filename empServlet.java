

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/empServlet")
public class empServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public empServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
//		RequestDispatcher dp=request.getRequestDispatcher("/employee1.jsp");
//		 dp.include(request, response);
		
		empDAO emp = new empDAO(); 
    	ArrayList<Employee> list = new ArrayList<>();
    	
    			try {
					list = emp.getEmployee();
				} catch (Exception e) {
					
					e.printStackTrace();
				}
    			PrintWriter out = response.getWriter();
    			 for(Employee al : list) {
    	                out.println(al.getEmployeeId());
    	                out.println(al.getFirstName());
    	                out.println(al.getLastName());
    	                out.println("\n");
    			 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
