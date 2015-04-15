package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17692")
public class BenchmarkTest17692 extends HttpServlet {
	
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
        
        String[] argsEnv = { "foo=bar" };
        
		Runtime r = Runtime.getRuntime();

		try {
			Process p = r.exec(args, argsEnv, new java.io.File(System.getProperty("user.dir")));
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a63118 = param; //assign
		StringBuilder b63118 = new StringBuilder(a63118);  // stick in stringbuilder
		b63118.append(" SafeStuff"); // append some safe content
		b63118.replace(b63118.length()-"Chars".length(),b63118.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map63118 = new java.util.HashMap<String,Object>();
		map63118.put("key63118", b63118.toString()); // put in a collection
		String c63118 = (String)map63118.get("key63118"); // get it back out
		String d63118 = c63118.substring(0,c63118.length()-1); // extract most of it
		String e63118 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d63118.getBytes() ) )); // B64 encode and decode it
		String f63118 = e63118.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g63118 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g63118); // reflection
	
		return bar;	
	}
}
