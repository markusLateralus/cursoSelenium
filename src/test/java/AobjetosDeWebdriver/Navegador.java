package AobjetosDeWebdriver;

import org.openqa.selenium.WebDriver;
/*
 * objeto Navigate
 * 
 * this.driver.navigate() con todos sus metodos.
 * 
 * 
 * */
public class Navegador {

	Driver driver;
	WebDriver.Navigation navegador;
	
	   public Navegador(Driver driver) {
		   this.driver=driver;
		   this.navegador=driver.navegador;
	   }
	   
	 //funciones de NAVEGADOR
		public void retrocedePagina() {
			navegador.back();
		}
		public void avanzaPagina() {
			navegador.forward();
		}
		public void refrescaPagina() {
			navegador.refresh();
		}
	   
	   
	   
	   
 public static void main(String[] args) {
	Driver driver=new Driver(new OpcionesDeChrome());
	 Navegador navegador=new Navegador(driver);
	 driver.ir("https://petstore.octoperf.com/actions/Catalog.action");
	 driver.ir("https://google.es");
	 navegador.retrocedePagina();
}
}
