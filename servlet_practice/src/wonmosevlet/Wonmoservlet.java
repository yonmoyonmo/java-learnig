package wonmosevlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Wonmoservlet")
public class Wonmoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Wonmoservlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setBufferSize(8192);
		PrintWriter out = response.getWriter();
		out.println("<html>" + "<head><title>Hello</title>"
		+"</head>");
		out.println(
		"<body>"
		+ "<form method=\"get\">"
		+ "<label>Operand1: </label><input type=\"text\" name=\"L\" size=\"25\" ><br>"
		+ "<label>Operand2: </label><input type=\"text\" name=\"R\" size=\"25\" ><br>"
		+ "<p>" + "<input type=\"submit\" value=\"Add\" name=\"action\" ><br>"
		+ "<input type=\"submit\" value=\"Subtract\" name=\"action\"><br>"
		+ "<input type=\"submit\" value=\"Multiply\" name=\"action\" ><br></p><br>"
		+ "<input type=\"reset\" value=\"Reset\">" + "</form>");
		if(request.getParameter("L")!=null && request.getParameter("R")!=null) {
			if(request.getParameter("action").equals("Add")) {
				String left = request.getParameter("L");
				String right = request.getParameter("R");
				int x = Integer.parseInt(left);
				int y = Integer.parseInt(right);
		
				String result = Integer.toString(x+y);
				out.println("<H2 id = \"out\"> <B>Outcome: " + result + "</B> </H2>");
				out.println("</body></html>");
				out.close();
			}
			if(request.getParameter("action").equals("Subtract")) {
				String left = request.getParameter("L");
				String right = request.getParameter("R");
				int x = Integer.parseInt(left);
				int y = Integer.parseInt(right);
		
				String result = Integer.toString(x-y);
				out.println("<H2 id = \"out\"> <B>Outcome: " + result + "</B> </H2>");
				out.println("</body></html>");
				out.close();
			}
			if(request.getParameter("action").equals("Multiply")) {
				String left = request.getParameter("L");
				String right = request.getParameter("R");
				int x = Integer.parseInt(left);
				int y = Integer.parseInt(right);
		
				String result = Integer.toString(x*y);
				out.println("<H2 id = \"out\"> <B>Outcome: " + result + "</B> </H2>");
				out.println("</body></html>");
				out.close();
			}
			
			
		}
	}
}
