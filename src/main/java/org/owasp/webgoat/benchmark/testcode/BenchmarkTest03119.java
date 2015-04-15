package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03119")
public class BenchmarkTest03119 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a208 = param; //assign
		StringBuilder b208 = new StringBuilder(a208);  // stick in stringbuilder
		b208.append(" SafeStuff"); // append some safe content
		b208.replace(b208.length()-"Chars".length(),b208.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map208 = new java.util.HashMap<String,Object>();
		map208.put("key208", b208.toString()); // put in a collection
		String c208 = (String)map208.get("key208"); // get it back out
		String d208 = c208.substring(0,c208.length()-1); // extract most of it
		String e208 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d208.getBytes() ) )); // B64 encode and decode it
		String f208 = e208.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f208); // reflection
		
		
		response.getWriter().println(bar.toCharArray());
	}
}
