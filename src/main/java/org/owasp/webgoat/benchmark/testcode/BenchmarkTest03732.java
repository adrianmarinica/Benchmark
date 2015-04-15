package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03732")
public class BenchmarkTest03732 extends HttpServlet {
	
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
		String a64290 = param; //assign
		StringBuilder b64290 = new StringBuilder(a64290);  // stick in stringbuilder
		b64290.append(" SafeStuff"); // append some safe content
		b64290.replace(b64290.length()-"Chars".length(),b64290.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64290 = new java.util.HashMap<String,Object>();
		map64290.put("key64290", b64290.toString()); // put in a collection
		String c64290 = (String)map64290.get("key64290"); // get it back out
		String d64290 = c64290.substring(0,c64290.length()-1); // extract most of it
		String e64290 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64290.getBytes() ) )); // B64 encode and decode it
		String f64290 = e64290.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64290 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64290); // reflection
		
		
		Object[] obj = { bar, "b"};
		
		response.getWriter().printf("notfoo",obj);
	}
}
