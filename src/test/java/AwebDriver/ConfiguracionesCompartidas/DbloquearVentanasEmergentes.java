package AwebDriver.ConfiguracionesCompartidas;

import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import io.github.bonigarcia.wdm.WebDriverManager;

/*  Bloquear ventanas emergentes

De forma predeterminada, ChromeDriver configura Chrome para permitir ventanas emergentes. 
Si desea bloquear las ventanas emergentes (es decir, restaurar el comportamiento normal de Chrome cuando ChromeDriver no lo controla), 
haga lo siguiente:

   
 */

public class DbloquearVentanasEmergentes {
public static void main(String[] args) {

	System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
ChromeOptions chromeOptions = new ChromeOptions();                   //deshabilitar ventanas emergentes
chromeOptions.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));   //<--Es aquí donde debemos configurarlo
chromeOptions.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));//quita el mensaje de la ventana "Un software automatizado de pruebas esta controlando Chrome"
chromeOptions.addArguments("--lang=es");
WebDriver driver = new ChromeDriver(chromeOptions);



// Navigate to Url
driver.get("https://google.com");

}
}