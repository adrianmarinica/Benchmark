package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17489")
public class BenchmarkTest17489 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		response.getWriter().println(bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar;
		String guess = "ABC";
		char switchTarget = guess.charAt(1); // condition 'B', whish is safe
		
		// Simple case statement that assigns param to bar on conditions 'A' or 'C'
		switch (switchTarget) {
		  case 'A':
		        bar = param;
		        break;
		  case 'B': 
		        bar = "bob";
		        break;
		  case 'C':
		  case 'D':        
		        bar = param;
		        break;
		  default:
		        bar = "bob's your uncle";
		        break;
		}
	
		return bar;	
	}
}
