package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest12186")
public class BenchmarkTest12186 extends HttpServlet {
	
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
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, new String[] { "username", "password" } );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a30715 = param; //assign
		StringBuilder b30715 = new StringBuilder(a30715);  // stick in stringbuilder
		b30715.append(" SafeStuff"); // append some safe content
		b30715.replace(b30715.length()-"Chars".length(),b30715.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map30715 = new java.util.HashMap<String,Object>();
		map30715.put("key30715", b30715.toString()); // put in a collection
		String c30715 = (String)map30715.get("key30715"); // get it back out
		String d30715 = c30715.substring(0,c30715.length()-1); // extract most of it
		String e30715 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d30715.getBytes() ) )); // B64 encode and decode it
		String f30715 = e30715.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String bar = thing.doSomething(f30715); // reflection

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
