package PatientModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewSeleniumVersion{

	public static void main(String[] args) {
		 RemoteWebDriver driver =new ChromeDriver();
		 NewSeleniumVersion2 d = (NewSeleniumVersion2)driver;
		 System.out.println(d.getTitle());

	}



}
