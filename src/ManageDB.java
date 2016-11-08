import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;

import java.sql.DriverAction;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import com.sun.jna.platform.win32.SetupApi;

public class ManageDB {
	static String ip="10.0.0.2";
static	String url222 = "http://"+ip+"/iot.php";
	
	static	String cId ="1";
	static	ArrayList<String> currentTempUp= new ArrayList<>();
	static	ArrayList<String> currentTempMain = new ArrayList<>();
	//	String customerId = "1";
	static	ArrayList<String> currentDate = new ArrayList<>();
	static	ArrayList<String> tempModeUp = new ArrayList<>();
	static	ArrayList<String> tempModeMain = new ArrayList<>();
	static	ArrayList<String> tempEnergyUp = new ArrayList<>();
	static	ArrayList<String> tempEnergyMain = new ArrayList<>();
	static int controlTempUpstair;
	static int controlTempMainFloor;
	static String lightModeMainFloor;
	static String lightModeUpStair;
	static int energy_consumed_MF;
	static int energy_consumed_US;
	static int brightnessMainFloor;
	static String security_system = "null";
	static String f_door_status = "UNLOCKED";
	static String b_door_status = "UNLOCKED";
	static String g_door_status = "UNLOCKED";
	static String door_window_sensor_main = "OFF";
	static String door_window_sensor_up = "OFF";
	static String motion_sensor_up = "INACTIVE";
	static String motion_sensor_main = "INACTIVE";
	static String curTempUp;
	static String curTempMain;
	
