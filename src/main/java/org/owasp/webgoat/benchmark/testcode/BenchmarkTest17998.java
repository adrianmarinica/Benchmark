package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17998")
public class BenchmarkTest17998 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a71988 = param; //assign
		StringBuilder b71988 = new StringBuilder(a71988);  // stick in stringbuilder
		b71988.append(" SafeStuff"); // append some safe content
		b71988.replace(b71988.length()-"Chars".length(),b71988.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map71988 = new java.util.HashMap<String,Object>();
		map71988.put("key71988", b71988.toString()); // put in a collection
		String c71988 = (String)map71988.get("key71988"); // get it back out
		String d71988 = c71988.substring(0,c71988.length()-1); // extract most of it
		String e71988 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d71988.getBytes() ) )); // B64 encode and decode it
		String f71988 = e71988.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g71988 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g71988); // reflection
	
		return bar;	
	}
}
