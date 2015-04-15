package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03078")
public class BenchmarkTest03078 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a72625 = param; //assign
		StringBuilder b72625 = new StringBuilder(a72625);  // stick in stringbuilder
		b72625.append(" SafeStuff"); // append some safe content
		b72625.replace(b72625.length()-"Chars".length(),b72625.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map72625 = new java.util.HashMap<String,Object>();
		map72625.put("key72625", b72625.toString()); // put in a collection
		String c72625 = (String)map72625.get("key72625"); // get it back out
		String d72625 = c72625.substring(0,c72625.length()-1); // extract most of it
		String e72625 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d72625.getBytes() ) )); // B64 encode and decode it
		String f72625 = e72625.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f72625); // reflection
		
		
		Object[] obj = { "a", bar};
		response.getWriter().print(obj);
	}
}
