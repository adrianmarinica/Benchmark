package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11980")
public class BenchmarkTest11980 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheParameter("foo");

		String bar = new Test().doSomething(param);
		
		response.addHeader("SomeHeader", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a64928 = param; //assign
		StringBuilder b64928 = new StringBuilder(a64928);  // stick in stringbuilder
		b64928.append(" SafeStuff"); // append some safe content
		b64928.replace(b64928.length()-"Chars".length(),b64928.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map64928 = new java.util.HashMap<String,Object>();
		map64928.put("key64928", b64928.toString()); // put in a collection
		String c64928 = (String)map64928.get("key64928"); // get it back out
		String d64928 = c64928.substring(0,c64928.length()-1); // extract most of it
		String e64928 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d64928.getBytes() ) )); // B64 encode and decode it
		String f64928 = e64928.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g64928 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g64928); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
