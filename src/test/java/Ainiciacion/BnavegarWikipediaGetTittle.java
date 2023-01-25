package Ainiciacion;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/*
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
*/
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class BnavegarWikipediaGetTittle {
	private WebDriver driver;
	
	@Before
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		//tamaño de la pantalla personalizado
		   //driver.manage().window().setSize(new Dimension(800,600));
		//posicionar el browser en la pantalla
		   // driver.manage().window().setPosition(new Point(400,300));
		driver.get("https://www.wikipedia.es");
		   //driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void testNavegador() {
		
	String titulo=driver.getTitle();//Wikipedia, la enciclopedia libre
	System.out.println(titulo);
	
	//retroceder una pagina en el navegador
		driver.navigate().back();
	
	//avanzar una una pagina en el navegador
		driver.navigate().forward();
		
	//refrescar la pagina
		driver.navigate().refresh();
	}
	
	@After
	public void finalizar(){
		//driver.quit();
	}

}
