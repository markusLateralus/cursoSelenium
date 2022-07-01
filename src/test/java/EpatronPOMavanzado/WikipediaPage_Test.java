package EpatronPOMavanzado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

class WikipediaPage_Test {

	WebDriver driver;
	WikipediaPage wikipediaPage;
	@BeforeEach
	void setUp() throws Exception {
		wikipediaPage=new WikipediaPage(driver);
		driver=wikipediaPage.chromeDriverConnection();
		driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() {
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//verificamos que estamos dentro de wikipedia
		wikipediaPage.verificarTotalInputs(6);
		wikipediaPage.verifcarTituloDeArticuloBueno("Brian y Stewie");
		
	}

}
