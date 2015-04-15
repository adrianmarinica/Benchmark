package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06184")
public class BenchmarkTest06184 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getQueryString();
		
		
		String bar = "safe!";
		java.util.HashMap<String,Object> map29312 = new java.util.HashMap<String,Object>();
		map29312.put("keyA-29312", "a_Value"); // put some stuff in the collection
		map29312.put("keyB-29312", param.toString()); // put it in a collection
		map29312.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map29312.get("keyB-29312"); // get it back out
		bar = (String)map29312.get("keyA-29312"); // get safe value back out
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
