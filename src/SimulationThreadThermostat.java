
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
			System.out.println("thermostat mode:-"+Thermostat.getMode());
            switch (Thermostat.getMode()) {
                case "heat":
                    Thread.sleep(1000);
                    System.out.println("thermostatinside switch :-"+Thermostat.getMode());
                    System.out.println("con temp in sim:-"+Thermostat.getControlTemperature());
                    System.out.println("current temp in sim:-"+Thermostat.getCurrentTemperature());
                    if (Thermostat.getCurrentTemperature() < Thermostat.getControlTemperature() && Thermostat.getCurrentTemperature() < 80) {
System.out.println("inside if of main thermostat");
                        Thread.sleep(1000);
                        Thermostat.setCurrentTemperature(Thermostat.getCurrentTemperature()+1);
                        System.out.println("\nCurrent Temperature of Main Floor:"+Thermostat.getCurrentTemperature());
                       SetData.setMainfloorTemp(5001);
                  //      SetData.setMainfloorTemp(5001);
                        System.out.println("\nCurrent energy consumption of Main Floor:"+Thermostat.EnergyConsumption(Thermostat.getCurrentTemperature()));
                    }
                    break;

                case "cool":                  
                    if(Thermostat.getCurrentTemperature() > Thermostat.getControlTemperature() && Thermostat.getCurrentTemperature() > 45) {
                        Thread.sleep(1000);
                        Thermostat.setCurrentTemperature(Thermostat.getCurrentTemperature()-1);
                        System.out.println("\nCurrent Temperature of Main Floor:"+Thermostat.getCurrentTemperature());
                        SetData.setMainfloorTemp(5001);
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
