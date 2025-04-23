package org.apache.rocketmq.example.simple;

import org.apache.rocketmq.acl.common.AclClientRPCHook;
import org.apache.rocketmq.acl.common.SessionCredentials;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.RPCHook;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class AclProducer {
    public static void main(String[] args) throws MQClientException, InterruptedException {
        System.setProperty("rocketmq.client.logUseSlf4j", "true");
        DefaultMQProducer producer = new DefaultMQProducer("ljx", getAclRPCHook());
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        for (int i = 0; i < 1; i++) {
            try {
                Message msg = new Message("TopicTest" ,"*" , ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
                SendResult sendResult = producer.send(msg);
                System.out.printf("%s%n", sendResult);
            } catch (Exception e) {
                e.printStackTrace();
                Thread.sleep(1000);
            }
        }

        while (true) {
            Thread.sleep(10000);
        }
    }

    static RPCHook getAclRPCHook() {
        return new AclClientRPCHook(new SessionCredentials("RocketMQ","12345678"));
    }
}
