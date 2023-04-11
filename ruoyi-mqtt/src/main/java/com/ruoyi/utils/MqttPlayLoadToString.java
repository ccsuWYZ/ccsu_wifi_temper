package com.ruoyi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lee
 * @date 2022-12-19 21:06:36
 * @description
 */
public class MqttPlayLoadToString {

    public static String bytes_String16(byte[] b) {
        StringBuilder sb = new StringBuilder();
        for (byte value : b) {
            sb.append(String.format("%02X", value));
        }
        return sb.toString().replaceAll("..(?!$)", "$0 ");
    }


    //解析的数据格式：
    // {1=2, 2=2, 3=2, device_id=48484853, 4=2, voltage=0.034}，
    // 1，2，3，4分别代表四个温度，voltage是电压，device_id是设备的唯一标识

    public static Map<String,Object> hexToInt(String hex){
        //按空格把传进来的字符串分割成字符串数组
        String [] s;
        //初始化一个map
        Map<String,Object> stringObjectMap=new HashMap<>();

        String temperString="";

        s=hex.split(" ");

        for (int i = 0; i < s.length; i++) {
            if(i<=3){//存mac地址
                temperString+=String.valueOf(Integer.parseInt(s[i],16));//把十六进制的数转10进制
                if(i==3){
                    stringObjectMap.put("device_id",temperString);

                    temperString="";
                }

            }else if(i>3&&i<=8){//存第一个温度
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);//把十六进制的数转10进制，但是只得到了各个数位上的数值，需要再乘对应的数

                if(i==8)  {
                    stringObjectMap.put("1",  Integer.parseInt(temperString,10)) ;
                    temperString="";
                }

            } else if (i>8&&i<=13) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==13)  {
                    stringObjectMap.put("2",Integer.parseInt(temperString,10)) ;
                    temperString="";
                }

            } else if (i>13&&i<=18) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==18)  {
                    stringObjectMap.put("3",Integer.parseInt(temperString,10)) ;
                    temperString="";
                }

            } else if (i>18&&i<=23) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==23){
                    stringObjectMap.put("4",Integer.parseInt(temperString,10)) ;
                    temperString="";
                }

            }else if (i>23&&i<=28) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==28){
                    stringObjectMap.put("voltage",Integer.parseInt(temperString,10)/1000.0) ;
                    temperString="";
                }

            }
        }

        return stringObjectMap;
    }
}