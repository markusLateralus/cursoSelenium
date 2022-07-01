package EpatronPOM;




import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import EpatronPOM.pageObjects.*;


/*   PRIMER proyecto con POM
 * 
 * 1º nos creamos un paquete y dentro creamos las clases, cada clase pertenece a una página.El "resultado de búsqueda" es una página aparte
 * 2º 
 * 
 * */
public class BtestPrincipal {


	private WebDriver driver;
	private String google;
	private String wikipedia;

	
	//utilizar esta etiqueta!!
	@BeforeEach
	public void configurar(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		this.google="https://google.es";
	
		driver.get(this.google);
	
	
		
	}

	

	@Test
	public void test() throws InterruptedException{
		//empezamos con crear una página de google
		GooglePage googlePage=new GooglePage(this.driver);
		//aceptamos las cookies
		googlePage.aceptarCookies();
		//utilizamos el método buscar para la palabra wikipe
		googlePage.buscar("wikipedia");
		//IMPORTANTE verificamos que ha buscado wikipedia
		assertEquals("wikipedia - Buscar con Google", googlePage.getTitle());
		//creamos GoogleBuscadorPage
		GoogleBuscadorPage googleBuscadorPage =new GoogleBuscadorPage(this.driver);
		googleBuscadorPage.clickFirstElement();
		//verificamos que estamos dentro de wikipedia
		WikipediaPage wikipediaPage=new WikipediaPage(this.driver);
		assertEquals("Brian y Stewie", wikipediaPage.getTituloArticuloBueno());

		
	}
	
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
