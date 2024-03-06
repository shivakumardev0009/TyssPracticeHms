package PatientModule;

import org.testng.annotations.Test;
public class Sample1Test {
	@Test(groups="regression")
	public void testScript1_Test() throws InterruptedException {
		System.out.println("testsript1---");
		
	}
	@Test(groups ="smoke")
	public void testScript2_Test() {
		System.out.println("testscript2--");
	}
	
}
