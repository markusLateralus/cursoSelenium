package Ainiciacion;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Dxpath {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.wikipedia.es");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void test() throws InterruptedException {

//buscar por xpath.    abrir inspeccionar, ctrol F
/*
 * 
 * 
 *   /   ->hijo directo
 *   
 *   //  -> cualquier tipo de hijo, nieto....
 *   
 *    /a  -> hijo directo que tiene un elemento a
 *    
 *     *  -> cualquier elemento
 *     
 *   //*[@id="p-logo"]  -> cualquier elemento con id="p-logo"
 *   
 *   [text()="Leer"] -> contiene un texto que es "Leer"
 *   
 *   //input[@id="login"] -> cualquier INPUT cuyo id sea login
 *   
 *   //input[@name='bebida' and @value='agua'] ->cuanquier input cuyo name sea bebida Y cuyo valor sea agua. CONCATENAMOS
 *   
 *   (//)  -->cuando la búsqueda devuelve una lista de valores se meten en paréntesis
 *   
 *   (//div[@="buscador"]/descendant::div[@class="g"])[1] -->buscamos un div que tenga el ID  y que tenga como descendencte un DIV con el atributo CLASS y sea el PRIMERO
 *   
 *   (//div[@="buscador"]/descendant::div[@class="g"])[1]/descendant::a[1]  ->que tenga como descentiente un tipo A y sea el PRIMERO
 * 
 *   //div[text()="Acepto"]  --> div cuyo texto es..
 *   
 *   //div[text()="Acepto"]/ancestor::button  -->busca un div cuyo texto es acepto y un hijo POR ENCIMA que sea de tipo boton
 *
 *   //img[@src="direccion"]  -> devuelve una IMAGEN
 *   
 *   
 * */		
		
	WebElement enlace= driver.findElement(By.xpath("//*[@id=\"p-logo\"]/a"));
		enlace.click();
		//String titulo1= paginaAleatoria.getAttribute("innerText"); //buscamos el atributo innerText de la página.
		WebElement enlaceVerificacion= driver.findElement(By.xpath("//*[@id=\"Bienvenidos_a_Wikipedia,\"]/a"));
		String titulo2=enlaceVerificacion.getAttribute("title");
		System.out.println(titulo2);  //Wikipedia:Bienvenidos. CORRECTO!!
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
