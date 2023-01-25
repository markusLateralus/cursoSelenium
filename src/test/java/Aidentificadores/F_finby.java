package Aidentificadores;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/*
 * tenemos 5 formas importantes de obtener el webElement
 * 
 * 
 * 
 * 
 * */
public class F_finby {

@FindBy(xpath="//*[@id=\"main-content\"]/section[1]/div/article/div/p[5]/u/font/font")
static WebElement campoPassword;
@FindBy(css="")
static WebElement botonLogin;
@FindBy(linkText="pulsa el enlace")//<a class="" name="">pulsa el enlace <a/> 
static WebElement enlace1;
@FindBy(name="nombre_usuario")//<input class="", name="nombre_usuario"/>
static WebElement boton3;
@FindBy(className="page-create")//<input class="page-create", name=""/>
static WebElement boton4;
		
		
//comprobar si un elemento existe
public boolean existeWebElement(WebElement element) {
	boolean existe=element.isDisplayed();
	return existe;
}
		
		
}
