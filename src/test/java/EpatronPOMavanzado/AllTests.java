package EpatronPOMavanzado;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*  Esta clase se crea mediante un JUnit Test Suite
 * 
 * */
@RunWith(Suite.class)
@SuiteClasses({ GooglePage.class, GoogleBuscadorPage.class, WikipediaPage.class }) //NO ME FUNCIONA

//por tanto  agrego la libreria JUnitNG para crear una clase que ejecute todas a la vez

public class AllTests {

}
