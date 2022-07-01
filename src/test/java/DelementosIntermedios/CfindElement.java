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


/*   Cómo usar correctamente findElement()
 * 
 * - Para que nuestro código sea más estable, alamacenaremos en variables de tipo By  el objeto By. fuera de los métodos de test
 * 
 * */
public class CfindElement {

	
	private WebDriver driver;
	private String wikipedia;
	//primer paso declarar el objeto By 
	private By linkPaginaAleatoria;
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.wikipedia.es";
		//segundo paso, inicializamos By con el selecctor deseado, en este caso co linkText();
		linkPaginaAleatoria= By.linkText("Página aleatoria");
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(4000);
		 //tercer paso, utilizamos el objeto By dentro del método findElement()
	driver.findElement( linkPaginaAleatoria).click();
	String titulo=driver.getTitle();
	System.out.println(titulo);  //ok
		
	}
	
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
