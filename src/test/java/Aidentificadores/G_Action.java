package Aidentificadores;
/*
 *   vamos a trabajar sobre el objeto Actions
 * 
 * 1� para crear una instancia de Actions necesitamos el WebDriver pasado por par�metro
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
		
		 //1�
		Actions accion =new Actions(driver);	
	}
}
