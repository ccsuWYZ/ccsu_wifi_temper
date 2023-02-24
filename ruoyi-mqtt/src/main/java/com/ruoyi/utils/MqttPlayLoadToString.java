package com.ruoyi.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lee
 * @date 2022-12-19 21:06:36
 * @description
 */
public class MqttPlayLoadToString {
    //把传过来的消息负载转为16进制
    public static String bytes_String16(byte[] b) {
        char[] _16 = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i<b.length;i++) {
            sb.append(_16[b[i]>>4&0xf])
                    .append(_16[b[i]&0xf]);
        }
        String TransFerResult=sb.toString();
//        System.out.println(TransFerResult);
        String FinalResult="";
        for (int i = 0; i < TransFerResult.length(); i++) {
            if(i%2==0&&i!=0){
                FinalResult+=" ";
                FinalResult+=TransFerResult.charAt(i);
            }else{
                FinalResult+=TransFerResult.charAt(i);
            }
        }
        return FinalResult;
    }
    public static Map<String,Object> hexToInt(String hex){
        //按空格把传进来的字符串分割成字符串数组
        String [] s;
//        System.out.println(hex);
        //初始化一个map
        Map<String,Object> stringObjectMap=new HashMap<>();
        String temperString="";
        s=hex.split(" ");
        for (int i = 0; i < s.length; i++) {
            if(i<=3){//存mac地址
                temperString+=String.valueOf(Integer.parseInt(s[i],16));
                if(i==3){
                    stringObjectMap.put("device_id",temperString);

                    temperString="";
                }

            }else if(i>3&&i<=8){//存第一个温度
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);

                if(i==8)  {
                    stringObjectMap.put("1",formateInterger(temperString)) ;
                    temperString="";
                }

            } else if (i>8&&i<=13) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==13)  {
                    stringObjectMap.put("2",formateInterger(temperString)) ;
                    temperString="";
                }

            } else if (i>13&&i<=18) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==18)  {
                    stringObjectMap.put("3",formateInterger(temperString)) ;
                    temperString="";
                }

            } else if (i>18&&i<=23) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==23){
                    stringObjectMap.put("4",formateInterger(temperString)) ;
                    temperString="";
                }

            }else if (i>23&&i<=28) {
                temperString+=String.valueOf(Integer.parseInt(s[i],16)-48);
                if(i==28){
                    stringObjectMap.put("voltage",formateInterger(temperString)/1000.0) ;
                    temperString="";
                }

            }
        }

        return stringObjectMap;
    }

    public static int formateInterger(String num){
        int res=0;
        res+=Integer.parseInt(String.valueOf(num.charAt(4)))*1;
        res+=Integer.parseInt(String.valueOf(num.charAt(3)))*10;
        res+=Integer.parseInt(String.valueOf(num.charAt(2)))*100;
        res+=Integer.parseInt(String.valueOf(num.charAt(1)))*1000;
        res+=Integer.parseInt(String.valueOf(num.charAt(0)))*10000;
        return res;
    }
}
