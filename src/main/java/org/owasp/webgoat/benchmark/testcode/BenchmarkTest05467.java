package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest05467")
public class BenchmarkTest05467 extends HttpServlet {
	
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
		String a52087 = param; //assign
		StringBuilder b52087 = new StringBuilder(a52087);  // stick in stringbuilder
		b52087.append(" SafeStuff"); // append some safe content
		b52087.replace(b52087.length()-"Chars".length(),b52087.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map52087 = new java.util.HashMap<String,Object>();
		map52087.put("key52087", b52087.toString()); // put in a collection
		String c52087 = (String)map52087.get("key52087"); // get it back out
		String d52087 = c52087.substring(0,c52087.length()-1); // extract most of it
		String e52087 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d52087.getBytes() ) )); // B64 encode and decode it
		String f52087 = e52087.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f52087); // reflection
		
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar));
	}
}
