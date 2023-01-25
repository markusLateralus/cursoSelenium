package Aidentificadores;
/*
 *   vamos a trabajar sobre el objeto Actions
 * 
 * 1º para crear una instancia de Actions necesitamos el WebDriver pasado por parámetro
 * 
 * 
 * 
 * */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class G_Action {


	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.wikipedia.es");
		
		 //1º
		Actions accion =new Actions(driver);	
	}
}
