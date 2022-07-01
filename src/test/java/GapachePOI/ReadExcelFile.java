package GapachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	
	public ReadExcelFile() {
		
	}
	
	
	//metodo para leer una hoja excel completa
	public void readExcel(String ruta, String nombreHoja) throws IOException {
		//creamos un archivo
		File file=new File(ruta);
		FileInputStream inputStream=new FileInputStream(file);
		//creamos el objeto excel
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		//creamos el objeto Hoja
		XSSFSheet hoja =workbook.getSheet(nombreHoja);
		//cuantas Filas tiene esta hoja
		int totalFilas=hoja.getLastRowNum() - hoja.getFirstRowNum();
		
		for(int i=0; i<=totalFilas; i++) {
			//creamos el objeto FILA
			XSSFRow fila=hoja.getRow(i);
			//recorremos las celdas de cada fila
			for(int j=0; j< fila.getLastCellNum(); j++) {  //suponemos que todas las filas tienen la misma cantidad de celdas
				//muestra el valor de cada celda da cada una de las filas que tenga la hoja
				System.out.println(fila.getCell(j).getStringCellValue() + "||");
			}
		}
		
	}
	
	
	//leer una celda especifica 
	public String getCellValue(String ruta, String nombreHoja, int posicionFila, int posicionCelda) throws IOException {
		//creamos un archivo
		File file=new File(ruta);
		FileInputStream inputStream=new FileInputStream(file);
		//creamos el objeto excel
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		//creamos el objeto Hoja
		XSSFSheet hoja =workbook.getSheet(nombreHoja);
		//creamos el objeto Fila en la posicion 
		XSSFRow fila=hoja.getRow(posicionFila);
		//creamos el objeto Celda en la posición pasada por parámetro
		XSSFCell celda=fila.getCell(posicionCelda);
		
		return celda.getStringCellValue();
	}
}
