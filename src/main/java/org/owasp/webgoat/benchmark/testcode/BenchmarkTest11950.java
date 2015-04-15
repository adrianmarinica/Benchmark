package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11950")
public class BenchmarkTest11950 extends HttpServlet {
	
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
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a24256 = param; //assign
		StringBuilder b24256 = new StringBuilder(a24256);  // stick in stringbuilder
		b24256.append(" SafeStuff"); // append some safe content
		b24256.replace(b24256.length()-"Chars".length(),b24256.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map24256 = new java.util.HashMap<String,Object>();
		map24256.put("key24256", b24256.toString()); // put in a collection
		String c24256 = (String)map24256.get("key24256"); // get it back out
		String d24256 = c24256.substring(0,c24256.length()-1); // extract most of it
		String e24256 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d24256.getBytes() ) )); // B64 encode and decode it
		String f24256 = e24256.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g24256 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g24256); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
