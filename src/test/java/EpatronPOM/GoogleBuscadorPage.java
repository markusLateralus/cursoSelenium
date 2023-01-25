package EpatronPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleBuscadorPage extends BasePage{

	private By primerResultado=By.xpath("(//div[@id=\"rso\"]/descendant::div[@class=\"yuRUbf\"])[1]/descendant::a[1]");
	
	public GoogleBuscadorPage(WebDriver driver) {
			super(driver);
	}
	

	public void clickFirstElement() {
		driver.findElement(primerResultado).click();
	}
	
	
	
}
