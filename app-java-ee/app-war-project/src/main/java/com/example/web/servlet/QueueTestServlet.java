package com.example.web.servlet;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queueTest")
public class QueueTestServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Context jndiContext=new InitialContext();
            
            ConnectionFactory connectionFactory = (ConnectionFactory)jndiContext.lookup("java:jboss/exported/jms/RemoteConnectionFactory");
            
            Queue queue = (Queue) jndiContext.lookup("java:/jms/queue/CatalogQueue");
            
            Connection connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(queue);
            
            TextMessage textMessage = session.createTextMessage();
            
            textMessage.setText(req.getParameter("message"));
            
            producer.send(textMessage);

            connection.close();
            
        } catch (NamingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
