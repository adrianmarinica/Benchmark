package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest15719")
public class BenchmarkTest15719 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
		int r = new java.util.Random().nextInt();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextInt() executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map10246 = new java.util.HashMap<String,Object>();
		map10246.put("keyA-10246", "a_Value"); // put some stuff in the collection
		map10246.put("keyB-10246", param.toString()); // put it in a collection
		map10246.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map10246.get("keyB-10246"); // get it back out
		bar = (String)map10246.get("keyA-10246"); // get safe value back out
	
		return bar;	
	}
}
