package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02094")
public class BenchmarkTest02094 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}
		
		
		String bar;
		
		// Simple if statement that assigns param to bar on true condition
		int i = 196;
		if ( (500/42) + i > 200 )
		   bar = param;
		else bar = "This should never happen"; 
		
		
		String cmd = org.owasp.webgoat.benchmark.helpers.Utils.getOSCommandString("echo") + bar;
        
		String[] argsEnv = { "Foo=bar" };
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(cmd, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}
}
