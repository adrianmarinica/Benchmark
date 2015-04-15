package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest13713")
public class BenchmarkTest13713 extends HttpServlet {
	
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
		
		java.util.List<String> argList = new java.util.ArrayList<String>();
		
		String osName = System.getProperty("os.name");
        if (osName.indexOf("Windows") != -1) {
        	argList.add("cmd.exe");
        	argList.add("/c");
        } else {
        	argList.add("sh");
        	argList.add("-c");
        }
        argList.add("echo");
        argList.add(bar);

		ProcessBuilder pb = new ProcessBuilder();

		pb.command(argList);
		
		try {
			Process p = pb.start();
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - java.lang.ProcessBuilder(java.util.List) Test Case");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70066 = param; //assign
		StringBuilder b70066 = new StringBuilder(a70066);  // stick in stringbuilder
		b70066.append(" SafeStuff"); // append some safe content
		b70066.replace(b70066.length()-"Chars".length(),b70066.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70066 = new java.util.HashMap<String,Object>();
		map70066.put("key70066", b70066.toString()); // put in a collection
		String c70066 = (String)map70066.get("key70066"); // get it back out
		String d70066 = c70066.substring(0,c70066.length()-1); // extract most of it
		String e70066 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70066.getBytes() ) )); // B64 encode and decode it
		String f70066 = e70066.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f70066); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
