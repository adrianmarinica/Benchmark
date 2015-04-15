package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03663")
public class BenchmarkTest03663 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		
		
		
		// Chain a bunch of propagators in sequence
		String a92485 = param; //assign
		StringBuilder b92485 = new StringBuilder(a92485);  // stick in stringbuilder
		b92485.append(" SafeStuff"); // append some safe content
		b92485.replace(b92485.length()-"Chars".length(),b92485.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92485 = new java.util.HashMap<String,Object>();
		map92485.put("key92485", b92485.toString()); // put in a collection
		String c92485 = (String)map92485.get("key92485"); // get it back out
		String d92485 = c92485.substring(0,c92485.length()-1); // extract most of it
		String e92485 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92485.getBytes() ) )); // B64 encode and decode it
		String f92485 = e92485.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92485 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92485); // reflection
		
		
		java.lang.Math.random();
		
		response.getWriter().println("Weak Randomness Test java.lang.Math.random() executed");
	}
}
