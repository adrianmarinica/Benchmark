package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest14152")
public class BenchmarkTest14152 extends HttpServlet {
	
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
		
		// FILE URIs are tricky because they are different between Mac and Windows because of lack of standardization.
		// Mac requires an extra slash for some reason.
		String startURIslashes = "";
        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        if (System.getProperty("os.name").indexOf("Windows") != -1)
	        	startURIslashes = "/";
	        else startURIslashes = "//";

		try {
			java.net.URI fileURI = new java.net.URI("file", null, startURIslashes 
				+ org.owasp.webgoat.benchmark.helpers.Utils.testfileDir.replace('\\', java.io.File.separatorChar).replace(' ', '_') + bar, null, null);
			new java.io.File(fileURI);
		} catch (java.net.URISyntaxException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a9763 = param; //assign
		StringBuilder b9763 = new StringBuilder(a9763);  // stick in stringbuilder
		b9763.append(" SafeStuff"); // append some safe content
		b9763.replace(b9763.length()-"Chars".length(),b9763.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map9763 = new java.util.HashMap<String,Object>();
		map9763.put("key9763", b9763.toString()); // put in a collection
		String c9763 = (String)map9763.get("key9763"); // get it back out
		String d9763 = c9763.substring(0,c9763.length()-1); // extract most of it
		String e9763 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d9763.getBytes() ) )); // B64 encode and decode it
		String f9763 = e9763.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g9763 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g9763); // reflection
	
		return bar;	
	}
}
