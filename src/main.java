import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class main {	
	
	public static void main() {
	}
	
	public void creater() {
		try {
			URL url = new URL("https://www.weather.gov/rah/");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				str = str.toString();
				str.trim();
				
				if (str.contains("value=") && (str.length() < 25)) {
					int spot = str.indexOf("=");
					String temps = str.substring(spot);
					temps = temps.substring(temps.indexOf(",")+2, spot+7);
					temps = ("The current temperature is: " + temps + " degrees.");
					System.out.println(temps);
				}
			}
			
			in.close();
			
		} catch (MalformedURLException e1) {
		} catch (IOException e2) {}
	}
}
