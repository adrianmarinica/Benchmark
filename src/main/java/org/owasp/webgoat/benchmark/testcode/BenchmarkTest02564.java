package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest02564")
public class BenchmarkTest02564 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}
		
		
		// Chain a bunch of propagators in sequence
		String a71171 = param; //assign
		StringBuilder b71171 = new StringBuilder(a71171);  // stick in stringbuilder
		b71171.append(" SafeStuff"); // append some safe content
		b71171.replace(b71171.length()-"Chars".length(),b71171.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71171 = new java.util.HashMap<String,Object>();
		map71171.put("key71171", b71171.toString()); // put in a collection
		String c71171 = (String)map71171.get("key71171"); // get it back out
		String d71171 = c71171.substring(0,c71171.length()-1); // extract most of it
		String e71171 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71171.getBytes() ) )); // B64 encode and decode it
		String f71171 = e71171.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f71171); // reflection
		
		
		double rand = new java.util.Random().nextDouble();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextDouble() executed");
	}
}
