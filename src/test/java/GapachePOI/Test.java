package GapachePOI;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class Test {

	private WebDriver driver;
	private ReadExcelFile readExcelFile;
	private WriteExcelFile writeExcelFile;
	By botonAceptarCookies=By.id("a-button-text");

	By inputBuscador=By.xpath("(//div[@class=\"nav-fill\"])[2]/descendant::input");
	By botonBuscar=By.id("nav-search-submit-button");
	By spanResultado=By.xpath("(//div[@class=\"sg-col-inner\"])[1]/descendant::span[1]");
	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver(); 
		driver.get("https://www.amazon.es");
		driver.manage().window().maximize(); 
		Thread.sleep(2000);
		readExcelFile=new ReadExcelFile();
		writeExcelFile=new WriteExcelFile();
	}


	@org.junit.jupiter.api.Test
	void test() throws IOException {
		String ruta="C:\\Users\\mraralma\\proyectosEclipse\\cursoSeleniumWebDriver\\src\\test\\java\\GapachePOI\\prueba.xlsx";
		String nombreHoja="Hoja1";
		int posicionFila=0;
		int posicionCelda=0;
		//primero leemos una celda especifica
		String textoCelda=readExcelFile.getCellValue(ruta, nombreHoja, posicionFila, posicionCelda);
		//escribir en el buscador de la web
		driver.findElement(inputBuscador).sendKeys(textoCelda);
		//hacemos clik
		driver.findElement(botonBuscar).click();
		//vemos el resultado obtenido de la busqueda 
		String resultadoBusqueda=driver.findElement(spanResultado).getText();
		System.out.println("resultado de la busqueda: " + resultadoBusqueda);
		
		//Leemos la EXCEL
		readExcelFile.readExcel(ruta, nombreHoja);
		//
		writeExcelFile.writeCellValue(ruta, nombreHoja, posicionFila, posicionCelda + 1, resultadoBusqueda);
		
		readExcelFile.readExcel(ruta, nombreHoja);
		
	}
	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

}
