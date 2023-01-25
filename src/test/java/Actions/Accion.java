package Actions;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import AobjetosDeWebdriver.Driver;
import AobjetosDeWebdriver.OpcionesDeChrome;


/*Sirve para manejar eventos de teclado y mouse
 * 
 * 1º para raton:
	doubleClick() : Realiza doble clic en el elemento
	clickAndHold() : Realiza un clic largo en el mouse sin soltarlo
	dragAndDrop() : Arrastra el elemento desde un punto y lo suelta en otro
	moveToElement() : Mueve el puntero del mouse al centro del elemento
	contextClick() : Realiza clic derecho en el mouse
	
	
  2º para teclado
  	sendKeys() : Envía una serie de claves al elemento
	keyUp() : Realiza la liberación de la tecla
	keyDown () : realiza la pulsación de tecla sin soltar
  
 
 * 
 * */
public class Accion {

	private Actions actions;
	private Action action;
	WebDriver driver;
	
	///TIENE 2 CONSTRUCTORES. HACEMOS EJEMPLO DE COMO FUNCIONAR�A LOS 2
	public Accion (WebDriver driver) {
		this.actions=new Actions(driver);
		
	}
	
	public Accion (Driver driver) {
		this.actions=new Actions(driver.webDriver);
		
	}
	
	public Actions hacerClick(WebElement element) {
		return actions.click(element);
	}
	public Actions hacerDobleClick(WebElement webElement) {
			return actions.doubleClick(webElement);
	
	}
	public void moverElRatonAlElemento(WebElement element) {
		actions.moveToElement(element).perform();
	}
	public Actions hacerClickBotonDerecho(WebElement element) {
		return actions.contextClick(element);
	}
	public void arrastraYsuelta(WebElement element1, WebElement element2) {
		actions.dragAndDrop(element1, element2).perform();
	}
	
	public void arrastraYsuelta(WebElement element, int ancho, int alto) {
		actions.dragAndDropBy(element, ancho, alto).perform();
	}
	
	
         	//TECLADO
	public Actions pulsarSinSoltar(WebElement element, CharSequence tecla) {
		                                              //Keys.META, Keys.COMMAND, Keys.SHIFTo, .Keys.ALT, Keys.CONTROL
		return actions.keyDown(element, tecla);
	}
	
	public Actions escribir( CharSequence string) {
		return actions.sendKeys(string);
		
	}
	public Actions soltarTecla(WebElement element, CharSequence tecla) {
		return actions.keyUp(element, tecla);
	}
 
	
	public void ejecutarse() {
		actions.build().perform();
	}
	public static void main(String[] args) {
		
		//UTILIANDO EL PRIMER CONSTRUCTOR
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver= new ChromeDriver(); //creamos nueva ventana
		driver.manage().window().maximize(); // maximizamos
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		
		Accion accion=new Accion(driver);               
	 //   accion.hacerClickBotonDerecho(driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]")));
		WebElement enlaceReptiles=driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]"));
		
		//accion.ejecutarAccion();
	//	accion.hacerClick(driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]")));
		//accion.moverElRaton(driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[5]")));
	//	accion.hacerClick(driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")));
		//driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")).click();
		

		
		//EJEMPLO de escribir en un campo en mayusculas
		WebElement campoBusqueda=driver.findElement(By.xpath("//*[@id=\"SearchContent\"]/form/input[1]"));
		accion.pulsarSinSoltar(campoBusqueda, Keys.SHIFT);
		accion.escribir("texto");
		accion.soltarTecla(campoBusqueda, Keys.SHIFT);
		accion.ejecutarse();
	  //hacer click en un enlace
		accion.hacerClick(enlaceReptiles);
		accion.ejecutarse();
		
