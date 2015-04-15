package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest19557")
public class BenchmarkTest19557 extends HttpServlet {
	
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

		String bar = doSomething(param);
		
	
		String a1 = "";
		String a2 = "";
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	a1 = "cmd.exe";
        	a2 = "/c";
        } else {
        	a1 = "sh";
        	a2 = "-c";
        }
        String[] args = {a1, a2, "echo", bar};
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a94987 = param; //assign
		StringBuilder b94987 = new StringBuilder(a94987);  // stick in stringbuilder
		b94987.append(" SafeStuff"); // append some safe content
		b94987.replace(b94987.length()-"Chars".length(),b94987.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map94987 = new java.util.HashMap<String,Object>();
		map94987.put("key94987", b94987.toString()); // put in a collection
		String c94987 = (String)map94987.get("key94987"); // get it back out
		String d94987 = c94987.substring(0,c94987.length()-1); // extract most of it
		String e94987 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d94987.getBytes() ) )); // B64 encode and decode it
		String f94987 = e94987.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f94987); // reflection
	
		return bar;	
	}
}
