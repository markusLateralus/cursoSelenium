package Ainiciacion;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class FdragAndDrop {
	
	private WebDriver driver;
	private By localizadorFrom=By.id("draggable");
	private By localizadorTo=By.id("droppable");
	  @BeforeMethod
	  public void beforeMethod() {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver= new ChromeDriver(); 
			driver.manage().window().maximize(); 
			driver.get("https://demoga.com/droppable");
	  }

  @Test
  public void dragAndDrop() throws InterruptedException {
	  Thread.sleep(2000);
	  //crear objeto Actions
	  Actions action=new Actions(driver);
	  //declaramos dos WebElements (Desde,Hasta)
	   WebElement from=driver.findElement(localizadorFrom);
	   WebElement to=driver.findElement(localizadorTo);
	   //HAY 2 FORMAS DE HACERLO
	   //1º usar metodo dragAndDrop, build , perform
	   action.dragAndDrop(from, to).build().perform();
	   
	   //2º usar dragAndDropBy
	     // action.dragAndDropBy(from, 250,30).build().perform();
  }

  @AfterMethod
  public void afterMethod() {
	  //driver.quit();
  }
public static void main(String[] args) {
	FdragAndDrop f=new FdragAndDrop();
	f.beforeMethod();
	try {
		f.dragAndDrop();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	f.beforeMethod();
}
}
