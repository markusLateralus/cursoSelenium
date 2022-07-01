package Herramientas;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

/*
 * se encarga de dar las configuraciones de tamaño y posicion del navegador
 * 
 * */
public class BrowserManager {

	public static void setWindow(WebDriver driver, String valor) {
		if(valor.toLowerCase()=="maximized") {
			driver.manage().window().maximize();
		}
		if(valor.toLowerCase()=="fullscreen") {
			driver.manage().window().fullscreen();
		}
	}
	
	public static void setWindow(WebDriver driver, int ancho, int alto) {
		driver.manage().window().setSize(new Dimension(ancho, alto));
	}
}
