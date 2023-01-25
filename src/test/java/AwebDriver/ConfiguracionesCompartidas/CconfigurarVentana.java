package AwebDriver.ConfiguracionesCompartidas;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;

/*  setWindowRect
 * Este comando altera el tamaño y la posición de la ventana de contexto de navegación actual.
 *  hay 4 valores:
 *  1º maximizado-> maximized
 *  2º minimizado -> minimized
 *  3º normal -> normal
 *  4º pantalla completa-> fullscreen
 * 
 * 
   
 */

public class CconfigurarVentana {
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);   
chromeOptions.addArguments("start-minimized");    //<--Es aquí donde debemos configurarlo
WebDriver driver = new ChromeDriver(chromeOptions);


try {
// Navigate to Url
driver.get("https://google.com");
driver.wait(2000);
} catch(Exception e) {
	System.out.println("error " + e.getMessage());
}finally {
driver.quit();
}
}
}