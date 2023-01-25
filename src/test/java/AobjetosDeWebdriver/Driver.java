package AobjetosDeWebdriver;


import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




/*              PRINCIPALES METODOS DE DRIVER
 * 
 * 1ยบ WebElement elemento=drvier.findElement(By())
 * 
 * 2ยบ List <WebElement> elementos=driver.findElements(By());
 * 
 * 3ยบ driver.get(url)
 * 
 * 4ยบ driver.manage().window().maximize()
 * 
 * 5ยบ driver.close()
 * 
 * 6ยบ driver.quit()
 * 
  7ยบ String titulo=drvier.getTittle(); ///obtener titulo de la pagina
   
   8บ switchTo() //para cambiar de iframe
   
   9บ getCurrentUrl()  // obtener la url de la pagina actual
   
   
   ADEMAS TIENE 5 INTERFACES
   1บ Navigation
   2บ Options   //NO LO USAREMOS
   3บ TargetLocator   //Se utiliza para ubicar un marco o ventana determinada.
   4บ TimeOuts
   5บ Window
 * 
 * 
 * */

public class Driver {

	public WebDriver webDriver;
	WebDriver.Navigation navegador;
	 WebDriver.TargetLocator localizadorDeObjetivo;  //se encarga de los frame
	WebDriver.Timeouts tiempoEspera;
	WebDriver.Window ventana;
	WebDriver.Options opcionesCookie;
	Logs registro;
	WebDriverWait espera;

	public Driver() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		this.webDriver= new ChromeDriver(); //creamos nueva ventana
		this.webDriver.manage().window().maximize();
		//driver.get("https://www.wikipedia.es");
		navegador=webDriver.navigate();
		opcionesCookie=webDriver.manage();
		registro=webDriver.manage().logs();
		localizadorDeObjetivo=webDriver.switchTo();
		tiempoEspera=webDriver.manage().timeouts();
		ventana=webDriver.manage().window();
		
		
		
	}
	public Driver(OpcionesDeChrome opciones) {
		//this.opcionesChrome=opciones;
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		this.webDriver= new ChromeDriver(opciones); //creamos nueva ventana
		//this.driver.manage().window().maximize();
		//driver.get("https://www.wikipedia.es");
		navegador=webDriver.navigate();
		opcionesCookie=webDriver.manage();
		registro=webDriver.manage().logs();
		localizadorDeObjetivo=webDriver.switchTo();
		tiempoEspera=webDriver.manage().timeouts();
		ventana=webDriver.manage().window();
	}

	// FUNCIONES DE LA CLASE
	public void ir(String url) {
		webDriver.get(url);
	}
	public void salir() {
		webDriver.quit();
	}
	public String dameTituloPagina() {
		return webDriver.getTitle();
	}
	public String dameUrlPaginaActual() {
		return webDriver.getCurrentUrl();
	}
	public String dameDOMpagina() {
		return webDriver.getPageSource();
	}
	
	public String dameIdentificador() {
		return webDriver.getWindowHandle();
	}
	public Set <String> dameIdentificadores() {
		return webDriver.getWindowHandles();
	}
	public WebElement dameElemento(By by) {
		return webDriver.findElement(by);
	}
	public List<WebElement> dameTodosLosElementos(By by){
		return webDriver.findElements(by);
	}
