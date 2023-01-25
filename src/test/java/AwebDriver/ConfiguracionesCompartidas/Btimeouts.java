package AwebDriver.ConfiguracionesCompartidas;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;
/*  Podemos configurar los tiempos de espera
 *  hay 3 tipos de tiempos de espera:
 *  
 *  1º script timeout:  Especifica cuándo interrumpir un script en ejecución en un contexto de navegación actual.
 *                      El tiempo de espera predeterminado de 30 000 se impone cuando WebDriver crea una nueva sesión.
 *  
 *  2º page load timeout: Especifica el intervalo de tiempo en el que se debe cargar la página web en un contexto de navegación actual. 
 *                        El tiempo de espera predeterminado de 300 000 se impone cuando WebDriver crea una nueva sesión. 
 *                        Si la carga de la página limita un marco de tiempo dado/predeterminado, TimeoutException detendrá el script .

 *  
 *  3º implicit wait timeout: Esto especifica el tiempo de espera para la estrategia de ubicación de elementos implícitos al ubicar elementos. 
 *                            El tiempo de espera predeterminado 0 se impone cuando WebDriver crea una nueva sesión.
 * 
 * 
   
 */


public class Btimeouts {
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();
chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);     //<--Es aquí donde debemos configurarlo

WebDriver driver = new ChromeDriver(chromeOptions);
try {
// Navigate to Url
driver.get("https://google.com");
} catch(WebDriverException e) {
	System.out.println("error certificado inseguro " + e.getMessage());
}finally {
driver.quit();
}
}
}