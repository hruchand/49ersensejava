
public class SimulationThreadThermostat implements Runnable {
	
Thread thread = new Thread(this);
	public SimulationThreadThermostat(){	
		thread.start();
	}
	public void run(){
		try{
		
		while (true) {
			if(Thermostat.getMode().equalsIgnoreCase("off") || Thermostat.getCurrentTemperature() == Thermostat.getControlTemperature()){
				break;
			}
			System.out.println("inside thermostata simulation main");
            switch (Thermostat.getMode()) {
                case "heat":
                    Thread.sleep(1000);
                                 
                    if (Thermostat.getCurrentTemperature() < Thermostat.getControlTemperature() && Thermostat.getCurrentTemperature() < 80) {

                        Thread.sleep(1000);
                        Thermostat.setCurrentTemperature(Thermostat.getCurrentTemperature()+1);
                        System.out.println("\nCurrent Temperature of Main Floor:"+Thermostat.getCurrentTemperature());
                        SetData.setMainfloorTemp();
                        System.out.println("\nCurrent energy consumption of Main Floor:"+Thermostat.EnergyConsumption(Thermostat.getCurrentTemperature()));
                    }
                    break;

                case "cool":                  
                    if(Thermostat.getCurrentTemperature() > Thermostat.getControlTemperature() && Thermostat.getCurrentTemperature() > 45) {
                        Thread.sleep(1000);
                        Thermostat.setCurrentTemperature(Thermostat.getCurrentTemperature()-1);
                        System.out.println("\nCurrent Temperature of Main Floor:"+Thermostat.getCurrentTemperature());
                        SetData.setMainfloorTemp();
                        System.out.println("\nCurrent energy consumption of Main Floor:"+Thermostat.EnergyConsumption(Thermostat.getCurrentTemperature()));
                    }
                break;
                
                case "off":
                	break;
                default:
                    break;

            }
        	//System.out.println("\nCurrent Temperature reached control temp:"+Thermostat.getCurrentTemperature());
        	//System.out.println("\nCurrent energy consumption of Main Floor:"+Thermostat.EnergyConsumption(Thermostat.getCurrentTemperature()));
	}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
}
}
