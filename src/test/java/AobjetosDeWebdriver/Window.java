 package AobjetosDeWebdriver;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 *   Selenium no distingue entre ventana y pestaña(tab), 
 *   se utilizan los id para conocer el componente
 *   
 * 
 * */
public class Window{
WebDriver driver;
   public Window(WebDriver driver) {
	   this.driver=driver;
   }
   
	//Este identificador es un identificador único para la página web.
   //Esto es diferente cada vez que abre una página, incluso si es la misma URL.
   public String getIdentificador() {
	   return this.driver.getWindowHandle();
   }
	//
	public Set<String> getListaIdentificadoresUnicos(){
		return driver.getWindowHandles();
	}
	//crea una nueva ventana y cambia el foco
	public ChromeDriver  crearNuevaVentana() {
		ChromeDriver nuevaVentana= (ChromeDriver) driver.switchTo().newWindow(WindowType.WINDOW);
//Chrome driver=(Chrome)nuevaVentana;
		
		return nuevaVentana;
	}
	
	//crea una nueva pestaña y cambia el foco
		public ChromeDriver  crearNuevoTab() {
			ChromeDriver nuevaTab= (ChromeDriver) driver.switchTo().newWindow(WindowType.TAB);
	//	Chrome driver=(Chrome)nuevaTab;
			return nuevaTab;
		}
	
	public void cerrarVentana(String ventanaOriginal) {
		driver.close();
		//ChromeDriver ventana=(ChromeDriver)driver.switchTo().window(ventanaOriginal);
		//return ventana;
	}
	//cambiarVentana NO FUNCIONA CORRECTAMENTE
	public void cambiarVentana() {
		String idVentanaActual = driver.getWindowHandle();
		assert driver.getWindowHandles().size() == 1;
     //  driver.findElement(By.linkText("new window")).click();
        WebDriverWait wait= new WebDriverWait(driver,5);
       wait.until(ExpectedConditions.numberOfWindowsToBe(2));
       for (String windowHandle : driver.getWindowHandles()) {
    	   System.out.println("dentro: " +windowHandle);
    	    if(!idVentanaActual.contentEquals(windowHandle)) {
    	        driver.switchTo().window(windowHandle);
    	        break;
    	    }
    	}
       wait.until(ExpectedConditions.titleIs("titulo de la pagina: JavaScript alerts, prompts and confirmations | Selenium"));
	}
   
}
