package EpatronPOMavanzado;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleBuscadorPage extends BasePage{

	private By primerResultado=By.xpath("(//div[@id=\"rso\"]/descendant::div[@class=\"yuRUbf\"])[1]/descendant::a[1]");
	private By localizadorCookies=By.xpath("//button[@id=\"L2AGLb\"]");
	
	public GoogleBuscadorPage(WebDriver driver) {
			super(driver);
	}
	
	public void aceptarCookies() {
		driver.findElement(localizadorCookies).click();
	}
	
	
	public void clickFirstElement() {
		driver.findElement(primerResultado).click();
	}
	
	
	
}
