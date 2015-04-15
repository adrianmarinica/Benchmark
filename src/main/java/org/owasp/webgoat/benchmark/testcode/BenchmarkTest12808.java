package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12808")
public class BenchmarkTest12808 extends HttpServlet {
	
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

		String bar = new Test().doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a70021 = param; //assign
		StringBuilder b70021 = new StringBuilder(a70021);  // stick in stringbuilder
		b70021.append(" SafeStuff"); // append some safe content
		b70021.replace(b70021.length()-"Chars".length(),b70021.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map70021 = new java.util.HashMap<String,Object>();
		map70021.put("key70021", b70021.toString()); // put in a collection
		String c70021 = (String)map70021.get("key70021"); // get it back out
		String d70021 = c70021.substring(0,c70021.length()-1); // extract most of it
		String e70021 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d70021.getBytes() ) )); // B64 encode and decode it
		String f70021 = e70021.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g70021 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g70021); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
