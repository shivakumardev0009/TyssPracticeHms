package PatientModule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtils.WebDriverUtils;

public class AmazonAppTest {
	public static void main(String[] args) 
	{
		WebDriverUtils wLib ;
		WebDriver driver= new FirefoxDriver();
		driver.get("https://www.cricbuzz.com/");
		driver.findElement(By.id("live-scores-link")).click();
		driver.findElement(By.xpath("//a[.='Scorecard']")).click();
		//List<WebElement> scores = driver.findElements(By.xpath("//span[.='Rangpur Riders Innings']/parent::div[@class='cb-col cb-col-100 cb-scrd-hdr-rw']/following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-33']/following-sibling::div[@class='cb-col cb-col-8 text-right text-bold']"));
		List<WebElement> runs = driver.findElements(By.xpath("//div[@class='cb-col cb-col-8 text-right text-bold']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr' and contains(.,'Rangpur Riders Innings')]/descendant::div[@class='cb-col cb-col-8 text-right text-bold']"));
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='cb-col cb-col-8 text-right text-bold']/ancestor::div[@class='cb-col cb-col-100 cb-ltst-wgt-hdr' and contains(.,'Rangpur Riders Innings')]/descendant::div[@class='cb-col cb-col-25 ']"));
		int count=0;
		for(WebElement name:names)
		{
			count++;
			System.out.println(name.getText()+"------->"+runs.get(count).getText());
		}
		
		driver.quit();
		}


}
