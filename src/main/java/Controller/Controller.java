/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import Model.Model;
import Model.OperationDTO;
import Model.ValueType;


public class Controller {
    private static final String GET_URL = "localhost";
    Model model=new Model();

    public void sendGET(String keys) throws IOException {
        URL obj = new URL(GET_URL + "?" + keys);
        //URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();
        model.getResponde(responseCode,con);


    }

    public void delete(String key) throws  IOException{
        URL obj = new URL(GET_URL + "?" +key);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("DELETE");

        int responseCode = con.getResponseCode();
        model.getResponde(responseCode,con);


    }

    public void sendPost(String key, String value, String valueType) throws  IOException{

        URL obj = new URL(GET_URL + "?" +key);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");


        con.setRequestProperty("Content-type",valueType);
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(value);
        int responseCode = con.getResponseCode();
        model.getResponde(responseCode,con);



    }

    private static void sendBULK(List<OperationDTO> operationsList){
        URL obj = new URL (GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("BULK");

        con.setRequestProperty("User-Agent", operationsList);
        int responseCode = con.getResponseCode();
        
        System.out.println("BULK Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("BULK request not worked");
        }
    }      
}
