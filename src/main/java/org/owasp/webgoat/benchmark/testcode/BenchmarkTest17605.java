package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17605")
public class BenchmarkTest17605 extends HttpServlet {
	
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
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a59901 = param; //assign
		StringBuilder b59901 = new StringBuilder(a59901);  // stick in stringbuilder
		b59901.append(" SafeStuff"); // append some safe content
		b59901.replace(b59901.length()-"Chars".length(),b59901.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map59901 = new java.util.HashMap<String,Object>();
		map59901.put("key59901", b59901.toString()); // put in a collection
		String c59901 = (String)map59901.get("key59901"); // get it back out
		String d59901 = c59901.substring(0,c59901.length()-1); // extract most of it
		String e59901 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d59901.getBytes() ) )); // B64 encode and decode it
		String f59901 = e59901.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g59901 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g59901); // reflection
	
		return bar;	
	}
}
