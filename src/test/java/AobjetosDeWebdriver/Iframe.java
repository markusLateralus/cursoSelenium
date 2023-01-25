package AobjetosDeWebdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
/*
 * 
 * con esta clase podemos cambiar de frames en caso de necesitarlos
 * hay tres m√©todos para hacer esta operaci√≥n.
 * Tambi√©n podemos volver iframe principal.
 * 
 * 1∫cambiando de iframe solucionamos el error: NoSuchElementException   ...no such element: Unable to locate element {"method": "xpath", "selector": "//@...." 
 * 2∫ usamos el webelement del nuevo iframe.
 * 3∫ luego debemos volver a ifre principal para continuar
 * */
public class Iframe {

	WebDriver driver;
	public Iframe(WebDriver driver) {
		this.driver=driver;
	}

	//primero obtenemos el total de iframes
	public int getTotalIframe() {
		return this.driver.findElements(By.tagName("iframe")).size();
	}
	
	public WebDriver cambiarIframe(int indice) {
		return this.driver.switchTo().frame(indice);
	}
	public WebDriver cambiarIframe(String id) {
		return this.driver.switchTo().frame(id);
	}
	public WebDriver cambiarIframe(WebElement element) {
		return this.driver.switchTo().frame(element);
	}
	
	public void cambiarIframe(String componente, String xpath) {
		 int size = driver.findElements(By.tagName(componente)).size();

		    for(int i=0; i<=size; i++){
			  driver.switchTo().frame(i);
			  int total=driver.findElements(By.xpath(xpath)).size();
			  System.out.println(total);
			  if(total==1) {
				  break;
			  }else {
		    driver.switchTo().defaultContent();
			  }
		  }
		    }
	    
	
	
	public WebDriver cambiarIframePrinciapl() {
		return this.driver.switchTo().defaultContent(); //o this.driver.switchTo().parentFrame();
	}
}
