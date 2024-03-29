package PatientModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtils.BaseClass;

import objectRepository.AddMedicalHistoryPage;
import objectRepository.AdminDashboardPage;
import objectRepository.Admin_AddDoctorPage;
import objectRepository.DoctorAddPatientPage;
import objectRepository.DoctorDashboardPage;
import objectRepository.DoctorSearchPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;
@Listeners(genericUtils.ListenerImpClass.class)
public class Testng2ScriptsTest extends BaseClass {
	@Test //(retryAnalyzer = genericUtils.RetryImpClass.class)
	public void TestngDoctorBookAppointmentTest() throws Throwable
	{
		fLib.readDataFromPropertyFile("adm_username");
		fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		fLib.readDataFromPropertyFile("pat_username");
		fLib.readDataFromPropertyFile("pat_password");

		eLib.readDataFromExcelFile("Doctor", 0, 3);
		eLib.readDataFromExcelFile("Doctor", 1, 3);
		eLib.readDataFromExcelFile("Doctor", 2, 3);
		
		driver.findElement(By.xpath("//span[.=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[.=' Add Doctor']")).click();
		WebElement specialization_dd = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
		String specialization = eLib.readDataFromExcelFile("Doctor", 0, 1);
		wLib.select(specialization, specialization_dd);
		
		Assert.fail();

		String doc_name = eLib.readDataFromExcelFile("Doctor", 1, 1);
	String doc_address = eLib.readDataFromExcelFile("Doctor", 2, 1);
	String doc_fees = eLib.readDataFromExcelFile("Doctor", 3, 1);
	String doc_number = eLib.readDataFromExcelFile("Doctor", 4, 1);
	String email = eLib.readDataFromExcelFile("Doctor", 5, 1);
	String doc_email = email+jLib.getRandomNo()+"@gmail.com";
	String doc_new_password = eLib.readDataFromExcelFile("Doctor", 6, 1);
	String doc_con_password = eLib.readDataFromExcelFile("Doctor", 7, 1);
	Admin_AddDoctorPage aadp = new Admin_AddDoctorPage(driver);
	aadp.doctorRegis(specialization, doc_name, doc_address, doc_fees, doc_number, doc_email, doc_new_password, doc_con_password);
	wLib.acceptAlert(driver);
	LoginPage lp = new LoginPage(driver);
	lp.logoutFromApp();
	
	HomePage hp = new HomePage(driver);
	hp.clickOnLink("doctor");
	lp.loginToApp(D_USERNAME, D_PASSWORD);
	
	String pat_name = eLib.readDataFromExcelFile("Patient", 0, 1);

	DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
	ddp.getSearchLink().click();
	
	DoctorSearchPage dsp = new DoctorSearchPage(driver);
	dsp.searchPatient(pat_name);
	driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Abc')]/td[7]/a[@href='view-patient.php?viewid=345']")).click();

	dsp.clickOnAddMedHistory();
	
	String blood_pressure = eLib.readDataFromExcelFile("Patient", 9, 1);
	String blood_sugar = eLib.readDataFromExcelFile("Patient", 10, 1);
	String weight = eLib.readDataFromExcelFile("Patient", 11, 1);
	String body_temperature = eLib.readDataFromExcelFile("Patient", 12, 1);
	String prescription = eLib.readDataFromExcelFile("Patient", 13, 1);

	AddMedicalHistoryPage amhp = new AddMedicalHistoryPage(driver);
	amhp.addMedicalHistory(blood_pressure, blood_sugar, weight, body_temperature, prescription);
	
//	lp.logoutFromApp();
//	
//	hp.clickOnLink("patient");
//
//	lp.loginToApp(P_USERNAME, P_PASSWORD);
//	
//	driver.findElement(By.xpath("//span[.=' Book Appointment ']")).click();
//	WebElement sel_specialization_dd = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
//	wLib.select(specialization, sel_specialization_dd);
//	WebElement sel_doctor_dd = driver.findElement(By.xpath("//select[@id='doctor']"));
//	wLib.select(sel_doctor_dd, "315");
//	driver.findElement(By.xpath("//input[@name='appdate']")).click();
//	driver.findElement(By.xpath("//table[@class=' table-condensed']/tbody/tr[4]/td[4]")).click();
//	driver.findElement(By.xpath("//input[@name='apptime']")).click();
//	for(int i=0;i<5;i++)
//	{
//		driver.findElement(By.xpath("//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[1]")).click();
//	}
//	driver.findElement(By.xpath("//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[2]")).click();
//	driver.findElement(By.xpath("//div[@class='bootstrap-timepicker-widget dropdown-menu timepicker-orient-left timepicker-orient-bottom open']/table/tbody/tr[3]/td[3]")).click();
//	driver.findElement(By.name("submit")).click();
//	wLib.acceptAlert(driver);
	
	System.out.println("testcase is pass: end to end executed successsfully");
	System.out.println("--------testcase 4 end to end executed-----------");
	}
	
	@Test 
	public void TestngPatientAddTest() throws Throwable
	{
		String A_USERNAME = fLib.readDataFromPropertyFile("adm_username");
		String A_PASSWORD = fLib.readDataFromPropertyFile("adm_password");
		String D_USERNAME = fLib.readDataFromPropertyFile("doc_username");
		String D_PASSWORD = fLib.readDataFromPropertyFile("doc_password");
		fLib.readDataFromPropertyFile("pat_username");
		fLib.readDataFromPropertyFile("pat_password");
		HomePage hp = new HomePage(driver);
		
		LoginPage lp = new LoginPage(driver);
		lp.logoutFromApp();
		hp.clickOnLink("doctor");
		lp.loginToApp(D_USERNAME, D_PASSWORD);
		
		String pat_name = eLib.readDataFromExcelFile("Patient", 0, 1);
		String pat_number = eLib.readDataFromExcelFile("Patient", 1, 1);
		String email = eLib.readDataFromExcelFile("Patient", 2, 1);
		String pat_email = email+jLib.getRandomNo()+"@gmail.com";
		String pat_gender = eLib.readDataFromExcelFile("Patient", 3, 1);
		String pat_address = eLib.readDataFromExcelFile("Patient", 4, 1);
		String pat_age = eLib.readDataFromExcelFile("Patient", 5, 1);
		String pat_med_history = eLib.readDataFromExcelFile("Patient", 6, 1);

		DoctorDashboardPage ddp = new DoctorDashboardPage(driver);
		ddp.clickOnAddPatientLink();
		DoctorAddPatientPage dapp = new DoctorAddPatientPage(driver);
		dapp.addPatient(pat_name, pat_number, pat_email, pat_gender, pat_address, pat_age, pat_med_history);
		
		lp.logoutFromApp();
		
		
		hp.clickOnLink("admin");
		
		lp.loginToApp(A_USERNAME, A_PASSWORD);		
		
		AdminDashboardPage adp = new AdminDashboardPage(driver);
		adp.managePatients();
		String patient_name = driver.findElement(By.xpath("//table[@id='sample-table-1']/tbody/tr[contains(.,'Abc')]/td[2]")).getText();
		if(pat_name.equalsIgnoreCase(patient_name))
		{
			System.out.println("patient details are displayed ");
		}
		
		System.out.println("--------testcase 5 end to end executed-----------");
	}

}
