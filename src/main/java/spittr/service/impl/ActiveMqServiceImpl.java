package spittr.service.impl;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsOperations;
import org.springframework.stereotype.Service;
import spittr.service.ActiveMqService;
import spittr.service.AlertService;

import javax.jms.*;

@Service
public class ActiveMqServiceImpl implements ActiveMqService {

    @Autowired
    private JmsOperations jmsOperations;
    @Autowired(required = false)
    private AlertService alertService;

    public void temAcsend(){
//        jmsOperations.send("spitter.queue", new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("hello template");
//            }
//        });
//        jmsOperations.send(new MessageCreator() {
//            public Message createMessage(Session session) throws JMSException {
//                return session.createTextMessage("hello template");
//            }
//        });
        //---------------------------------------
//        jmsOperations.convertAndSend("hello convertandsend");
        //-----------------------------------
        alertService.sendMessage("hello jms rpc");
    }


    public void longAcsend() {
        ConnectionFactory cf =
                new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = cf.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination =
                    new ActiveMQQueue("spitter.queue");
            MessageProducer producer = session.createProducer(destination);
            TextMessage textMessage = session.createTextMessage();
            System.out.println("hello");
            textMessage.setText("Hello world!");
            producer.send(textMessage);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {

            try {
                if (session != null) {
                    session.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    public void longAcact(){
        ActiveMQConnectionFactory connFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        Connection conn = null;
        Session session = null;
        try {
            conn = connFactory.createConnection();
            session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = new ActiveMQQueue("spitter.queue");
            MessageConsumer consumer = session.createConsumer(destination);
            Message message = consumer.receive();
            System.out.println(message);
            conn.start();
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if(session == null){
                    session.close();
                }
                if(conn == null){
                    conn.close();
                }
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }

    }
}
