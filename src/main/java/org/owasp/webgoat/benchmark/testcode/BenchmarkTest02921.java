package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02921")
public class BenchmarkTest02921 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
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
		
		
		new java.io.File(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir),bar);
	}
}
