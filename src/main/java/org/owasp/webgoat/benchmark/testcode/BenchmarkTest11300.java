package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11300")
public class BenchmarkTest11300 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie","SomeValue");
		
		cookie.setSecure(false);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70347 = param; //assign
		StringBuilder b70347 = new StringBuilder(a70347);  // stick in stringbuilder
		b70347.append(" SafeStuff"); // append some safe content
		b70347.replace(b70347.length()-"Chars".length(),b70347.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70347 = new java.util.HashMap<String,Object>();
		map70347.put("key70347", b70347.toString()); // put in a collection
		String c70347 = (String)map70347.get("key70347"); // get it back out
		String d70347 = c70347.substring(0,c70347.length()-1); // extract most of it
		String e70347 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70347.getBytes() ) )); // B64 encode and decode it
		String f70347 = e70347.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70347 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70347); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
