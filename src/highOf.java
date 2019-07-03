import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class highOf {	
	
	public static void highOf() {
	}
	
	public void creater() {
		try {
			URL url = new URL("https://forecast.weather.gov/product.php?site=CRH&product=SFT&issuedby=RAH");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String str;
			while ((str = in.readLine()) != null) {
				str = str.toString();
				str.trim();
				
				if (str.contains("RALEIGH-DURHAM")) {
					str = in.readLine();
					str = in.readLine();
					str = str.trim();
					String temps = str.substring(1,3);
					temps = ("Todays high is: " + temps + " degrees.");
					System.out.println(temps);
				}
			}
			
			in.close();

			
		} catch (MalformedURLException e1) {
		} catch (IOException e2) {}
	}
}
