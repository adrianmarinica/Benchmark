package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10634")
public class BenchmarkTest10634 extends HttpServlet {
	
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
		

		String bar = new Test().doSomething(param);
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a90052 = param; //assign
		StringBuilder b90052 = new StringBuilder(a90052);  // stick in stringbuilder
		b90052.append(" SafeStuff"); // append some safe content
		b90052.replace(b90052.length()-"Chars".length(),b90052.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map90052 = new java.util.HashMap<String,Object>();
		map90052.put("key90052", b90052.toString()); // put in a collection
		String c90052 = (String)map90052.get("key90052"); // get it back out
		String d90052 = c90052.substring(0,c90052.length()-1); // extract most of it
		String e90052 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d90052.getBytes() ) )); // B64 encode and decode it
		String f90052 = e90052.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g90052 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g90052); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
