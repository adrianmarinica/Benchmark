package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14862")
public class BenchmarkTest14862 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = doSomething(param);
		
		try {
			javax.naming.directory.InitialDirContext idc = org.owasp.webgoat.benchmark.helpers.Utils.getInitialDirContext();
			Object[] filterArgs = {"a","b"};
			idc.search("name", bar, filterArgs, new javax.naming.directory.SearchControls());
		} catch (javax.naming.NamingException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70729 = param; //assign
		StringBuilder b70729 = new StringBuilder(a70729);  // stick in stringbuilder
		b70729.append(" SafeStuff"); // append some safe content
		b70729.replace(b70729.length()-"Chars".length(),b70729.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70729 = new java.util.HashMap<String,Object>();
		map70729.put("key70729", b70729.toString()); // put in a collection
		String c70729 = (String)map70729.get("key70729"); // get it back out
		String d70729 = c70729.substring(0,c70729.length()-1); // extract most of it
		String e70729 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70729.getBytes() ) )); // B64 encode and decode it
		String f70729 = e70729.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70729 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70729); // reflection
	
		return bar;	
	}
}
