package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest00848")
public class BenchmarkTest00848 extends HttpServlet {
	
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
		
		
		// Chain a bunch of propagators in sequence
		String a38505 = param; //assign
		StringBuilder b38505 = new StringBuilder(a38505);  // stick in stringbuilder
		b38505.append(" SafeStuff"); // append some safe content
		b38505.replace(b38505.length()-"Chars".length(),b38505.length(),"Chars"); //replace some of the end content
		java.util.HashMap<String,Object> map38505 = new java.util.HashMap<String,Object>();
		map38505.put("key38505", b38505.toString()); // put in a collection
		String c38505 = (String)map38505.get("key38505"); // get it back out
		String d38505 = c38505.substring(0,c38505.length()-1); // extract most of it
		String e38505 = new String( new sun.misc.BASE64Decoder().decodeBuffer( 
		    new sun.misc.BASE64Encoder().encode( d38505.getBytes() ) )); // B64 encode and decode it
		String f38505 = e38505.split(" ")[0]; // split it on a space
		org.owasp.webgoat.benchmark.helpers.ThingInterface thing = org.owasp.webgoat.benchmark.helpers.ThingFactory.createThing();
		String g38505 = "barbarians_at_the_gate";  // This is static so this whole flow is 'safe'
		String bar = thing.doSomething(g38505); // reflection
		
		
		String sql = "{call verifyUserPassword('foo','"+bar+"')}";
				
		try {
			java.sql.Connection connection = org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlConnection();
			java.sql.CallableStatement statement = connection.prepareCall( sql );
		    statement.execute();
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
