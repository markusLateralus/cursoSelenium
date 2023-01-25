package EpatronPOMavanzado;

import org.testng.annotations.Test;

import Herramientas.BrowserManager;
import Herramientas.ResultManager;
import Herramientas.ScreenshotManager;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class PrincipalTest {
	 
	private WebDriver driver;
	private GooglePage googlePage;
  @Test(description="aceptamos las cookies, buscamos wikipedia y verifica el título")
  public void buscarEnElBuscador() {
	//aceptamos las cookies
			googlePage.aceptarCookies();
			//utilizamos el método buscar para la palabra wikipe
			googlePage.buscar("wikipedia");
			//IMPORTANTE verificamos que ha buscado wikipedia
			googlePage.verificarTitulo("wikipedia - Buscar con GoogleE");
			//googlePage.hacerScreenshot();
  }
  @BeforeMethod
  public void beforeMethod() {
	  
		googlePage=new GooglePage(driver);
		driver=googlePage.chromeDriverConnection();
		driver.get("https://google.es");
		  BrowserManager.setWindow(driver, 200, 200);
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  //si el test falla se hace una captura de pantalla
	  if(!result.isSuccess()) {
		ScreenshotManager.hacerCapturaPantalla(driver, "Error");	
	  }else {
		 ResultManager.mostrarResultado(result);
	  }
		driver.quit();
  }

}
