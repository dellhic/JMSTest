package ec.europa.eu.ext.jmstest;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;

@Stateless
public class MessageConsumer {

    @Inject
    private JMSContext context;

    @Resource(mappedName = "java:app/jms/Queue01")
    private Queue myQueue;

    public String receiveMessage() {
        String message = context.createConsumer(myQueue).receiveBody(String.class, 1000);
        if (message == null) {
            message = "No message ...";
        }
        return message;
    }
}