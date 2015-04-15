package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06934")
public class BenchmarkTest06934 extends HttpServlet {
	
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
		String a37153 = param; //assign
		StringBuilder b37153 = new StringBuilder(a37153);  // stick in stringbuilder
		b37153.append(" SafeStuff"); // append some safe content
		b37153.replace(b37153.length()-"Chars".length(),b37153.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map37153 = new java.util.HashMap<String,Object>();
		map37153.put("key37153", b37153.toString()); // put in a collection
		String c37153 = (String)map37153.get("key37153"); // get it back out
		String d37153 = c37153.substring(0,c37153.length()-1); // extract most of it
		String e37153 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d37153.getBytes() ) )); // B64 encode and decode it
		String f37153 = e37153.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g37153 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g37153); // reflection
		
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}
}
