package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03412")
public class BenchmarkTest03412 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		// Chain a bunch of propagators in sequence
		String a92617 = param; //assign
		StringBuilder b92617 = new StringBuilder(a92617);  // stick in stringbuilder
		b92617.append(" SafeStuff"); // append some safe content
		b92617.replace(b92617.length()-"Chars".length(),b92617.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map92617 = new java.util.HashMap<String,Object>();
		map92617.put("key92617", b92617.toString()); // put in a collection
		String c92617 = (String)map92617.get("key92617"); // get it back out
		String d92617 = c92617.substring(0,c92617.length()-1); // extract most of it
		String e92617 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d92617.getBytes() ) )); // B64 encode and decode it
		String f92617 = e92617.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g92617 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g92617); // reflection
		
		
		String sql = "SELECT * from USERS where USERNAME=? and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.PreparedStatement statement = connection.prepareStatement( sql, 
			    java.sql.Statement.RETURN_GENERATED_KEYS );
			    statement.setString(1, "foo");
			statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
