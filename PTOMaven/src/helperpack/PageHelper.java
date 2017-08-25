package helperpack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.AddPrefixAndSufixInterface;
import serviciesImpl.AddPrefixAndSufixImplementation;

public class PageHelper {
	
	public static void nextRedirect(HttpServletResponse response,String nextPage) throws IOException{
		response.sendRedirect(nextPage);
	}

	public static void nextPageJsp(HttpServletRequest request, HttpServletResponse response, String nextPage)
			throws ServletException, IOException {
		
		AddPrefixAndSufixInterface addPrefixAndSufix = new AddPrefixAndSufixImplementation();
		nextPage = addPrefixAndSufix.createPath(nextPage);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}
	
	

	public static  void nextPageServlet(HttpServletRequest request, HttpServletResponse response,String nextPage)
			throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}
	
	
	


}
