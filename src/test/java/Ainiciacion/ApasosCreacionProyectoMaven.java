package Ainiciacion;



import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*PASOS PARA CREAR EL PROYECTO 
 * 
 * 1º Descargar JDK java 
 * 2º Instalar JDK
 * 3º Crear una variable de entorno con el nombre JAVA_JDK y que apunte a la directorio:C:\Program Files\Java\jdk-17.0.3.1
 * 4º En la variable de entorno llamada PATH, le agregamos el siguiente directorio: C:\Program Files\Java\jdk-17.0.3.1\bin
 * 5º Crear un proyecto nuevo con MAVEN, create a simple project, Group ID(nombre de nuestra empresa) Artifact ID (nombre del artifact que estamos creando)
 * 6º En el archivo pom.xml agregamos 2 dependencias: selenium y JUnit. 
 *    En caso de que no se instale automaticamente, usar comando: $ mvn dependency:resolve
 * 7º Dentro de src/test/java, creamos el primer paquete llamado Ainiciacion.
 * 8º Creamos nuestra primera clase ApasosCreacionProyectoMaven
 * 9º Configuramos ChromeDriver para iniciar la primera prueba
 * 
 * 
 * 
 * 
 * */
public class ApasosCreacionProyectoMaven {

	private WebDriver driver;
	
	@BeforeEach
	public void configurar() {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://www.google.es");
		//driver.navigate().to("https://www.google.es");
	}
	
	@Test
	public void test() {
		WebElement textoBuscador= driver.findElement(By.name("q"));
		textoBuscador.sendKeys("automatizacion");
		WebElement botonBuscar=driver.findElement(By.name("btnk"));
		botonBuscar.click();
	}
	
	@AfterEach
	public void finalizar(){
		driver.quit();
	}

}
