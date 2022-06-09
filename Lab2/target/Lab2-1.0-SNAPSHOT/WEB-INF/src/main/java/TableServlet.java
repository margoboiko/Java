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

        // установить MIME-type и кодировку ответа
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        // Отправка веб-страницы
        try {

            // считываю GET параметры из строки запроса
            String title = request.getParameter("title");
            int rows = Integer.parseInt(request.getParameter("row"));
            int columns = Integer.parseInt(request.getParameter("col"));
            String color = request.getParameter("color");

            out.println("<html>");
            out.println("<head><title>"+title+"</title></head>");
            out.println("<body>");
            out.println("<h1>" + title + "</h1>");

            // генерирую HTML таблицу
            out.println("<table style='background-color:"+color+";'>");
            for (int i=0; i < rows; i++) {
                out.println("<tr>");
                for (int j=0; j < columns; j++) {
                    out.println("<td>"+i+"/"+j+"</td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");

            out.println("</body></html>");
        } finally {
            out.close();  // Всегда закрывать Writer
        }
    }
}