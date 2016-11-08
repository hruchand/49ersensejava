import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class SetData {
public static void setMainfloorTemp(){
	try {
        int temp_curr;
        String cId = "1";
        String url = "http://"+ManageDB.ip+"/setTherCur.php";
        URL urlObj = new URL(url);
        String result = "";
        String data = "cId=" + java.net.URLEncoder.encode(cId, "UTF-8");
        String data1 = " " + java.net.URLEncoder.encode(Integer.toString(Thermostat.getCurrentTemperature()), "UTF-8");
        //1
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        //2
        DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
        dataOut.writeBytes(data);
        dataOut.writeBytes(data1);
        //3
        dataOut.flush();
        dataOut.close();
        DataInputStream in = new DataInputStream(conn.getInputStream());

        String g;
        while ((g = in.readLine()) != null) {

            result += g;

        }
        

        in.close();
        //Log.d("fetchdata", "value" + result);
        //String[] numbersArray = result.split(" ");
       // current_temp_upstairs = Integer.parseInt(numbersArray[0]);
       // current_temp_main = Integer.parseInt(numbersArray[1]);
    }
    catch (Exception e){

    }
}

public static void setThermDataup (){

    try {
     
        String cId = "1";
        String url = "http://"+ManageDB.ip+"/setTherupCur.php";
        URL urlObj = new URL(url);
        String result = "";
        String data = "cId=" + java.net.URLEncoder.encode(cId, "UTF-8");
        String data1 = " " + java.net.URLEncoder.encode(Integer.toString(ThermostatUpstair.getCurrentTemperature()), "UTF-8");
        //1
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        //2
        DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
        dataOut.writeBytes(data);
        dataOut.writeBytes(data1);
        //3
        dataOut.flush();
        dataOut.close();
        DataInputStream in = new DataInputStream(conn.getInputStream());

        String g;
        while ((g = in.readLine()) != null) {

            result += g;

        }
       

        in.close();
        //Log.d("fetchdata", "value" + result);
        //String[] numbersArray = result.split(" ");
        // current_temp_upstairs = Integer.parseInt(numbersArray[0]);
        // current_temp_main = Integer.parseInt(numbersArray[1]);
    }
    catch (Exception e){

    }


}
}

