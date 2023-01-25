package AwebDriver.ConfiguracionesCompartidas;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.messages.types.Duration;
//import io.github.bonigarcia.wdm.WebDriverManager;

/*  PROXY

Un servidor proxy actúa como intermediario para las solicitudes entre un cliente y un servidor.
 En simple, el tráfico fluye a través del servidor proxy en su camino hacia la dirección que solicitó y de regreso.

Un servidor proxy para scripts de automatización con Selenium podría ser útil para:

 - Capturar tráfico de red
 - Llamadas de back-end simuladas realizadas por el sitio web
 - Acceda al sitio web requerido bajo topologías de red complejas o restricciones/políticas corporativas estrictas.
 
Si se encuentra en un entorno corporativo y un navegador no puede conectarse a una URL, lo más probable es que se deba a
 que el entorno necesita un proxy para poder acceder.
 */

public class EconfigurarProxy {
public static void main(String[] args) {

                
Proxy proxy=new Proxy();         //creamos el proxy
proxy.setHttpProxy("<HOST:PORT>");    // indicamos cual es
System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions(); 
chromeOptions.setCapability("proxy", proxy); // se lo agregamos a las opciones de Chorme
WebDriver driver = new ChromeDriver(chromeOptions);


try {
// Navigate to Url
driver.get("https://google.com");
driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
} catch(Exception e) {
	System.out.println("error " + e.getMessage());
}finally {
driver.quit();
}
}
}