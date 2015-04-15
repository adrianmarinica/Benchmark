package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest10187")
public class BenchmarkTest10187 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");

		String bar = new Test().doSomething(param);
		
		// javax.servlet.http.HttpSession.setAttribute(java.lang.String,java.lang.Object^)
		request.getSession().setAttribute( "foo", bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map85025 = new java.util.HashMap<String,Object>();
		map85025.put("keyA-85025", "a_Value"); // put some stuff in the collection
		map85025.put("keyB-85025", param.toString()); // put it in a collection
		map85025.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map85025.get("keyB-85025"); // get it back out
		bar = (String)map85025.get("keyA-85025"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
