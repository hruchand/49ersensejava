import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {

	public static void insertThermostatData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
             
                 

                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.tempModeUp.get(0)+" "+ManageDB.tempModeMain.get(0)+" "+ManageDB.tempEnergyUp.get(0)
                    +" "+ManageDB.tempEnergyMain.get(0)+" "+ManageDB.currentTempUp.get(0)+" "+ManageDB.currentTempMain.get(0)+" "+Integer.toString(ManageDB.controlTempMainFloor)
                    +" "+Integer.toString(ManageDB.controlTempUpstair);
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
         
                	socket.close();
                	 listener.close();
          
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
        
    }
	
	public static void insertLightData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   ManageDB.lightModeUpStair = "on";
//                   ManageDB.lightModeMainFloor = "on";
//                   ManageDB.energy_consumed_US = 45;
//                   ManageDB.energy_consumed_MF = 56;
//                   ManageDB.brightnessUpStair = 45;
//                   ManageDB.brightnessMainFloor = 65;
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.lightModeUpStair+" "+ManageDB.lightModeMainFloor+" "+Integer.toString(ManageDB.energy_consumed_US)
                    +" "+Integer.toString(ManageDB.energy_consumed_MF)+" "+Integer.toString( ManageDB.brightnessUpStair)+" "+Integer.toString(ManageDB.brightnessMainFloor);
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
       
    }
	
	public static void insertSecData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   ManageDB.security_system = "armed";
//                  
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.security_system;
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
       
    }
	
	public static void insertLockData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   ManageDB.f_door_status = "unlocked";
//                   ManageDB.b_door_status = "unlocked";
//                   ManageDB.g_door_status = "locked";
                  
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.f_door_status+" "+ManageDB.b_door_status+" "+ ManageDB.g_door_status;
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
       
    }
	
	public static void insertDoorData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   ManageDB.door_window_sensor_up = "on";
//                   ManageDB.door_window_sensor_main = "off";
               
                  
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.door_window_sensor_up+" "+ManageDB.door_window_sensor_main;
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
       
    }
	public static void insertMotionSensorData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   ManageDB.motion_sensor_up = "on";
//                   ManageDB.motion_sensor_main = "off";
//               
                  
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+ManageDB.motion_sensor_up+" "+ManageDB.motion_sensor_main;
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           
       
    }
	public static void insertWeatherData(int port) throws Exception {
        try{
        	 Thread.sleep(5000);
        }
        catch (Exception e) {
//			// TODO: handle exception
		}
		ServerSocket listener = new ServerSocket(port);
		listener.setReuseAddress(true);
		
        try {
         
        	while (true) {
                Socket socket = listener.accept();
                try {
                 
//                   ManageDB.cId = "16"; 
//                   ManageDB.currentDate.add("1924/12/12");
//                   Weather.setWeather_temp(56);
//                   Weather.setWeather_condition("cool");
//                  
               
                  
                 
                    String value = ManageDB.cId +" "+ ManageDB.currentDate.get(0)+" "+Integer.toString(Weather.getWeather_temp())+" "+Weather.getWeather_condition();
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println(value);
                    Thread.sleep(1000);
                    out.flush();
                    out.close();
                   
                } finally {
                  //  out.c
                	socket.close();
                	listener.close();
                }
            }
        }
       catch (Exception e) {
		System.out.println(e.getMessage());
	} 
           

		Server.insertThermostatData(4001);
		Server.insertLightData(4002);
		Server.insertSecData(4003);
		Server.insertLockData(4004);
		Server.insertDoorData(4005);
		Server.insertMotionSensorData(4006);
		Server.insertWeatherData(4007);
    }
}

