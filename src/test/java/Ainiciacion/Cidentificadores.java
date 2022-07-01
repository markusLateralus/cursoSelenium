package Ainiciacion;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*   LOCALIZADORES
 * 
 * - Hay un total de 9:
 *  By.id()
 *  By.name(string) ->nombre de los elementos
 *  By.className()  -> hace referencia al atributo class del elemento. Suele haber varios elementos, y devolverá una LISTA
 *  By.tagName() -> devuelve un elemento HTML (title, h2,...), suele devolver una LISTA
 *  By.linkText()-> devuelve el elemento que coincida con el texto del LINK. Util para enlaces
 *  By.partialLinkText()
 *  By.ccsSelector()
 *  By.xpath()
 *  JavascriptExecutor js=(JavascriptExecutor) driver
 * 
 * 
 * 
 * */
public class Cidentificadores {

	private WebDriver driver;
	private By id=By.id("n-randompage");
	private By ccsSelector=By.cssSelector("div#main-tga>p");
	private By linkText=By.linkText("Página aleatoria");
	private By tagName=By.tagName("title");
	private By xpath= By.xpath("//*[@id=\"p-logo\"]/a");
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.wikipedia.es");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void test() throws InterruptedException {
	//buscar el enlace "Página aleatoria" por ID y hacer click.,    texto del enlace->enlace.getAttribute("innerText"));
	//OJO!! es un enlace que está dentro de una lista, nosotros buscamos el id de la lista.
		//	driver.findElement(id).click();
		//	String titulo=driver.getTitle();
		//	System.out.println(titulo);  //Castillo Dolbadarn - Wikipedia, la enciclopedia libre
		//
		
  //buscar por LinkText
			//driver.findElement(linkText).click();
		//	String titulo=driver.getTitle();
		//	System.out.println(titulo);  //ok
			
			
//buscar por tagName   
  // nos devuelve el primer elemento html que encuentre. Esto no es seguro.
     // es mejor almacenar una lista de elementos que cumpla una condición
	// para ello utilizaremos  findElements(By.tagName("elemento HTML")
		//	WebElement paginaAleatoria= driver.findElement(By.tagName("title"));
		//	String titulo1= paginaAleatoria.getAttribute("innerText"); //buscamos el atributo innerText de la página.
		//	String titulo2=driver.getTitle();
		//	System.out.println("soy el atributo innerText: " + titulo1); //soy el atributo innerText: Wikipedia, la enciclopedia libre
		//	System.out.println(titulo2);  //Wikipedia, la enciclopedia libre


//buscar por xpath.    abrir inspeccionar, ctrol F

			WebElement enlace= driver.findElement(xpath);
			enlace.click();
			WebElement enlaceVerificacion= driver.findElement(xpath);
			String titulo2=enlaceVerificacion.getAttribute("title");
			System.out.println(titulo2);  //Wikipedia:Bienvenidos. CORRECTO!!
		
		
		
		
//buscar por cssSelector  utilizamos la sintaxis de JQuery
		//WebElement parrafo=driver.findElement(ccsSelector);
		//String texto=parrafo.getText();
		//System.out.println(texto); //CORRECTO!!!
		
		
		
		
	}
	
	@AfterEach
	public void tearDown(){
		driver.quit();
	}

}
