package EpatronPOMavanzado;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


class GoogleBuscadorPage_Test {

	WebDriver driver;
	GoogleBuscadorPage googleBuscadorPage;
	@BeforeEach
	void setUp() throws Exception {
		googleBuscadorPage =new GoogleBuscadorPage(driver);
		driver=googleBuscadorPage.chromeDriverConnection();
		driver.get("https://www.google.com/search?q=wikipedia&rlz=1C1GCEU_esES950ES950&oq=wiki&aqs=chrome.0.69i59j69i57j69i60j69i65l3j69i60l2.1011j0j4&sourceid=chrome&ie=UTF-8");
	}



	@Test
	void test() {
		googleBuscadorPage.aceptarCookies();
		googleBuscadorPage.clickFirstElement();
		
	}
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}
}
