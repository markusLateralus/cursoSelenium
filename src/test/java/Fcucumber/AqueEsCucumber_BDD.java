
/*  - Qué es BDD   Behavios Driven Development--> desarrollo guiado por comportamientos.
 * 
 *  Si en TDD(Test Driven Develelopment,enfocada en pruebas unitarias) buscamos la validación de una acción concreta, 
 *    en BDD (enfoada a los tests funcionales) tratamos de abstraernos un poco más y validar un flujo mínimo concreto.
 * 
 *  Nos ofrece el lenguaje Gherkin entre la parte de negocio y la parte técnica.
 * 
 *  Se han de seguir tres pasos: Given, When, Then.
 *  
 *  	Feature: Titulo de las pruebas que se van a realizar.
 *      Scenario: Una prueba en concreto.
 *  		Given: dada una situación inicial
 *  		When: realizando una acción en concreto.
 *  		Then: Obtenemos un resultado esperado.
 *  
 *  
 *  - Agregar 3 librerias en el pom.xml. Nos descargamos las librerías "io.cucumber"
 * 		1º cucumber JVM: JUnit.
 *      2º cucumber JVM: Java8 (viene con expresiones lamba)
 *      3º cucumber JVM: Core.
 *      
 *   - En caso de tener las librerías JUnit y el plugin Maven en el pom.xml, las eliminaremos
 *      
 *      
 * - Implementar Cucumber:
 * 
 *  El objetivo es describir las pruebas con un lenguaje cercano al humano.
 *  Creamos una capa intermedia llamada "glue", que es el enlace entre Gherkin y la Implementación o "steps".
 *  
 *  Dentro del proyecto debemos crear 3 ficheros independientes:
 *      1º fichero Feature: Donde describimos los pasos en Gherkin.
 *      2º fichero Steps: Clase Java donde se implementa la lógica de cada una de las sentencias descritas en Gherkin.
 *      3º fichero Runner: Clase Java donde se implementa Cucumber y JUnit. Maven llamará esta clase par ejecutar las pruebas.
 *      
 *  Ubicación de los ficheros (por convenio, pero no oblligatorio):
 *      1º Feactures en src/test/resources/feactures.
 *      2º Steps     en src/test/java/steps.
 *      3º Runners   en src/test/java/runners.
 *  
 *  para saber más sobre los parámetros de ejecución de cucumber:    
 *  https://cucumber.io/docs/cucumber/api/ASTERISCOlist-configuration-options
 *     
 *   
 * */

