package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03061")
public class BenchmarkTest03061 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a65000 = param; //assign
		StringBuilder b65000 = new StringBuilder(a65000);  // stick in stringbuilder
		b65000.append(" SafeStuff"); // append some safe content
		b65000.replace(b65000.length()-"Chars".length(),b65000.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map65000 = new java.util.HashMap<String,Object>();
		map65000.put("key65000", b65000.toString()); // put in a collection
		String c65000 = (String)map65000.get("key65000"); // get it back out
		String d65000 = c65000.substring(0,c65000.length()-1); // extract most of it
		String e65000 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d65000.getBytes() ) )); // B64 encode and decode it
		String f65000 = e65000.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f65000); // reflection
		
		
		Object[] obj = { "a", "b" };
		
		response.getWriter().format(bar,obj);
	}
}
