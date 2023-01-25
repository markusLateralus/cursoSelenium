package AobjetosDeWebdriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;


/*
 *  esta clase se encarga de cargar opciones de chromeDriver;
 * 
 *            listaPreferencias:
 *  1º start-maximized: Abre Chrome en modo maximizado
	2º incognito: Abre Chrome en modo incógnito
	3º headless: Abre Chrome en modo «headless»
	4º disable-extensions: Deshabilita las extensiones existentes en el navegador Chrome
	5º disable-popup-blocking: Deshabilita las ventanas emergentes que se muestran en el navegador Chrome
	6º make-default-browser: Hace que Chrome sea el navegador predeterminado
	7º version: Imprime la versión del navegador Chrome
	8º disable-infobars: Evita que Chrome muestre la notificación ‘Chrome está siendo controlado por un software automatizado
 * 
 * */
public class OpcionesDeChrome extends ChromeOptions{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OpcionesDeChrome() {
	
	//	this.addArguments("--headless");  //abrir chrome sin interfaz grafica, la quuito porque no aparece ninguna ventana
		this.addArguments("--start-maximized"); //maximizar ventana
	//	this.addArguments("--disable-dev-shm-usage");  //  La partición /dev/shm es demasiado pequeña en ciertos entornos de VM, lo que provoca
														// Chrome falla o se bloquea (ver http://crbug.com/715363 ). Usa esta bandera para
														// solucionar este problema (siempre se utilizará un directorio temporal para crear
														// archivos anónimos de memoria compartida.
		                                             //Solo se agrega cuando CIla variable de entorno del sistema está configurada o dentro de una instancia de docker.
		
		//this.addArguments("--incognito");
		 this.addArguments("--disable-extensions"); //deshabilita las extensiones de chrome
		//String directorioDeUserData="C:/Users/mraralma/AppData/Local/Google/Chrome/User Data";
		//this.addArguments(String.format("user-data-dir=%s", directorioDeUserData));
		this.addArguments("--ignore-ssl-errors=yes");   //deshabilita mensaje "la conexion no es privada"
		this.addArguments("--ignore-certificate-errors");// igual, desabilita ventana con el mensaje "la conexion no es privada"
		this.addArguments("--disable-popup-blocking");//deshabilita ventana emergente
		this.addArguments("--disble-web-security"); //deshabilita la politica del mismo origen o Same Origin Policy
		this.addArguments("--disable-notifications");//deshabilita notificaciones de Chrome. La pantalla pequeña con la campanita y con 2 botones(permitir, bloquear)
		this.addArguments("--no-sandbox");//deshabilita el modo sandbox
	//	this.addArguments("allow-running-insecure-content"); //deshabilita en la barra de navegacion el aviso de  "Contenido no seguro"
    //  this.addArguments("--auto-open-devtools-for-tabs"); //abrir la ventana "herramienta para programadores "DevTools 
   //   this.addArguments("allow-running-insecure-content");// permite ejecutar contenido INSEGURO
		this.addArguments("--lang=es"); //tener el navegador en español
		this.addArguments("--no-default-browser-check"); //deshabilita el mensaje "Google Chrome no es tu navegador predeterminado "
		this.addArguments("--no-first-run"); //hace que vaya más rápido el navegador la primera vez que arranca
		this.addArguments("--disable-blink-features=AutomationControlled");//evita que webDriver sea detectado por la pagina, al escribir en el navegador navigator.webdriver debe ser FALSE. 
																		//MUY IIMPORTANTE ESTA OPCION

		//opcion.setAcceptInsecureCerts(true); //aceptar certificado SSL
		this.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation")); //quita el mensaje de la ventana "Un software automatizado de pruebas esta controlando Chrome"
		//this.setExperimentalOption("excludeSwitches", Collections.singletonList("allow-running-insecure-content")); //permite ejecutar contenido INSEGURO;
		
	
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OpcionesDeChrome opciones=new OpcionesDeChrome();
		Driver driver=new Driver(opciones);
		driver.ir("http://tutorialsninja.com/demo/");
		//driver.ir("https://www.youtube.com/");
		//driver.ir("https://petstore.octoperf.com/actions/Catalog.action");
	

	}

}
