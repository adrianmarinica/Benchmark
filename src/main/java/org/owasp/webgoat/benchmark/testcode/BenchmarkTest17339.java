package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17339")
public class BenchmarkTest17339 extends HttpServlet {
	
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
		

		String bar = doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar, false);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a3015 = param; //assign
		StringBuilder b3015 = new StringBuilder(a3015);  // stick in stringbuilder
		b3015.append(" SafeStuff"); // append some safe content
		b3015.replace(b3015.length()-"Chars".length(),b3015.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map3015 = new java.util.HashMap<String,Object>();
		map3015.put("key3015", b3015.toString()); // put in a collection
		String c3015 = (String)map3015.get("key3015"); // get it back out
		String d3015 = c3015.substring(0,c3015.length()-1); // extract most of it
		String e3015 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d3015.getBytes() ) )); // B64 encode and decode it
		String f3015 = e3015.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g3015 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g3015); // reflection
	
		return bar;	
	}
}
