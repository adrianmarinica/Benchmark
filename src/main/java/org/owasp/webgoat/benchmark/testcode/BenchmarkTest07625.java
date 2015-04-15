package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest07625")
public class BenchmarkTest07625 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		javax.servlet.http.Cookie[] cookies = request.getCookies();
		
		String param = null;
		boolean foundit = false;
		if (cookies != null) {
			for (javax.servlet.http.Cookie cookie : cookies) {
				if (cookie.getName().equals("foo")) {
					param = cookie.getValue();
					foundit = true;
				}
			}
			if (!foundit) {
				// no cookie found in collection
				param = "";
			}
		} else {
			// no cookies
			param = "";
		}

		String bar = new Test().doSomething(param);
		
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
			Process p = r.exec(args, argsEnv);
			org.owasp.webgoat.benchmark.helpers.Utils.printOSCommandResults(p);
		} catch (IOException e) {
			System.out.println("Problem executing cmdi - TestCase");
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70962 = param; //assign
		StringBuilder b70962 = new StringBuilder(a70962);  // stick in stringbuilder
		b70962.append(" SafeStuff"); // append some safe content
		b70962.replace(b70962.length()-"Chars".length(),b70962.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70962 = new java.util.HashMap<String,Object>();
		map70962.put("key70962", b70962.toString()); // put in a collection
		String c70962 = (String)map70962.get("key70962"); // get it back out
		String d70962 = c70962.substring(0,c70962.length()-1); // extract most of it
		String e70962 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70962.getBytes() ) )); // B64 encode and decode it
		String f70962 = e70962.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70962 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70962); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
