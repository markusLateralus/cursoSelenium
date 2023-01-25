package EpatronPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaPage extends BasePage{

	//enlace para leer una seccion en concreto
	private By localizador=By.xpath("(//div[@id=\"main-tga\"]/descendant::a[@title=\"Brian y Stewie\"])[1]");
	public WikipediaPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String getTituloArticuloBueno() {
		return driver.findElement(localizador).getAttribute("title");
	}
}
