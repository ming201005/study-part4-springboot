package com.springboot.codingstudty.comm;


import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 描述：
 *
 * @author ming
 * @version 1.0
 * @date 2019-12-12 21:20
 * @see
 */
public class ReadProperties {

    private static String PROPERTIES_NAME = "application.properties";

    @Value("${server.port}")
    public  String  port;

    public String getPort() {
        return port;
    }

    /**
     * main函数
     */
    public static void main(String[] args) {
        try {
            Properties properties = ReadProperties.getProperties ();
            //输出
            String port = properties.getProperty ("server.port");
            System.out.println ("通过Properties读取port="+port);

        }catch (Exception e) {
            System.out.println (e.getMessage ());
        }

        ReadProperties properties = new ReadProperties();
        System.out.println ("@value="+properties.getPort ());

    }

    /**
     * 加载配置信息文件
     * @throws IOException
     */
    public static Properties getProperties() throws IOException {
        Properties properties = null;

        if(properties == null) {
            InputStream inputStream = ReadProperties.class.getClassLoader ()
                    .getResourceAsStream (PROPERTIES_NAME);
            properties = new Properties ();
            properties.load (inputStream);


        }
        return properties;
    }


}
