import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FetchData {
	public static void fetchCurTemp(){
		try {
			System.out.println("inside the fetch cur temp");
String returnedValue = Client.fetchValues(3001);

String [] numbersArray = returnedValue.split(" ");
System.out.println("first val"+numbersArray[0]);
System.out.println("second val"+numbersArray[1]);

//System.out.println("socket returned value \n");
//System.out.println(returnedValue);
//            int temp_curr;
//            String cId = "1";
//            String url = "http://"+ManageDB.ip+"/fetchTher.php";
//            URL urlObj = new URL(url);
//            String result = "";
//            String data = "cId=" + java.net.URLEncoder.encode(cId, "UTF-8");
//            //1
//            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            conn.setUseCaches(false);
//            conn.setRequestMethod("POST");
//            //2
//            DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
//            dataOut.writeBytes(data);
//            //3
//            dataOut.flush();
//            dataOut.close();
//            DataInputStream in = new DataInputStream(conn.getInputStream());
//
//            String g;
//            while((g = in.readLine()) != null){
//
//                result += g;
//
//            }
//           System.out.println("inside thermostat fetch data");
//
//            in.close();
//           
//            String[] numbersArray = result.split(" ");
            ManageDB.curTempUp = numbersArray[0];
            ManageDB.curTempMain = numbersArray[1];
//
//
//
//
        }
        catch (Exception e){
           // Log.d("fetchdata",e.getMessage());

        }
       
    }
	
	public static void fetchlightData() {
        try {
        	String returnedValue = Client.fetchValues(3002);
        	String [] numbersArray = returnedValue.split(" ");
        	//String [] numbersArray = returnedValue.split(" ");
        	System.out.println("first val"+numbersArray[0]);
        	System.out.println("second val"+numbersArray[1]);
//            int temp_curr;
//            String cId = "1";
//            String url = "http://"+ManageDB.ip+"/fetchLightmode.php";
//            URL urlObj = new URL(url);
//            String result = "";
//            String data = "cId=" + java.net.URLEncoder.encode(cId, "UTF-8");
//            //1
//            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//            conn.setDoInput(true);
//            conn.setDoOutput(true);
//            conn.setUseCaches(false);
//            conn.setRequestMethod("POST");
//            //2
//            DataOutputStream dataOut = new DataOutputStream(conn.getOutputStream());
//            dataOut.writeBytes(data);
//            //3
//            dataOut.flush();
//            dataOut.close();
//            DataInputStream in = new DataInputStream(conn.getInputStream());
//
//            String g;
//            while ((g = in.readLine()) != null) {
//
//                result += g;
//
//            }
//            
//
//            in.close();
        
      //      String[] numbersArray = result.split(" ");
            ManageDB.lightModeUpStair      = numbersArray[0];
           ManageDB.lightModeMainFloor        = numbersArray[1];


        } catch (Exception e) {

        }

     

    }
	
}