/*
	//funciones de NAVEGADOR
	public void retrocedePagina() {
		navegador.back();
	}
	public void avanzaPagina() {
		navegador.forward();
	}
	public void refrescaPagina() {
		navegador.refresh();
	}
	*/
	//funciones de  localizadorDeObjetivo
	public WebDriver seleccionaIframePadre() {
		return this.localizadorDeObjetivo.defaultContent();  //tambien vale  -> parentFrame()
	}

	public WebDriver cambiarVentana(String identificador) {
		return this.localizadorDeObjetivo.window(identificador);
	}
	public WebDriver cambiarDeVentana(int indice) { //sin probar
		return this.localizadorDeObjetivo.frame(indice);
	}
	public WebDriver cambiarDeVentana(WebElement elemento) {  //sin probar
		return this.localizadorDeObjetivo.frame(elemento);
	}
	public WebDriver cambiarDeVentana(String nombreVentana) { //sin probar
		return this.localizadorDeObjetivo.frame(nombreVentana);
	}
	public int dameTotalDeVentanas() {
		return this.webDriver.findElements(By.tagName("iframe")).size();
	}

	//Funciones de COOKIES
	public void agregarCookie(String string1, String string2) {
		opcionesCookie.addCookie(new Cookie(string1, string2));
	}
	public void borrarCookie(Cookie cookie) {
		opcionesCookie.deleteCookie(cookie);
	}
	public void borrarTodasLasCookies() {
		opcionesCookie.deleteAllCookies();
	}
	public Cookie dameCookie(String nombre) {
		return opcionesCookie.getCookieNamed(nombre);
	}
	public Set<Cookie>dameTodasLasCookies(){
		return opcionesCookie.getCookies();
	}
	
	//funciones de REGISTROS
	public Set<String> dameTodosLosRegistros(){
		return registro.getAvailableLogTypes();
		//aun no se usarlo bien
		//Exception in thread "main" org.openqa.selenium.UnsupportedCommandException: unknown command: Cannot call non W3C standard command while in W3C mode
	}
	
	//funciones de TIEMPO DE ESPERA
	
	public  void esperaImplicita(long tiempo) {
	    tiempoEspera.implicitlyWait(tiempo, TimeUnit.SECONDS);
	}
	
	public void esperaQueCargueLaPagina(long tiempo) {
		tiempoEspera.pageLoadTimeout(tiempo, TimeUnit.SECONDS);
	}
	public void esperaQueSeEjecuteElScript(long tiempo) {
		tiempoEspera.setScriptTimeout(tiempo, TimeUnit.SECONDS);
		//lanza un error cuando el script que ha creado el usuario no se ejecuta correctamente, despu้s de esperar el tiempo indicado.
		//por defecto espera 30 segundos
	}
	//funciones de ESPERA  webDriverWait
	public void esperaQueSeaClicable(long tiempo, WebElement elemento) {
		espera=new WebDriverWait(this.webDriver, tiempo);
	    espera.until(ExpectedConditions.elementToBeClickable(elemento));
	}
	public void esperaQueSeaClicable(long tiempo, By by) {
		espera=new WebDriverWait(this.webDriver, tiempo);
	    espera.until(ExpectedConditions.elementToBeClickable(by));
	}
	// presente, visible, hablilitado y NO estar oculto por otro elemento
		public void esperaQueSeaVisible(long tiempo, WebElement element) {
			espera = new WebDriverWait(this.webDriver, tiempo);
			espera.until(ExpectedConditions.visibilityOf(element));
		}

		public void esperaQueSeaSeleccionado(long tiempo, WebElement element) {
			espera= new WebDriverWait(this.webDriver, tiempo);
			espera.until(ExpectedConditions.elementToBeSelected(element));
		}
		public void esperaQueSeaSeleccionado(long tiempo, By by) {
			espera= new WebDriverWait(this.webDriver, tiempo);
			espera.until(ExpectedConditions.elementToBeSelected(by));
		}
	// funciones de VENTANA
	public void ponerPantallaCompleta() {
		ventana.fullscreen();
	}
	public Point damePosicionVentana() {
		return ventana.getPosition();
		//obtengo la posicion de la ventana relativa a la esquina superior izquierda de la pantalla
	}
	public Dimension dameTamanioVentana() {
		return ventana.getSize();
		//obtengo el tamanio de la ventana
	}
	public void maximizarVentna() {
		ventana.maximize();
	}
	public void cambiarPosicionVentana(Point posicion) {
		ventana.setPosition(posicion);
		
	}
	public void cambiarTamanioVentana(Dimension dimension) {
		ventana.setSize(dimension);
	}
	
	
	public static void main(String [] ars) {
		Driver driver=new Driver();
		//driver.ir("https://google.es");
		driver.ir("https://petstore.octoperf.com/actions/Catalog.action");
		//Ejemplos de WebDriver
		String tituloPortada=driver.dameTituloPagina();
		System.out.println(tituloPortada);
		String urlPaginaActual=driver.dameUrlPaginaActual();
		System.out.println(urlPaginaActual);
		String dom=driver.dameDOMpagina();
		//System.out.println(dom);
		String identificador=driver.dameIdentificador();
		//System.out.println(identificador);
		Set <String>identificadores=driver.dameIdentificadores();
		for(String ident:identificadores) {
			System.out.println(ident);
		}
	
		
	//Ejemplos de navegador
		//driver.retrocedePagina();
		//driver.refrescaPagina();
		//driver.avanzaPagina();
		
		
		
	//EJEMPLO de localizadorDeObjetivo
		//WebDriver iframe=driver.seleccionaIframePadre();
		//System.out.println(iframe.getTitle());
		//WebDriver nuevoDriver=driver.cambiarVentana(identificador);
		//driver.driver=nuevoDriver;
		//String identificadorNuevoDriver=driver.dameIdentificador();
		//System.out.println("Identificador nuevo driver " + identificadorNuevoDriver);
		
		
	//Ejemplo de Ventana
		//obtenemos la posicion y el tamanio
		Point posicion=driver.damePosicionVentana();
		System.out.println("posicion de la ventana: " + posicion); //(-8,-8) (x,y)
		Dimension dimension=driver.dameTamanioVentana();
		System.out.println("dimension de la ventana " + dimension); //(1552,840) height, width
		//le cambio la posicion y el tamanio
		driver.cambiarPosicionVentana(new Point(50,50));
		posicion=driver.damePosicionVentana();
		System.out.println("posicion de la ventana: " + posicion); //(49,49) (x,y)
		driver.cambiarTamanioVentana(new Dimension(1000,500));
		dimension=driver.dameTamanioVentana();
		System.out.println("dimension de la ventana " + dimension); //(1002,502) height, width
		driver.maximizarVentna();
		//driver.ponerPantallaCompleta();
		
		
	//EJEMPLOS DE OPCINES DE COOKIES
		//driver.ir("https://www.youtube.com/");
		Set<Cookie>listaCookies=driver.dameTodasLasCookies();
		System.out.println("total de cookies:  " +listaCookies.size());
		for(Cookie cook:listaCookies) {
			System.out.println(cook); //JSESSIONID=590AB9173C92D144E9F630D87A54951F; path=/; domain=petstore.octoperf.com
			System.out.println("nombre " +cook.getName());//JSESSIONID
			System.out.println("dominio " + cook.getDomain()); // petstore.octoperf.com
			System.out.println("path " +cook.getPath()); //  /
			System.out.println("valor " +cook.getValue()); //6DE1D72192C8EC0DF9249E28A459F9CB
			System.out.println("expira " +cook.getExpiry());  // null
		}
		
		//Cookie cookie=driver.dameCookie("JSESSIONID");
		//System.out.println(cookie.getName()); //JSESSIONID
		//eliminamos la cokie
		//driver.borrarCookie(cookie);  //se elimina correctamente
		//driver.borrarTodasLasCookies();
		//listaCookies=driver.dameTodasLasCookies();
		///System.out.println("despues de eliminar una, total de cookies:  " +listaCookies.size()); //el tamanio es 0, correcto
		//System.out.println(cookie.getName());  // pero al pedir el nombre me lo sigue mostrando
		
		driver.agregarCookie("marcos", "sin valor");
		listaCookies=driver.dameTodasLasCookies();
		System.out.println("despues de crear una, total de cookies:  " +listaCookies.size()); //el tamanio es 0, correcto
		
		driver.salir();
		
		OpcionesDeChrome opciones=new OpcionesDeChrome();
		Driver driver2=new Driver(opciones);
		driver2.ir("http://tutorialsninja.com/demo/");
		
	//Ejemplos de REGISTRO
	/*	Set<String>tiposDeRegistros=driver.dameTodosLosRegistros();
		for(String tipo:tiposDeRegistros) {
			System.out.println("tipo: " +tipo);
		}*/
		
		
		
		
		//trabajando con IFRAME
	 //   driver.ir("https://www.youtube.com/");
	/*	//driver.esperaImplicita(5);
		driver.esperaQueCargueLaPagina(5);
		WebElement iframe=driver.dameElemento(By.tagName("iframe"));
        //driver.esperaQueSeaVisible(10, iframe);
		
		int iframes=driver.dameTotalDeVentanas();
		System.out.println("total ventanas " + iframes);*/
		
	
	}

	

	
}
