package EpatronPOM;



import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/*  Qué es POM
 * 
 * - Es un patrón de diseño que nos enseña separar los elementos de una página web de la lógica de la prueba que queremos realizar sobre ella.
 * - Nos permite evitar duplicación de código al reutilizar los métodos.
 * - Mejora la mantenibilidad del código.
 * - Junto a Cucumber (BDD) nos permite estructurar las pruebas de forma descriptiva.
 * 
 * - CONFIGURACIÓN:
 * 
 * En el archivo pom vamos a meter la dependencia junit jupiter.
 * También vamos a meter el PLUGIN surefire. Para ello debemos crear una etiqueta <build>,otra <plugins> y otra <plugin>
 * También debemos agregar la siguiente etiqueta <properties> para indicarle a MAVEN que estamos usando la versión 8 de Java
 * 
 *   <properties>
 *       <project.buid.sourceEncoding>UTF-8</project.build.sourceEncoding>
 *       <maven.compiler.source>1.8</maven.compiler.source>
 *       <maven.compiler.target>1.8</maven.compiler.target>
 *   </properties>
 *   
 *   
 *   - crear un paquete para almacenar las clases que son las páginas
 *   - Creamos tantas clases necesarias para cada una de las páginas.
 *   - Creamos una clase PADRE y la herencia para el resto.
 *   
 *   
 *   
 *   
 *   
 * */
public class AqueEsPOM {

	
	private WebDriver driver;
	private String wikipedia;
	//primer paso declarar el objeto By 
	private By linkPaginaAleatoria;
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.manage().window().maximize(); 
		this.wikipedia="https://www.wikipedia.es";
		//segundo paso, inicializamos By con el selecctor deseado, en este caso co linkText();
		linkPaginaAleatoria= By.linkText("Página aleatoria");
		
	}

	

	@Test
	public void test() throws InterruptedException {
		driver.get(this.wikipedia);
		Thread.sleep(4000);
		 //tercer paso, utilizamos el objeto By dentro del método findElement()
	driver.findElement( linkPaginaAleatoria).click();
	String titulo=driver.getTitle();
	System.out.println(titulo);  //ok
		
	}
	
	
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}
}
