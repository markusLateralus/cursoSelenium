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
 *  1� start-maximized: Abre Chrome en modo maximizado
	2� incognito: Abre Chrome en modo inc�gnito
	3� headless: Abre Chrome en modo �headless�
	4� disable-extensions: Deshabilita las extensiones existentes en el navegador Chrome
	5� disable-popup-blocking: Deshabilita las ventanas emergentes que se muestran en el navegador Chrome
	6� make-default-browser: Hace que Chrome sea el navegador predeterminado
	7� version: Imprime la versi�n del navegador Chrome
	8� disable-infobars: Evita que Chrome muestre la notificaci�n �Chrome est� siendo controlado por un software automatizado
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
	//	this.addArguments("--disable-dev-shm-usage");  //  La partici�n /dev/shm es demasiado peque�a en ciertos entornos de VM, lo que provoca
														// Chrome falla o se bloquea (ver http://crbug.com/715363 ). Usa esta bandera para
														// solucionar este problema (siempre se utilizar� un directorio temporal para crear
														// archivos an�nimos de memoria compartida.
		                                             //Solo se agrega cuando CIla variable de entorno del sistema est� configurada o dentro de una instancia de docker.
		
		//this.addArguments("--incognito");
		 this.addArguments("--disable-extensions"); //deshabilita las extensiones de chrome
		//String directorioDeUserData="C:/Users/mraralma/AppData/Local/Google/Chrome/User Data";
		//this.addArguments(String.format("user-data-dir=%s", directorioDeUserData));
		this.addArguments("--ignore-ssl-errors=yes");   //deshabilita mensaje "la conexion no es privada"
		this.addArguments("--ignore-certificate-errors");// igual, desabilita ventana con el mensaje "la conexion no es privada"
		this.addArguments("--disable-popup-blocking");//deshabilita ventana emergente
		this.addArguments("--disble-web-security"); //deshabilita la politica del mismo origen o Same Origin Policy
		this.addArguments("--disable-notifications");//deshabilita notificaciones de Chrome. La pantalla peque�a con la campanita y con 2 botones(permitir, bloquear)
		this.addArguments("--no-sandbox");//deshabilita el modo sandbox
	//	this.addArguments("allow-running-insecure-content"); //deshabilita en la barra de navegacion el aviso de  "Contenido no seguro"
    //  this.addArguments("--auto-open-devtools-for-tabs"); //abrir la ventana "herramienta para programadores "DevTools 
   //   this.addArguments("allow-running-insecure-content");// permite ejecutar contenido INSEGURO
		this.addArguments("--lang=es"); //tener el navegador en espa�ol
		this.addArguments("--no-default-browser-check"); //deshabilita el mensaje "Google Chrome no es tu navegador predeterminado "
		this.addArguments("--no-first-run"); //hace que vaya m�s r�pido el navegador la primera vez que arranca
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
