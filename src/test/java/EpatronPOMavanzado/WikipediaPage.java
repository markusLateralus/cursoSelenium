package EpatronPOMavanzado;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikipediaPage extends BasePage{

	//enlace para leer una seccion en concreto
	private By localizador=By.xpath("(//div[@id=\"main-tga\"]/descendant::a[@title=\"Brian y Stewie\"])[1]");
	private By inputs=By.tagName("input");
	public WikipediaPage(WebDriver driver) {
		super(driver);
	}
	
	
	public String getTituloArticuloBueno() {
		return driver.findElement(localizador).getAttribute("title");
	}

	public void verifcarTituloDeArticuloBueno(String titulo) {
		assertEquals(titulo, this.getTituloArticuloBueno());
	}
	
	public void verificarTotalInputs(int total) {
		List<WebElement>totalInputs=driver.findElements(inputs);
		System.out.println("total inputs: " +totalInputs.size() );
		assertTrue(totalInputs.size()==total);
	}

}

