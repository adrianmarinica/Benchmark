package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05677")
public class BenchmarkTest05677 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String[] values = request.getParameterValues("foo");
		String param;
		if (values.length != 0)
		  param = request.getParameterValues("foo")[0];
		else param = null;
		
		
		// Chain a bunch of propagators in sequence
		String a84753 = param; //assign
		StringBuilder b84753 = new StringBuilder(a84753);  // stick in stringbuilder
		b84753.append(" SafeStuff"); // append some safe content
		b84753.replace(b84753.length()-"Chars".length(),b84753.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map84753 = new java.util.HashMap<String,Object>();
		map84753.put("key84753", b84753.toString()); // put in a collection
		String c84753 = (String)map84753.get("key84753"); // get it back out
		String d84753 = c84753.substring(0,c84753.length()-1); // extract most of it
		String e84753 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d84753.getBytes() ) )); // B64 encode and decode it
		String f84753 = e84753.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g84753 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g84753); // reflection
		
		
		byte[] bytes = new byte[10];
		new java.util.Random().nextBytes(bytes);
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextBytes() executed");
	}
}
