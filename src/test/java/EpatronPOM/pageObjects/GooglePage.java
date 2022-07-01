package EpatronPOM.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *  			las PageObject:
 *  - su función pricipal son 2:
 *      1º declarar los localizadres que le afecte a su página y sus componentes HTML
 *      2º definir los métodos de pruebas que van a realizar.
 * 
 * 
 * 
 * 
 * */
public class GooglePage extends BasePage{

By localizadorBuscador=By.name("q");
By localizadorCookies=By.xpath("//button[@id=\"L2AGLb\"]");
	
	public GooglePage(WebDriver driver) {
		super(driver);
	}
	
	
	public void buscar(String palabra) {
		WebElement buscador=this.driver.findElement(localizadorBuscador);
		buscador.sendKeys(palabra + Keys.ENTER);
	}
	
public void aceptarCookies() {
		this.driver.findElement(localizadorCookies).click();
	}
}
