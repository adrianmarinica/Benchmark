package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17728")
public class BenchmarkTest17728 extends HttpServlet {
	
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
		
		// javax.servlet.http.HttpSession.putValue(java.lang.String^,java.lang.Object)
		request.getSession().putValue( bar, "foo");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a98290 = param; //assign
		StringBuilder b98290 = new StringBuilder(a98290);  // stick in stringbuilder
		b98290.append(" SafeStuff"); // append some safe content
		b98290.replace(b98290.length()-"Chars".length(),b98290.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map98290 = new java.util.HashMap<String,Object>();
		map98290.put("key98290", b98290.toString()); // put in a collection
		String c98290 = (String)map98290.get("key98290"); // get it back out
		String d98290 = c98290.substring(0,c98290.length()-1); // extract most of it
		String e98290 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d98290.getBytes() ) )); // B64 encode and decode it
		String f98290 = e98290.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f98290); // reflection
	
		return bar;	
	}
}
