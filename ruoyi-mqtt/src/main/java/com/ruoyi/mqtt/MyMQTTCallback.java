package com.ruoyi.mqtt;

import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.config.MqttConfiguration;
import com.ruoyi.service.DeviceMetaSensorDataService;
import com.ruoyi.utils.MqttPlayLoadToString;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Map;

public class MyMQTTCallback implements MqttCallbackExtended {

    //手动注入
    private MqttConfiguration mqttConfiguration = SpringUtils.getBean(MqttConfiguration.class);

    private static final Logger log = LoggerFactory.getLogger(MyMQTTCallback.class);

    private MyMQTTClient myMQTTClient;

    public MyMQTTCallback(MyMQTTClient myMQTTClient) {
        this.myMQTTClient = myMQTTClient;
    }



//            @Autowired
DeviceMetaSensorDataService deviceMetaSensorDataService=SpringUtils.getBean(DeviceMetaSensorDataService.class);

//    ApplicationContext context = SpringUtil.context;  //获取Spring容器
//    DeviceMetaTemperService deviceMetaTemperService = context.getBean(DeviceMetaTemperService.class);  //获取bean

    /**
     * 丢失连接，可在这里做重连
     * 只会调用一次
     *
     * @param throwable
     */
    public void connectionLost(Throwable throwable) {
        log.error("mqtt connectionLost 连接断开，5S之后尝试重连: {}", throwable.getMessage());
        long reconnectTimes = 1;
        while (true) {
            try {
                if (MyMQTTClient.getClient().isConnected()) {
                    //判断已经重新连接成功  重新订阅主题也可以 或者 connectComplete（方法里面）  看你们自己选择
                    log.warn("mqtt reconnect success end  重新连接  重新订阅成功");
                    return;
                }
                reconnectTimes += 1;
                log.warn("mqtt reconnect times = {} try again...  mqtt重新连接时间 {}", reconnectTimes, reconnectTimes);
                MyMQTTClient.getClient().reconnect();
            } catch (MqttException e) {
                log.error("mqtt断连异常", e);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
            }
        }
    }

    /**
     * @param topic
     * @param mqttMessage
     * @throws Exception subscribe后得到的消息会执行到这里面
     */
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        log.info("接收消息主题 : {}，接收消息内容 : {}", topic, new String(mqttMessage.getPayload()));
        if (topic.equals("ASD")) {

            try {
                //你自己的业务接口
//                Map maps = (Map) JSON.parse(new String(mqttMessage.getPayload(), CharsetUtil.UTF_8));

//                System.out.println(bytes_String16(mqttMessage.getPayload()));
                //把传来的mqtt消息负载转成16进制加空格

                String m= MqttPlayLoadToString.bytes_String16(mqttMessage.getPayload());
//                System.out.println(m);
                //得到的最终结果
                Map<String,Object> stringObjectMap= MqttPlayLoadToString.hexToInt(m);
                System.out.println(stringObjectMap);
                deviceMetaSensorDataService.insertDeviceMetaTemper(stringObjectMap);
            } catch (Exception e) {
                e.printStackTrace();
            }
//            System.out.println(maps);
//            insertPushAlarm(maps);
        }
    }
    /**
     * byte[] 转16进制字符串
     * @param b
     * @return
     */


    /**
     * 连接成功后的回调 可以在这个方法执行 订阅主题  只在生成Bean的 MqttConfiguration方法中订阅主题 出现bug
     * 重新连接后  主题也需要再次订阅  将重新订阅主题放在连接成功后的回调 比较合理
     *
     * @param reconnect
     * @param serverURI
     */
    public void connectComplete(boolean reconnect, String serverURI) {
        log.info("MQTT 连接成功，连接方式：{}", reconnect ? "重连" : "直连");
        //订阅主题
        myMQTTClient.subscribe(mqttConfiguration.getTopic1(), 1);
//        myMQTTClient.subscribe(mqttConfiguration.getTopic2(), 1);
//        myMQTTClient.subscribe(mqttConfiguration.getTopic3(), 1);
//        myMQTTClient.subscribe(mqttConfiguration.getTopic4(), 1);
    }

    /**
     * 消息到达后
     * subscribe后，执行的回调函数
     *
     * @param s
     * @param mqttMessage
     * @throws Exception
     */
    /**
     * publish后，配送完成后回调的方法
     *
     * @param iMqttDeliveryToken
     */
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        log.info("==========deliveryComplete={}==========", iMqttDeliveryToken.isComplete());
    }
}
