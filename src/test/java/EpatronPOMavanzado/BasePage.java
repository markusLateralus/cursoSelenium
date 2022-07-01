package EpatronPOMavanzado;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*  Función principal de esta clase
 * 
 * Aislar del resto del código de los comandos de Selenium WD(wrapper o envoltura), cambio de versiones..
 * 
 * De este modo actualizando esta clase se actualizan las clases hijas
 * 
 * 
 * 
 * */
public class BasePage {

protected WebDriver driver;

	
	public BasePage(WebDriver driver) {
		this.driver=driver;
		//this.driver.manage().window().maximize(); 
	}
	
	//creamos la instancia de Chrome
	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		return driver;
	}
	
	//devuelve el elemento segun el objeto By localizador que le pongamos por parámetros
	public WebElement findElement(By localizador) {
		return this.driver.findElement(localizador);
	}
	
	
	//devuelve una LISTA de elementos
	public List <WebElement> findElements(By localizador){
	    List<WebElement> lista=this.driver.findElements(localizador);
	    return lista;
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By localizador) {
		return this.driver.findElement(localizador).getText();
	}
	
	public void escribirInput(String texto, By localizador) {
		this.driver.findElement(localizador).sendKeys(texto);
		}
	
	public void click(By localizador) {
		this.driver.findElement(localizador).click();
	}
	
	//nos dice si el elemnto está diponible
	public boolean isDisplayed(By localizador) {
		try {
			return this.driver.findElement(localizador).isDisplayed();
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	

	
	
	public String getTitle() {
		return this.driver.getTitle();
	}
	
}
