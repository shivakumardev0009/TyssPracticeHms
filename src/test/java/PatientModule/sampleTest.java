package PatientModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class sampleTest {
	@Test(groups = "smoke")
	public void testScript1_Test() {
		System.out.println("testscript");
	}

	@Test
	public void testScript2_Test() {
		System.out.println("testscript2--");
	}

}