	static int brightnessUpStair;
	public static void main(String[] args) {
//System.out.println("url is- "+url222);
		String thermoStatModeMainFloor;
		String fanModeMainFloor;

		String thermoStatModeUpstair;
		String fanModeUpstair;
		String curDate ="12-2-2014";
		String tmodeU ="23";
		String tmodeM ="34";
		String tEnergyU ="45";
		String tEnergyM ="56";
		
		//static String currUpTemp;
	//	static 
		FetchData.fetchCurTemp();
		System.out.println("upstair temp:-"+ManageDB.curTempUp+"\n");
		System.out.println("main temp:-"+ManageDB.curTempMain+"\n");

		System.out.println("Set  Control Temp for MainFloor \n");	
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				controlTempMainFloor = scanner.nextInt();
				break;
			}
		}

		System.out.println("Set Thermostat Mode for mainFloor");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				thermoStatModeMainFloor = scanner.nextLine();
				break;
			}
		}

		System.out.println("Set Fan Mode for Mainfloor");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				fanModeMainFloor = scanner.nextLine();
				break;
			}
		}
		System.out.println("Set  Control Temp for upstair \n");	
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				controlTempUpstair = scanner.nextInt();
				break;
			}
		}

		System.out.println("Set Thermostat Mode for upStair");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				thermoStatModeUpstair = scanner.nextLine();
				break;
			}
		}

		System.out.println("Set Fan Mode for upStair");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				fanModeUpstair = scanner.nextLine();
				break;
			}
		}

		System.out.println("Set Light Mode for Main Floor(on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				lightModeMainFloor = scanner.nextLine();
				break;
			}
		}

		System.out.println("Set Brightness for Main Floor(Integer Value)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				brightnessMainFloor = scanner.nextInt();
				break;
			}
		}

		System.out.println("Set Light Mode for Up Stair(on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				lightModeUpStair = scanner.nextLine();
				break;
			}
		}

		System.out.println("Set Brightness for Up Stair(Integer Value)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				brightnessUpStair = scanner.nextInt();
				break;
			}
		}

		System.out.println("Set Security System status(Disarmed/Armed Stay/Armed Away)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				security_system = scanner.nextLine();
				break;
			}
		}

		System.out.println("Lock the front door ?, Enter 'Lock' or 'unlock'");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				f_door_status = scanner.nextLine();
				break;
			}
		}

		System.out.println("Lock the back door ?, Enter 'Lock' or 'unlock'");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				b_door_status = scanner.nextLine();
				break;
			}
		}

		System.out.println("Lock the garage door ?, Enter 'Lock' or 'unlock'");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				g_door_status = scanner.nextLine();
				break;
			}
		}
		
		System.out.println("Enter the Door window sensor status for main: (on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				door_window_sensor_main = scanner.nextLine();
				break;
			}
		}
		
		System.out.println("Enter the Door window sensor status for upstair: (on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				door_window_sensor_up = scanner.nextLine();
				break;
			}
		}
		
		System.out.println("Enter the Door window sensor status for main: (on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				door_window_sensor_main = scanner.nextLine();
				break;
			}
		}
		
		System.out.println("Enter the Door window sensor status for upstair: (on/off)");
		while(true)
		{
			Scanner scanner = new Scanner(System.in);
			if(scanner.hasNext())
			{
				door_window_sensor_up = scanner.nextLine();
				break;
			}
		}
		
			
		MotionDetectorUp mu = new MotionDetectorUp();
		MotionDetectorMain mm = new MotionDetectorMain();
		mu.setMotion_detector_status(motion_sensor_up);
		mm.setMotion_detector_status(motion_sensor_main);
		
		
		Door_Window_SensorsMain dwm = new Door_Window_SensorsMain();
		dwm.setSensor_status(door_window_sensor_main);
		
		
		Door_Window_SensorsUp dwu = new Door_Window_SensorsUp();
		dwu.setSensor_status(door_window_sensor_up);

		SecuritySystem ss = new SecuritySystem();
		ss.setSecurity_status(security_system);
		System.out.println("\nSecurity Status:" + ss.SecurityStatus());

		Locks l = new Locks();
		l.setBack_door_status(b_door_status);
		l.setFront_door_status(f_door_status);
		l.setGarage_door_status(g_door_status);
		System.out.println("Front door is:" + l.FrontDoorStatus());
		System.out.println("Back door is:" + l.BackDoorStatus());
		System.out.println("Garage door is:" + l.GarageDoorStatus());

		LightMainFloor lightMainFloor = new LightMainFloor(lightModeMainFloor,brightnessMainFloor);
		if(lightModeMainFloor.equalsIgnoreCase("on")){

			energy_consumed_MF = lightMainFloor.EnergyConsumption();
			System.out.println("\nLight Status on Main Floor:" + lightMainFloor.getLightStatus());
			System.out.println("\nMain Floor energy consumption of light:" + energy_consumed_MF);
		}else{
			System.out.println("\nLight Status on Main Floor:" + lightMainFloor.getLightStatus());
			System.out.println("\nMain Floor energy consumption of light: 0");
		}

		LightUpstair lightUpStair = new LightUpstair(lightModeUpStair,brightnessUpStair);
		if(lightModeUpStair.equalsIgnoreCase("on")){
			energy_consumed_US = lightUpStair.EnergyConsumption();
			System.out.println("\nLight Status on Up Stair:" + lightUpStair.getLightStatus());
			System.out.println("\nUp Stair energy consumption of light:" + energy_consumed_US);
		}else{
			System.out.println("\nLight Status on Up Stair:" + lightMainFloor.getLightStatus());
			System.out.println("\nUp Stair energy consumption of light: 0");
		}

		Thermostat thermostat = new Thermostat(controlTempMainFloor, thermoStatModeMainFloor);
		SimulationThreadThermostat simulationThreadThermostat = new SimulationThreadThermostat();
		String fanStatusMainfloor = thermostat.fan(fanModeMainFloor);

		ThermostatUpstair thermostatUpstair = new ThermostatUpstair(controlTempUpstair, thermoStatModeUpstair);
		SimulationThreadThermostatUpstair simulationThreadThermostatUpstair = new SimulationThreadThermostatUpstair();
		String fanStatusUpstair = thermostatUpstair.fan(fanModeUpstair);
		System.out.println(fanStatusMainfloor);
		System.out.println(fanStatusUpstair);

		//	Date dt = new Date();

		Calendar c = Calendar.getInstance();
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		//c.setTime(dt);
		try{
			Thread.sleep(10000);

			for(int i = 0; i <5; i++){
				Thread.sleep(10000);
				c.add(Calendar.DATE, 1);
				String formatted = format1.format(c.getTime());
				currentDate.add(formatted);
				System.out.println("current date "+currentDate.get(i));	
				tempModeUp.add(ThermostatUpstair.getMode());
				tempModeMain.add(Thermostat.getMode());

				tempEnergyUp.add(Integer.toString(ThermostatUpstair.getEnergyConsumed())) ;
				//	 String val1 = Double.toString(ThermostatUpstair.getEnergyConsumed());
				tempEnergyMain.add(Integer.toString(Thermostat.getEnergyConsumed())) ;
				System.out.println("energy consumed"+Thermostat.getEnergyConsumed());
				currentTempUp.add(Integer.toString(ThermostatUpstair.getCurrentTemperature()));
				currentTempMain.add(Integer.toString(Thermostat.getCurrentTemperature()));

			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}	

		System.out.println("above setupdata");
		createTable();
		InsertData.insertThermostatData();	
		InsertData.insertLightData();	
		InsertData.insertSecurity();
		InsertData.insertLocks();
		InsertData.insertDoorSensor();
		InsertData.insertMotionSensor();
		InsertData.insertWeather();
		//test();
	}




	public static void createTable(){
		try
		{
			String url = "http://"+ip+"/iot.php";
			URL urlObj = new URL(url);
			String result = "";



			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");

			//DataOutputStream  dataOut = new DataOutputStream(conn.getOutputStream());

			//dataOut.flush();
			//dataOut.close();
			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
			System.out.println(result);



		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public static void test(){
		try{
			System.out.println("inside test");
			//	thread.sleep(5000);

			System.out.println("BEFORE CONNECTION");
			String url = "http://192.168.1.107/fetchEner.php";
			URL urlObj = new URL(url);
			String result = "";



			HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setUseCaches(false);
			conn.setRequestMethod("POST");




			DataInputStream in = new DataInputStream(conn.getInputStream());
			String g;
			while((g = in.readLine()) != null){
				result += g;
			}
			in.close();
			System.out.println(result);



		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
