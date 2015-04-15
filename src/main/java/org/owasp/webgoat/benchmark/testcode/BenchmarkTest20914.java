package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest20914")
public class BenchmarkTest20914 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		org.owasp.webgoat.benchmark.helpers.SeparateClassRequest scr = new org.owasp.webgoat.benchmark.helpers.SeparateClassRequest( request );
		String param = scr.getTheValue("foo");

		String bar = doSomething(param);
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		// Chain a bunch of propagators in sequence
		String a89554 = param; //assign
		StringBuilder b89554 = new StringBuilder(a89554);  // stick in stringbuilder
		b89554.append(" SafeStuff"); // append some safe content
		b89554.replace(b89554.length()-"Chars".length(),b89554.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map89554 = new java.util.HashMap<String,Object>();
		map89554.put("key89554", b89554.toString()); // put in a collection
		String c89554 = (String)map89554.get("key89554"); // get it back out
		String d89554 = c89554.substring(0,c89554.length()-1); // extract most of it
		String e89554 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d89554.getBytes() ) )); // B64 encode and decode it
		String f89554 = e89554.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g89554 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g89554); // reflection
	
		return bar;	
	}
}
