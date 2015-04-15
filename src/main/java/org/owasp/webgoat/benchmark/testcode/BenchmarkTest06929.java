package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06929")
public class BenchmarkTest06929 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a52503 = param; //assign
		StringBuilder b52503 = new StringBuilder(a52503);  // stick in stringbuilder
		b52503.append(" SafeStuff"); // append some safe content
		b52503.replace(b52503.length()-"Chars".length(),b52503.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52503 = new java.util.HashMap<String,Object>();
		map52503.put("key52503", b52503.toString()); // put in a collection
		String c52503 = (String)map52503.get("key52503"); // get it back out
		String d52503 = c52503.substring(0,c52503.length()-1); // extract most of it
		String e52503 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52503.getBytes() ) )); // B64 encode and decode it
		String f52503 = e52503.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g52503 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g52503); // reflection
		
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}
}
