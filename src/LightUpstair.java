
public class LightUpstair extends RPI1 {
	
		private static String lightStatus;
		private static int brightness;
		private static int energyConsumed = 0;
		private static int energy_rate = 2;

		public static String getLightStatus() {
			return lightStatus;
		}


	    public static int getBrightness() {
			return brightness;
		}


	
		public LightUpstair(String lightStatus, int brightness ){
			this.lightStatus = lightStatus;
			this.brightness = brightness;
		}


		public int EnergyConsumption(){
			energyConsumed = brightness * energy_rate;
		 return energyConsumed;	 
		}
}
