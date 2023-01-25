package EpatronPOMavanzado;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

public void verificarTitulo(String titulo) {
	assertEquals(titulo, driver.getTitle());
}

public void hacerScreenshot() {
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file, new File("./archivos generados/capturaPantalla" + System.currentTimeMillis()+".png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
}
