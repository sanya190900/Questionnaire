import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@javax.servlet.annotation.WebServlet(name = "StatisticsServlet", urlPatterns = {"/statistics"})
public class StatisticsServlet extends javax.servlet.http.HttpServlet {
    private AtomicInteger total = new AtomicInteger(0);
    private AtomicInteger olderThan10 = new AtomicInteger(0);
    private AtomicInteger smallerThan10 = new AtomicInteger(0);
    private AtomicInteger feelingGood = new AtomicInteger(0);
    private AtomicInteger feelingBad = new AtomicInteger(0);

    public void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {
            response.setContentType("text/html");
            String answerAboutAge = request.getParameter("age");
            String answerAboutFeeling = request.getParameter("feeling");
            if(answerAboutAge != null && answerAboutFeeling != null){
                total.incrementAndGet();
                if(answerAboutAge.equals("yes")){
                    olderThan10.incrementAndGet();
                }
                if(answerAboutAge.equals("no")){
                    smallerThan10.incrementAndGet();
                }
                if(answerAboutFeeling.equals("good")){
                    feelingGood.incrementAndGet();
                }
                if(answerAboutFeeling.equals("bad")){
                    feelingBad.incrementAndGet();
                }
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<html>\n" +
                        "<head>\n" +
                        "\t<title>Statistics</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\t<p style=\"margin-left: 80px\">Result table</p>\n" +
                        "<p>Total answers : " + total + "</p>\n" +
                        "\t<table border=\"1\">\n" +
                        "\t\t<caption style=\"width: 17vw\">Question 1. Are you older than 10?</caption>\n" +
                        "\t\t<tr><th>Yes</th><th>No</th></tr>\n" +
                        "\t\t<tr><td>" + olderThan10 + "</td><td>" + smallerThan10 + "</td></tr>\n" +
                        "\t</table>\n" +
                        "\t<br>\n" +
                        "\t<table border=\"1\">\n" +
                        "\t\t<caption style=\"width: 17vw\">Question 2. How are you?</caption>\n" +
                        "\t\t<tr><th>Good</th><th>Bad</th></tr>\n" +
                        "\t\t<tr><td>" + feelingGood + "</td><td>" + feelingBad + "</td></tr>\n" +
                        "\t</table>\n" +
                        "</body>\n" +
                        "</html>");
            }else{
                PrintWriter printWriter = response.getWriter();
                printWriter.println("<html>\n" +
                        "<head>\n" +
                        "\t<title>Error</title>\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "\t<h1 style=\"color: red; font-size: 25\">You have not answered all the questions. Answer all questions and try again!</h1>\n" +
                        "</body>\n" +
                        "</html>");
            }
    }
}
