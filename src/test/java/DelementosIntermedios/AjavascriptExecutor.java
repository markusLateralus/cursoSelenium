package DelementosIntermedios;



import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*  clase JavascriptExecutor    "ejecutar snippets"
 * 
 * - Se utiliza para crear código javaScript y ejecutarlo con selenium.
 * 
 * - pasos:
 * 1º creamos el objeto JavascriptExecutor
 * 2º utilizamos el método .executeScript() para ejecutarlo
 * 
 * 3º crear una lista de tabs para 
 * 
 * 
 * 
 * */
public class AjavascriptExecutor {

	
	private WebDriver driver;
	private String wikipedia;
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.w3schools.com/html/html_iframe.asp";
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(4000);
		List<WebElement>enlaces=driver.findElements(By.cssSelector("[target=\"_top\"]"));
		System.out.println(enlaces.size()); //121
		WebElement ultimoEnlace=driver.findElement(By.linkText("Keyboard Shortcuts"));
		//crear el objeto
			JavascriptExecutor js=(JavascriptExecutor) driver;
	//le estamos diciendo que mueva el SCROLL hacia el último enlace que hay 
			js.executeScript("window.scrollBy(0, arguments[0])", ultimoEnlace.getLocation().getY());
			Thread.sleep(4000);
			
	//abrir una nueva pestaña
			js.executeScript("window.open('https://www.google.com')");
			Thread.sleep(4000);
		
	}
	
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
