package ec.europa.eu.ext.jmstest;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.jms.JMSDestinationDefinition;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@JMSDestinationDefinition(interfaceName = "javax.jms.Queue",
                          name = "java:app/jms/Queue01",
                          destinationName = "Queue01") 

@WebServlet(urlPatterns = { "/MyServlet" })
public class MyServlet extends HttpServlet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EJB
    private MessageProducer producer;
    @EJB
    private MessageConsumer consumer;

    public MyServlet() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String method)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String message = request.getParameter("message");
        producer.sendMessage(message);
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>METHOD " + method + "</h1>");
            out.println("<h2>RECEIVED MESSAGE: " + consumer.receiveMessage() + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        processRequest(request, response, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
        processRequest(request, response, "POST");
    }
}