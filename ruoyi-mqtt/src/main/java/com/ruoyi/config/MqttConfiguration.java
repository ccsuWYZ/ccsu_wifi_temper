package com.ruoyi.config;

import com.ruoyi.mqtt.MyMQTTCallback;
import com.ruoyi.mqtt.MyMQTTClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MqttConfiguration {
    private static final Logger log = LoggerFactory.getLogger(MqttConfiguration.class);
//    private MyMQTTCallback myMQTTCallback;
    @Value("${mqtt.host}")
    String host;
    @Value("${mqtt.username}")
    String username;
    @Value("${mqtt.password}")
    String password;
    @Value("${mqtt.clientId}")
    String clientId;
    @Value("${mqtt.timeout}")
    int timeOut;
    @Value("${mqtt.keepalive}")
    int keepAlive;
    @Value("${mqtt.topic1}")
    String topic1;
//    @Value("${mqtt.topic2}")
//    String topic2;
//    @Value("${mqtt.topic3}")
//    String topic3;
//    @Value("${mqtt.topic4}")
//    String topic4;

    @Bean//注入spring
    public MyMQTTClient myMQTTClient() {
        MyMQTTClient myMQTTClient = new MyMQTTClient(host, username, password, clientId, timeOut, keepAlive);
        for (int i = 0; i < 10; i++) {
            try {
                myMQTTClient.connect();
                //不同的主题
                //   myMQTTClient.subscribe(topic1, 1);
                //   myMQTTClient.subscribe(topic2, 1);
//                   myMQTTClient.subscribe(topic3, 1);
                //   myMQTTClient.subscribe(topic4, 1);
                return myMQTTClient;
            } catch (MqttException e) {
                log.error("MQTT connect exception,connect time = " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return myMQTTClient;
    }
    public String getTopic1() {
        return topic1;
    }

    public void setTopic1(String topic1) {
        this.topic1 = topic1;
    }

//    public String getTopic2() {
//        return topic2;
//    }
//
//    public void setTopic2(String topic2) {
//        this.topic2 = topic2;
//    }
//
//    public String getTopic3() {
//        return topic3;
//    }
//
//    public void setTopic3(String topic3) {
//        this.topic3 = topic3;
//    }
//
//    public String getTopic4() {
//        return topic4;
//    }
//
//    public void setTopic4(String topic4) {
//        this.topic4 = topic4;
//    }

}
