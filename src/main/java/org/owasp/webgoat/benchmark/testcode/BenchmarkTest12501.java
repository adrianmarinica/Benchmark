package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12501")
public class BenchmarkTest12501 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar.toCharArray());
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a67556 = param; //assign
		StringBuilder b67556 = new StringBuilder(a67556);  // stick in stringbuilder
		b67556.append(" SafeStuff"); // append some safe content
		b67556.replace(b67556.length()-"Chars".length(),b67556.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map67556 = new java.util.HashMap<String,Object>();
		map67556.put("key67556", b67556.toString()); // put in a collection
		String c67556 = (String)map67556.get("key67556"); // get it back out
		String d67556 = c67556.substring(0,c67556.length()-1); // extract most of it
		String e67556 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d67556.getBytes() ) )); // B64 encode and decode it
		String f67556 = e67556.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f67556); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
