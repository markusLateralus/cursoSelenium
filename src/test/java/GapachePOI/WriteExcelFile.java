package GapachePOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	
	
	
	//escribir una lista de datos
	public void writeExcel(String ruta, String nombreHoja, String[] datos) throws IOException {
		//creamos un archivo
		File file=new File(ruta);
		FileInputStream inputStream=new FileInputStream(file);
		//creamos la excel
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		//creamos la Hoja
		XSSFSheet hoja =workbook.getSheet(nombreHoja);
		//calculamos el total de filas que tiene la HOJA
		int totalFilas=hoja.getLastRowNum() - hoja.getFirstRowNum();
		//escribimos a partir de la última fila para no machacar lo que ya haya escrito
		//creamos el objeto Fila
		XSSFRow fila= hoja.createRow(totalFilas+1);
		for(int i=0; i<fila.getLastCellNum();i++) {
			//creamos la Celda
			XSSFCell celda=fila.createCell(i);
			celda.setCellValue(datos[i]);
		}
		
		inputStream.close();
		//escribir la información en la excel
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		
		
	}
	
	
	//escribir un valor en una celda específica
	public void writeCellValue(String ruta, String nombreHoja, int posicionFila, int posicionCelda, String texto) throws IOException {
		//creamos un archivo
		File file=new File(ruta);
		FileInputStream inputStream=new FileInputStream(file);
		//creamos la excel
		XSSFWorkbook workbook=new XSSFWorkbook(inputStream);
		//creamos la Hoja
		XSSFSheet hoja =workbook.getSheet(nombreHoja);
		//creamos el objeto Fila
		XSSFRow fila= hoja.getRow(posicionFila);
		//creamos objeto Celda 
		XSSFCell primeraCelda=fila.getCell(posicionCelda -1);
		System.out.println(primeraCelda.getStringCellValue());
		//creamos objeto Celda va a ser vacía
		XSSFCell celda=fila.createCell(posicionCelda);
		celda.setCellValue(texto);
		System.out.println(celda.getStringCellValue());
		inputStream.close();
		
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);
		outputStream.close();
		
	}
}
