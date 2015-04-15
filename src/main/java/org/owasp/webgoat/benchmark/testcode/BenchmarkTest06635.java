package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest06635")
public class BenchmarkTest06635 extends HttpServlet {
	
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
		String a31873 = param; //assign
		StringBuilder b31873 = new StringBuilder(a31873);  // stick in stringbuilder
		b31873.append(" SafeStuff"); // append some safe content
		b31873.replace(b31873.length()-"Chars".length(),b31873.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map31873 = new java.util.HashMap<String,Object>();
		map31873.put("key31873", b31873.toString()); // put in a collection
		String c31873 = (String)map31873.get("key31873"); // get it back out
		String d31873 = c31873.substring(0,c31873.length()-1); // extract most of it
		String e31873 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d31873.getBytes() ) )); // B64 encode and decode it
		String f31873 = e31873.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g31873 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g31873); // reflection
		
		
		try {
			javax.naming.directory.DirContext dc = org.owasp.webgoat.benchmark.helpers.Utils.getDirContext();
			dc.search("name", bar, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}
}
