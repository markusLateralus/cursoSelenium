package AobjetosDeWebdriver;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * se encarga de gestionar los 3 tipos de alerts que existen
 * 
 *   1º alert: solo tiene boton confirmar
 *   2º confirm: además, tiene el boton cancelar
 *   3º promt: ademá, tiene un cuadro de texto para enviar mensaje, como un formulario
 *   
 * 
 * 
 *        Alert    * es diferente
 * - debemos declarar un explicit wait y preguntar si el alert está presente
 * - Para almacenarlo usaremos la variable de tipo Alert
 * - solo tiene el botón aceptar
 * 
 * */
public class Alerta {

	WebDriver driver;
	
	public Alerta(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getBotonAlerta(By id) {
		return driver.findElement(id);
	}
	
	private WebDriverWait esperarExplicita(long segundos) {
		return new WebDriverWait(driver,segundos);
	}
	//1º almacena un alert simple
	public Alert getAlerta() {
		WebDriverWait espera=this.esperarExplicita(5);
		return espera.until(ExpectedConditions.alertIsPresent());
	}
	
	//2º almacena un Confirmar
	public Alert getConfirmar() {
		return driver.switchTo().alert();
	}
	//3º almacena un promt
	public Alert getPromt() {
		WebDriverWait espera=this.esperarExplicita(5);
		return espera.until(ExpectedConditions.alertIsPresent());
	}
	public String getTextoAlerta() {
		return this.getAlerta().getText();
	}
	public String getTextoConfirmar() {
		return this.getConfirmar().getText();
	}
	public String getTextoPromt() {
		return this.getPromt().getText();
	}
	
	public void presionarBotonAceptar() {
		this.getAlerta().accept();
	}
	
	public void presionarBotonCancelar() {
		this.getConfirmar().dismiss();
	}
	public void enviarTexto(String texto) {
		this.getPromt().sendKeys(texto);
	}
}
