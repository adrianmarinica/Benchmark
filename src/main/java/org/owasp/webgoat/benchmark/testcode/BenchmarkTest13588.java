package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13588")
public class BenchmarkTest13588 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = new Test().doSomething(param);
		
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase");
			throw new ServletException(e);
		}
		
		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String) executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a57016 = param; //assign
		StringBuilder b57016 = new StringBuilder(a57016);  // stick in stringbuilder
		b57016.append(" SafeStuff"); // append some safe content
		b57016.replace(b57016.length()-"Chars".length(),b57016.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map57016 = new java.util.HashMap<String,Object>();
		map57016.put("key57016", b57016.toString()); // put in a collection
		String c57016 = (String)map57016.get("key57016"); // get it back out
		String d57016 = c57016.substring(0,c57016.length()-1); // extract most of it
		String e57016 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d57016.getBytes() ) )); // B64 encode and decode it
		String f57016 = e57016.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f57016); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
