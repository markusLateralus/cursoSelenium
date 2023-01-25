package Aidentificadores;


import static org.testng.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/*   LOCALIZADORES RELATIVOS
 * - Se utilizan cuando un elemento es dificil de encontrar
 * - Hay 5 tipos:
 *   a) arriba: above           By emailLocator = RelativeLocator.with(By.tagName("input")).above(By.id("password"));
 *   b) abajo: below            By passwordLocator = RelativeLocator.with(By.tagName("input")).below(By.id("email"));
 *   c) izquierda de: toLeftOf  By cancelLocator = RelativeLocator.with(By.tagName("button")).toLeftOf(By.id("submit"));
 *   d) derecha de : toRigthOf  By submitLocator = RelativeLocator.with(By.tagName("button")).toRightOf(By.id("cancel"));
 *   c) cerca: near             By emailLocator = RelativeLocator.with(By.tagName("input")).near(By.id("lbl-email"));
 * 
 * 
 * también podemos encadenar los localizadores
 * By submitLocator = RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel"));
 * */
public class CidentificadoresRelativos {

	private WebDriver driver;
	//private By id=By.id("n-randompage");
	//By id=By.xpath("//li[@id='n-randompage']");
	//By borro=driver.findElement(with(By.cssSelector("input")).toRightOf(By.cssSelector("")));
	 By arriba= RelativeLocator.with(By.tagName("li")).above(By.xpath("//li[@id='n-randompage']"));   //<----arriba de...
	//private By ccsSelector=By.cssSelector("div#main-tga>p");
	By abajo=RelativeLocator.with(By.tagName("h2")).below(By.cssSelector("div#main-tga>p"));    //<--- abajo de...
	//private By linkText=By.linkText("Página aleatoria");
	By cerca=RelativeLocator.with(By.tagName("div")).near(By.linkText("Página aleatoria"));
	private By tagName=By.tagName("title");
	//private By xpath= By.xpath("//*[@id=\"p-logo\"]/a");
	By derechaDe=RelativeLocator.with(By.tagName("li")).toRightOf(By.xpath("//*[@id=\"p-logo\"]/a"));
	private By localizadorEnlaces=By.xpath("(//div[@class=\"vector-menu-content\"])[6]/descendant::a");
	
	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.wikipedia.es");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void testBuscarTituloEnlacePaginaAleatoria(){  
				driver.findElement(arriba).click();  //<-- ARRIBA
				String titulo=driver.getTitle();
				System.out.println("titulo pagina aleatoria " + titulo);  //Castillo Dolbadarn - Wikipedia, la enciclopedia libre
			
	}
	
	@Test
	public void testBuscarLinkText(){
		  //buscar por LinkText
		driver.findElement(cerca).click();    //<-- CERCA
		String titulo=driver.getTitle();
		System.out.println(titulo);  //ok
		
	}
	
	@Test
	public void testBuscarTagName() {
		//buscar por tagName   
		  // nos devuelve el primer elemento html que encuentre. Esto no es seguro.
		     // es mejor almacenar una lista de elementos que cumpla una condición
			// para ello utilizaremos  findElements(By.tagName("elemento HTML")
			WebElement paginaAleatoria= driver.findElement(tagName);
			String tituloDeseado= paginaAleatoria.getAttribute("innerText"); //buscamos el atributo innerText de la página.
			String tituloObtenido=driver.getTitle();
			System.out.println("soy el atributo innerText: " + tituloDeseado); //soy el atributo innerText: Wikipedia, la enciclopedia libre
			System.out.println(tituloObtenido);  //Wikipedia, la enciclopedia libre
			assertEquals(tituloDeseado,tituloObtenido,"No son el mismo título");

	}
	
	@Test
	public void testBuscarXpath() {
	

		WebElement enlace= driver.findElement(derechaDe);   // <- DERECHA DE..
		enlace.click();
		WebElement enlaceVerificacion= driver.findElement(derechaDe);  // <- DERECHA DE..
		String titulo2=enlaceVerificacion.getAttribute("title");
		System.out.println(titulo2);  //Wikipedia:Bienvenidos. CORRECTO!!
	}
	@Test
	public void testBuscarCssSelecto(){	
		//buscar por cssSelector  utilizamos la sintaxis de JQuery
		WebElement parrafo=driver.findElement(abajo);   // <-- ABAJO
		String texto=parrafo.getText();
		System.out.println(texto); //CORRECTO!!!
	}
	
	@Test
	public void testMultiplesElementos(){
		//buscamos una lista de enlaces, verificamos su tamaño. Sabemos que en total hay 9
		List <WebElement> enlaces=driver.findElements(localizadorEnlaces);
		 assertEquals(9, enlaces.size(), "No tiene el 9 enlaces");
		 
		 //vamos a mostrar por pantalla los enlaces con la propiedad href
		 for(WebElement link : enlaces)
			 System.out.println(link.getAttribute("href"));
	
	
	}
	
	@AfterEach
	public void tearDown(){
		driver.quit();
	}

}
