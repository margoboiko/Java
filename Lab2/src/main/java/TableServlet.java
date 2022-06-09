import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TableServlet", value = "/table")
public class TableServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String title = request.getParameter("title");
            int rows = Integer.parseInt(request.getParameter("row"));
            int columns = Integer.parseInt(request.getParameter("col"));
            String color = request.getParameter("color");

            out.println("<!DOCTYPE html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n");
            out.println("<html>\n");
            out.println("<head><title>"+title+"</title></head>");
            out.println("<link rel=\"stylesheet\" HREF=\"styles/bootstrap.min.css\"");
            out.println("<body>");
            out.println("<h1 class=\"text-center pt-5\">" + title + "</h1>");

            out.println("<div class=\"mt-5 d-flex justify-content-center\">");
            out.println("<table style=\"background-color:"+color+";\">");
            for (int i=0; i < rows; i++) {
                out.println("<tr>");
                for (int j=0; j < columns; j++) {
                    out.println("<td  class=\"p-4\" style=\"border: 1px solid black; font-size: 20px;\">"+i+j+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<div class=\"pt-3 d-flex justify-content-center\">");
            out.println("<a href=\"index.jsp\">Повернутись на головну сторінку</a>");
            out.println("</div>");
            out.println("</div>");

            out.println("</body></html>");
        } finally {
            out.close();
        }
    }
}