package DelementosIntermedios;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Aassert {

	
	private WebDriver driver;
	private String wikipedia;
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.wikipedia.es";
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(this.wikipedia);
		WebElement buscador=driver.findElement(By.id("searchInput"));
		WebElement botonBuscar=driver.findElement(By.id("searchButton"));
		
		buscador.sendKeys("selenium");
		botonBuscar.click();
		WebElement cabecera=driver.findElement(By.id("firstHeading"));
		String titulo=cabecera.getText();
		String tituloDeseado="Selenium";
		
		assertEquals(tituloDeseado, titulo);
		
	}
	
	
	//vamos a wikipedia, pulsamos enlace pagina aleatoria y regresamos a la página anterior, y ASSERCIONES 
	@Test
	public void test2() throws InterruptedException {
		driver.get(this.wikipedia);
		WebElement linkRandomPage=driver.findElement(By.linkText("Página aleatoria"));
		linkRandomPage.click();
		driver.navigate().back();

		String titulo=driver.getTitle();
		String tituloDeseado="Wikipedia...bla bla bla";
		
		assertEquals(tituloDeseado, titulo);
		
	}
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
