package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest09464")
public class BenchmarkTest09464 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> headers = request.getHeaders("foo");
		if (headers.hasMoreElements()) {
			param = headers.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie("SomeCookie",bar);
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		
		response.addCookie(cookie);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map49907 = new java.util.HashMap<String,Object>();
		map49907.put("keyA-49907", "a_Value"); // put some stuff in the collection
		map49907.put("keyB-49907", param.toString()); // put it in a collection
		map49907.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map49907.get("keyB-49907"); // get it back out
		bar = (String)map49907.get("keyA-49907"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
