package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03624")
public class BenchmarkTest03624 extends HttpServlet {
	
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
		String a40876 = param; //assign
		StringBuilder b40876 = new StringBuilder(a40876);  // stick in stringbuilder
		b40876.append(" SafeStuff"); // append some safe content
		b40876.replace(b40876.length()-"Chars".length(),b40876.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map40876 = new java.util.HashMap<String,Object>();
		map40876.put("key40876", b40876.toString()); // put in a collection
		String c40876 = (String)map40876.get("key40876"); // get it back out
		String d40876 = c40876.substring(0,c40876.length()-1); // extract most of it
		String e40876 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d40876.getBytes() ) )); // B64 encode and decode it
		String f40876 = e40876.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f40876); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}
}
