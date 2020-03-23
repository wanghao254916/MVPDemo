package com.example.day1.activity.activity.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUtil {


    private NetUtil(){

    }
    public static NetUtil getInstance(){
        return NETUTIL;
    }
    private static final NetUtil NETUTIL = new NetUtil();

    public boolean hasNet(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo!=null&&activeNetworkInfo.isAvailable()){
            return true;
        }else {
            return false;
        }
    }

    private String ioToString(InputStream inputStream) throws IOException {
        byte[] bytes=new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int len=-1;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        String json = new String(bytes1);
        return json;
    }
    public String doGet(String urlString){
        InputStream inputStream =null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(5000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()==200){
                inputStream = httpURLConnection.getInputStream();
                String json = ioToString(inputStream);
                return json;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
