package PatientModule;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Creations {
	WebDriver driver;
	Select se;
	String expOldName;
	int ranNum;
	Actions act;

	@BeforeMethod
	public void login() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		act = new Actions(driver);
	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@Test()
	public void test1() {

		Random r = new Random();
		ranNum = r.nextInt(1000);
		expOldName = "shankar" + ranNum;

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.cssSelector("[title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(expOldName);
		WebElement industry = driver.findElement(By.name("industry"));
		Select se = new Select(industry);
		se.selectByValue("Education");
		WebElement type = driver.findElement(By.name("accounttype"));
		Select se1 = new Select(type);
		se1.selectByVisibleText("Press");
		driver.findElement(By.name("button")).click();

		String orgId = "";
		try {
			orgId = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		System.out.println(orgId + "   orgId");
		System.out.println(expOldName + "  expoldName");
		if (orgId.contains(expOldName)) {
			System.out.println("organiztion created");
		} else {
			System.out.println("organiztion not created");
		}
		WebElement mo = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		act.moveToElement(mo).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

	@Test(dependsOnMethods = "test1")
	public void task2() throws InterruptedException {
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		driver.findElement(By.cssSelector("[alt='Create Contact...']")).click();
		WebElement a = driver.findElement(By.name("salutationtype"));
		se = new Select(a);
		se.selectByValue("Mr.");
		driver.findElement(By.name("firstname")).sendKeys(expOldName);
		driver.findElement(By.name("lastname")).sendKeys("REwr");
		driver.findElement(By.xpath("(//img[@src=\"themes/softed/images/select.gif\"])[1]")).click();
		String parentId = driver.getWindowHandle();
		Set<String> allId = driver.getWindowHandles();
		for (String str : allId) {
			driver.switchTo().window(str);
		}
		driver.findElement(By.name("search_text")).sendKeys(expOldName);
		driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='" + expOldName + "']")).click();
		driver.switchTo().window(parentId);
		driver.findElement(By.name("button")).click();
		String orgId = "";
		try {
			orgId = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		} catch (Exception e) {
			System.out.println("exception handled");
		}

		if (orgId.contains(expOldName)) {
			System.out.println("contact created");
		} else {
			System.out.println("contact not created");
		}
		WebElement mo = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		WebElement cl = driver.findElement(By.xpath("//a[.='Sign Out']"));
		act.moveToElement(mo).click(cl);
	}

	@Test(dependsOnMethods = "task2")
	public void task3() {
		WebElement more = driver.findElement(By.xpath("//a[.='More']"));
		WebElement cam = driver
				.findElement(By.xpath("//a[.=' Marketing']/ancestor::tbody/descendant::a[.='Campaigns']"));
		act.moveToElement(more).click(cam).perform();
		driver.findElement(By.cssSelector("[title='Create Campaign...']")).click();
		Random r = new Random();
		ranNum = r.nextInt(1000);
		String camp = "shan" + ranNum;
		driver.findElement(By.name("campaignname")).sendKeys(camp);
		WebElement campType = driver.findElement(By.name("campaigntype"));
		se = new Select(campType);
		se.selectByValue("Conference");
		driver.findElement(By.name("button")).click();
		String orgId = "";
		try {
			orgId = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		if (orgId.contains(camp)) {
			System.out.println("compaign created");
		} else {
			System.out.println("campaign not created");
		}
		WebElement mo = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		WebElement cl = driver.findElement(By.xpath("//a[.='Sign Out']"));
		act.moveToElement(mo).click(cl);
	}

	@Test(dependsOnMethods = "task3")
	public void task4() throws InterruptedException {
		Random r = new Random();
		ranNum = r.nextInt(1000);
		String title = "shankar" + ranNum;

		driver.findElement(By.xpath("//a[.='Documents']")).click();
		driver.findElement(By.cssSelector("[title='Create Document...']")).click();
		driver.findElement(By.name("notes_title")).sendKeys(title);
		WebElement frame = driver.findElement(By.xpath("//td[@id='cke_contents_notecontent']/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector("[class='cke_show_borders']")).sendKeys("hiiiii");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		driver.findElement(By.cssSelector("[id='filename_I__']")).sendKeys("C:\\Users\\HP\\Pictures\\Screenshots\\Screenshot (3).png");
		driver.findElement(By.name("button")).click();
		String documentName = "";
		try {
			documentName = driver.findElement(By.cssSelector(".dvHeaderText")).getText();
		} catch (Exception e) {
			System.out.println("exception handled");
		}
		if (documentName.contains(title)) {
			System.out.println("document created");
		} else {
			System.out.println("document not created");
		}
		WebElement mo = driver.findElement(By.cssSelector("[src='themes/softed/images/user.PNG']"));
		WebElement cl = driver.findElement(By.xpath("//a[.='Sign Out']"));
		act.moveToElement(mo).click(cl);
	}
}
