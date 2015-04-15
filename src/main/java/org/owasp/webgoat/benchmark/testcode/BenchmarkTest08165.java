package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08165")
public class BenchmarkTest08165 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getHeader("foo");

		String bar = new Test().doSomething(param);
		
		long l = new java.util.Random().nextLong();
		
		response.getWriter().println("Weak Randomness Test java.util.Random.nextLong() executed");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a43177 = param; //assign
		StringBuilder b43177 = new StringBuilder(a43177);  // stick in stringbuilder
		b43177.append(" SafeStuff"); // append some safe content
		b43177.replace(b43177.length()-"Chars".length(),b43177.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map43177 = new java.util.HashMap<String,Object>();
		map43177.put("key43177", b43177.toString()); // put in a collection
		String c43177 = (String)map43177.get("key43177"); // get it back out
		String d43177 = c43177.substring(0,c43177.length()-1); // extract most of it
		String e43177 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d43177.getBytes() ) )); // B64 encode and decode it
		String f43177 = e43177.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g43177 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g43177); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
