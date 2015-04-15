package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest08543")
public class BenchmarkTest08543 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames.hasMoreElements()) {
			param = headerNames.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		java.io.FileOutputStream fos = new java.io.FileOutputStream(new java.io.File(org.owasp.webgoat.benchmark.helpers.Utils.testfileDir + bar),false);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a29622 = param; //assign
		StringBuilder b29622 = new StringBuilder(a29622);  // stick in stringbuilder
		b29622.append(" SafeStuff"); // append some safe content
		b29622.replace(b29622.length()-"Chars".length(),b29622.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map29622 = new java.util.HashMap<String,Object>();
		map29622.put("key29622", b29622.toString()); // put in a collection
		String c29622 = (String)map29622.get("key29622"); // get it back out
		String d29622 = c29622.substring(0,c29622.length()-1); // extract most of it
		String e29622 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d29622.getBytes() ) )); // B64 encode and decode it
		String f29622 = e29622.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f29622); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
