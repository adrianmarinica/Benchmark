package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest01253")
public class BenchmarkTest01253 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");
		
		
		String bar;
		
		// Simple if statement that assigns constant to bar on true condition
		int i = 86;
		if ( (7*42) - i > 200 )
		   bar = "This_should_always_happen"; 
		else bar = param;
		
		
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(args);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
		}
	}
}