		//EJEMPLO mover el raton sobre todos los elementos de una tabla
		WebElement tabla=driver.findElement(By.tagName("table"));
		List <WebElement>trs=tabla.findElements(By.tagName("tr"));
		List<WebElement>tds=tabla.findElements(By.tagName("td"));
		System.out.println(tds.size());
		int indice=0;
		for(int i=0; i<trs.size();i++) {
			if(i==0) {
				System.out.println("cabecera:" + trs.get(i).getText());
			}else {
				System.out.println("cuerpo: " + trs.get(i).getText());
			}
		}
		// me creo esta lista y le agrego los valores del elemento tr, el 2 y 3
		List <String>posicionesTr=new ArrayList<String>();
		posicionesTr.add("2");
		posicionesTr.add("3");
		//*[@id="Catalog"]/table/tbody/tr[2]/td[1]
		//*[@id="Catalog"]/table/tbody/tr[2]/td[2]
		//*[@id="Catalog"]/table/tbody/tr[3]/td[1]
		//*[@id="Catalog"]/table/tbody/tr[3]/td[2]
		List <String>xpathTds=new ArrayList<String>();
		for(int j=0; j< posicionesTr.size();j++) {
		for(int i=0; i<tds.size(); i++) {
			if(i<2) {
			String xpath=String.format("//*[@id=\"Catalog\"]/table/tbody/tr["+posicionesTr.get(j)+"]/td[%s]", i+1);
			xpathTds.add(xpath);
			}
			
		}
		}
		//tds.forEach(System.out::println);
		for(String td:xpathTds) {
			System.out.println(td);
		}
		int contador=0;
		//ahora se desplaza por cada uno de los elementnos de la tabla
		for(int i=0; i<tds.size();i++) {
			 accion.moverElRatonAlElemento(tds.get(contador).findElement(By.xpath(xpathTds.get(i))));
			 System.out.println(tds.get(contador).findElement(By.xpath(xpathTds.get(i))).getText());
			 try {
				 Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
		}
		
		accion.moverElRatonAlElemento(driver.findElement(By.xpath("//*[@id=\"PoweredBy\"]/a")));
		driver.quit();
		
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
		// MISMO EJEMPLOS CON EL 2� CONSTRUCTOR
			System.out.println("-------------------------------------------------------------");
		Driver miDriver= new Driver(new OpcionesDeChrome()); //creamos nueva ventana

		miDriver.ir("https://petstore.octoperf.com/actions/Catalog.action");
		
		Accion accion2=new Accion(miDriver.webDriver);               
	 //   accion.hacerClickBotonDerecho(driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]")));
		WebElement enlaceReptiles2=miDriver.dameElemento(By.xpath("//*[@id=\"SidebarContent\"]/a[4]"));
		
		//accion.ejecutarAccion();
	//	accion.hacerClick(driver.findElement(By.xpath("//*[@id=\"SidebarContent\"]/a[4]")));
		//accion.moverElRaton(driver.findElement(By.xpath("//*[@id=\"QuickLinks\"]/a[5]")));
	//	accion.hacerClick(driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")));
		//driver.findElement(By.xpath("//*[@id=\"MainImageContent\"]/map/area[2]")).click();
		

		
		//EJEMPLO de escribir en un campo en mayusculas
		WebElement campoBusqueda2=miDriver.dameElemento(By.xpath("//*[@id=\"SearchContent\"]/form/input[1]"));
		accion2.pulsarSinSoltar(campoBusqueda2, Keys.SHIFT);
		accion2.escribir("texto");
		accion2.soltarTecla(campoBusqueda2, Keys.SHIFT);
		accion2.ejecutarse();
	  //hacer click en un enlace
		accion2.hacerClick(enlaceReptiles2);
		accion2.ejecutarse();
		
		//EJEMPLO mover el raton sobre todos los elementos de una tabla
		WebElement tabla2=miDriver.dameElemento(By.tagName("table"));
		List <WebElement>trs2=miDriver.dameTodosLosElementos(By.tagName("tr"));
		List<WebElement>tds2=miDriver.dameTodosLosElementos(By.tagName("td"));
		System.out.println(tds2.size());
		int indice2=0;
		for(int i=0; i<trs2.size();i++) {
			if(i==0) {
				System.out.println("cabecera:" + trs2.get(i).getText());
			}else {
				System.out.println("cuerpo: " + trs2.get(i).getText());
			}
		}
		// me creo esta lista y le agrego los valores del elemento tr, el 2 y 3
		List <String>posicionesTr2=new ArrayList<String>();
		posicionesTr2.add("2");
		posicionesTr2.add("3");
		//*[@id="Catalog"]/table/tbody/tr[2]/td[1]
		//*[@id="Catalog"]/table/tbody/tr[2]/td[2]
		//*[@id="Catalog"]/table/tbody/tr[3]/td[1]
		//*[@id="Catalog"]/table/tbody/tr[3]/td[2]
		List <String>xpathTds2=new ArrayList<String>();
		for(int j=0; j< posicionesTr2.size();j++) {
		for(int i=0; i<tds2.size(); i++) {
			if(i<2) {
			String xpath=String.format("//*[@id=\"Catalog\"]/table/tbody/tr["+posicionesTr.get(j)+"]/td[%s]", i+1);
			xpathTds2.add(xpath);
			}
			
		}
		}
		//tds.forEach(System.out::println);
		for(String td:xpathTds2) {
			System.out.println(td);
		}
		int contador2=0;
		//ahora se desplaza por cada uno de los elementnos de la tabla
		for(int i=0; i<tds2.size();i++) {
			 accion2.moverElRatonAlElemento(tds2.get(contador).findElement(By.xpath(xpathTds2.get(i))));
			 System.out.println(tds2.get(contador).findElement(By.xpath(xpathTds2.get(i))).getText());
			 try {
				 Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 
		}
		
		accion2.moverElRatonAlElemento(miDriver.dameElemento(By.xpath("//*[@id=\"PoweredBy\"]/a")));
	}


	
}




