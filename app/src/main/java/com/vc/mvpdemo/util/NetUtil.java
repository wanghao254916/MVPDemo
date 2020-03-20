package com.vc.mvpdemo.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {

    //单例模式
    private NetUtil() {

    }

    public static NetUtil getInstance() {
        return NETUTIL;
    }

    private static final NetUtil NETUTIL = new NetUtil();

    //ioToString
    private String iotoString(InputStream inputStream) throws IOException {
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }

    //doGet
    public String doGet(final String httpUtil) {
        InputStream inputStream = null;
        try {
            URL url = new URL(httpUtil);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(7000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode() == 200) {
                inputStream = httpURLConnection.getInputStream();
                final String json = iotoString(inputStream);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
