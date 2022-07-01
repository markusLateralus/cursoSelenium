package EpatronPOMavanzado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class GooglePage_Test {

	WebDriver driver;
	GooglePage googlePage;
	
	@BeforeEach
	void setUp() throws Exception {
		googlePage=new GooglePage(driver);
		driver=googlePage.chromeDriverConnection();
		driver.get("https://google.es");
	}


	@Test
	void test() {
		//aceptamos las cookies
		googlePage.aceptarCookies();
		//utilizamos el método buscar para la palabra wikipe
		googlePage.buscar("wikipedia");
		//IMPORTANTE verificamos que ha buscado wikipedia
		googlePage.verificarTitulo("wikipedia - Buscar con Google");
		googlePage.hacerScreenshot();
	}
	
	
	@AfterEach
	void tearDown() throws Exception {
		this.driver.quit();
	}

}
