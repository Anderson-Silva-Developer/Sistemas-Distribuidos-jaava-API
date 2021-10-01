package br.com.andersonsilva.sendWeather;

import br.com.andersonsilva.error.EntityNotFoundException;
import br.com.andersonsilva.model.WeatheForecast;
import br.com.andersonsilva.service.WeatheForecastService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class SendWeather {
//    private static String number="55988257359";
//    private static String msmzap="teste";
//    @Autowired
//    WeatheForecastService weatheForecastService;
//
//
//    //    public SendWeather() {
////    }
////
////    public  void  sendMSM(String country,String state,String number, String msmzap) throws IOException, JSONException {
////        try {
//    public static void main(String[] args) throws IOException, JSONException {
//        String url = "http://localhost:3000/sendText";
//        URL object = new URL(url);
//        HttpURLConnection con = (HttpURLConnection) object.openConnection();
//        con.setDoOutput(true);
//        con.setDoInput(true);
//        con.setRequestProperty("Content-Type", "application/json");
//        con.setRequestProperty("Accept", "application/json");
//        con.setRequestMethod("POST");
//        JSONObject msm = new JSONObject();
//        msm.put("sessionName", "session2");
//        msm.put("number", number);
//        msm.put("text", msmzap);
//        OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
//        wr.write(msm.toString());
//        wr.flush();
//        StringBuilder sb = new StringBuilder();
//        int HttpResult = con.getResponseCode();
//        if (HttpResult == HttpURLConnection.HTTP_OK) {
//            BufferedReader br = new BufferedReader(
//                    new InputStreamReader(con.getInputStream(), "utf-8"));
//            String line = null;
//            while ((line = br.readLine()) != null) {
//                sb.append(line + "\n");
//            }
//            br.close();
//            System.out.println("" + sb.toString());
//        } else {
//            System.out.println(con.getResponseMessage());
//        }
////    }catch(
////    Exception e)
////
////    {
////        System.out.println("Error send " + e.getMessage());
////    }
//}
//
//
//
//
////    public void createMSM(String country,String state){
////        try {
////            WeatheForecast weatheForecast=this.weatheForecastService.getWeatherForecast(country,state);
////
////        }catch (IOException e){
////          throw new EntityNotFoundException("Error send msm");
////        }
////
////
////
////
////    }

}
