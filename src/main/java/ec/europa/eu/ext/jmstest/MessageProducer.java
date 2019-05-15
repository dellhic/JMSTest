package ec.europa.eu.ext.jmstest;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class MessageProducer {

    @Inject
    private JMSContext context; 

    @Resource(mappedName = "java:app/jms/Queue01")
    private Queue myQueue; 

    public void sendMessage(String messageToSend) {
        context.createProducer().send(myQueue, messageToSend);
        System.out.println("SEND MESSAGE: " + messageToSend);
    }

}