package controller;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import model.*;

public class Controller {
	String header;
	private static final String GET_URL = "http://localhost:5333/";
    public void sendGET(String key) throws IOException {
        URL url = new URL(GET_URL + key);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");        
        header = Header.createHeader(key);
        con.setRequestProperty("Content-Type", header);
        int responseCode = con.getResponseCode();
        if(responseCode == 200) {
        	System.out.println("Response OK\n");
        }else {
        	System.out.println("Response NOK\n");
        }
    }

    public void sendDELETE(String key) throws  IOException{
        URL obj = new URL(GET_URL + "?" +key);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("DELETE");

        int responseCode = con.getResponseCode();

    }
    
    public void sendSET(String key, String value, String valueType) throws  IOException{

        URL obj = new URL(GET_URL + "?" +key);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");


        con.setRequestProperty("Content-type",valueType);
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(value);
        int responseCode = con.getResponseCode();
    }
    
    public void sendINCR(String key) throws IOException {
        URL obj = new URL(GET_URL + "?" + key);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");

        int responseCode = con.getResponseCode();
    }
    
    public void sendDECR(String key) throws IOException {
        URL obj = new URL(GET_URL + "?" + key);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("PUT");

        int responseCode = con.getResponseCode();
    }   
}
