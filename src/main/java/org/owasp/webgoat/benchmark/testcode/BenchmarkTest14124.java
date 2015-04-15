package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14124")
public class BenchmarkTest14124 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = doSomething(param);
		
		new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir, bar);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a14048 = param; //assign
		StringBuilder b14048 = new StringBuilder(a14048);  // stick in stringbuilder
		b14048.append(" SafeStuff"); // append some safe content
		b14048.replace(b14048.length()-"Chars".length(),b14048.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map14048 = new java.util.HashMap<String,Object>();
		map14048.put("key14048", b14048.toString()); // put in a collection
		String c14048 = (String)map14048.get("key14048"); // get it back out
		String d14048 = c14048.substring(0,c14048.length()-1); // extract most of it
		String e14048 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d14048.getBytes() ) )); // B64 encode and decode it
		String f14048 = e14048.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f14048); // reflection
	
		return bar;	
	}
}
