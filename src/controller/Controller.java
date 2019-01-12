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
        	System.out.println("Response: " + responseCode + " OK\n");
        }else {
        	System.out.println("Response: " + responseCode + " NOK\n");
        }
    }

    public void sendDELETE(String key) throws  IOException{
    	URL url = new URL(GET_URL + key);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("DELETE");
    	header = Header.createHeader(key);
    	con.setRequestProperty("Content-Type", header);
    	int responseCode = con.getResponseCode();
        if(responseCode == 200) {
        	System.out.println("Response: " + responseCode + " OK\n");
        }else {
        	System.out.println("Response: " + responseCode + " NOK\n");
        }
    }
    
    public void sendSET(String key, String value) throws  IOException{

    	URL url = new URL(GET_URL + key);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        header = Header.createHeader(key);
        con.setRequestProperty("Content-type", header);
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(value);
        int responseCode = con.getResponseCode();
        if(responseCode == 200) {
        	System.out.println("Response: " + responseCode + " OK\n");
        }else {
        	System.out.println("Response: " + responseCode + " NOK\n");
        }
    }
    
    public void sendINCR(String key) throws IOException {
    	URL url = new URL(GET_URL + key);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("PUT");
    	header = Header.createHeader(key);
    	con.setRequestProperty("Content-Type", header);
    	int responseCode = con.getResponseCode();
        if(responseCode == 200) {
        	System.out.println("Response: " + responseCode + " OK\n");
        }else {
        	System.out.println("Response: " + responseCode + " NOK\n");
        }
    }
    
    public void sendDECR(String key) throws IOException {
    	URL url = new URL(GET_URL + key);
    	HttpURLConnection con = (HttpURLConnection) url.openConnection();
    	con.setRequestMethod("PUT");
    	header = Header.createHeader(key);
    	con.setRequestProperty("Content-Type", header);
    	int responseCode = con.getResponseCode();
        if(responseCode == 200) {
        	System.out.println("Response: " + responseCode + " OK\n");
        }else {
        	System.out.println("Response: " + responseCode + " NOK\n");
        }
    }   
}
