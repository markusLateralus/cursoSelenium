package AwebDriver.ConfiguracionesCompartidas;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;


/*  Podemos configurar la velocidad de inicializar los navegadores 
 * 
 * 
 * 1º NORMAL
   Esto hará que Selenium WebDriver espere a que se cargue toda la página. Cuando se establece en normal , Selenium WebDriver espera hasta que se devuelve el evento de carga .
   De forma predeterminada , normal se establece en navegador si no se proporciona ninguno.
 * 
 * 
 * 
 * 2º EAGER
 * Esto hará que Selenium WebDriver espere hasta que el documento HTML inicial se haya cargado y analizado por completo, y descartará la carga de hojas de estilo, imágenes y subtramas.
   Cuando se configura como EAGER , Selenium WebDriver espera hasta que se devuelve el evento DOMContentLoaded .
   
   
   3º NONE
   Cuando se establece en ninguno , Selenium WebDriver solo espera hasta que se descarga la página inicial.
   
   *****************************************************************************************
   También podemos comprobar el TLS Certificate
     si el método setAcceptInsecureCerts(false) devolverá un error de certificado inseguro cuando haya problemas con el certificado
     si es true, el navegador confiará en el certificado no valido.
   
 */
public class AestrategiaDeCarga {
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();
WebDriver driver = new ChromeDriver(chromeOptions);
try {
// Navigate to Url
driver.get("https://google.com");
} catch(WebDriverException e) {
	System.out.println("error " + e.getMessage());
}finally {
driver.quit();
}
}
}