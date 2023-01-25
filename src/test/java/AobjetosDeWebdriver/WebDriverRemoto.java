package AobjetosDeWebdriver;


/*
 * 
 * se utiliza igual que el webdriver, salvo que la configuración inical cambia:>
 * 
 * - Necesita de un cliente y un servidor
 * 
 * - Para ejecutar el webDriver Remoto necesitamos estar conectado a un RemoteWebDriver
 * 
 *     1º configuración sencilla:
 *     
 *              FirefoxOptions firefoxOptions = new FirefoxOptions();
				WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"), firefoxOptions);
				driver.get("http://www.google.com");
				driver.quit();
  
  
  
      2º Configuración avanzada:
      
                ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.setCapability("browserVersion", "67");
				chromeOptions.setCapability("platformName", "Windows XP");
				WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"), chromeOptions);
				driver.get("http://www.google.com");
				driver.quit();
				
				
				//para realizar una transferencia de archivos entre cliente y servidor:
				
				driver.setFileDetector(new LocalFileDetector());
				
				// ...para realizar una carga de archivos:
				driver.get("http://sso.dev.saucelabs.com/test/guinea-file-upload");
				WebElement upload = driver.findElement(By.id("myfile"));
				upload.sendKeys("/Users/sso/the/local/path/to/darkbulb.jpg");
				
				
	//hay que tener habilitado el SEGUIMIENTO de las solicitudes entre cliente y servidor
  
                     estas son las bibliotecas que se pueden usar
 						* OpenTelemetry: https://opentelemetry.io
 				    	* Jaeger: https://www.jaegertracing.io
 				    	* Mensajero: https://get-coursier.io
 				    	* 
 		//.. además hay que agregar la siguiente dependencia
 				   <dependency>
      					<groupId>io.opentelemetry</groupId>
      					<artifactId>opentelemetry-exporter-jaeger</artifactId>
      					<version>1.0.0</version>
    		    	</dependency>
    				<dependency>
      					<groupId>io.grpc</groupId>
      					<artifactId>grpc-netty</artifactId>
      					<version>1.35.0</version>
    			    </dependency>
	
//...y esta sería la configuración inical
     	System.setProperty("otel.traces.exporter", "jaeger");
		System.setProperty("otel.exporter.jaeger.endpoint", "http://localhost:14250");
		System.setProperty("otel.resource.attributes", "service.name=selenium-java-client");

		ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
		WebDriver driver = new RemoteWebDriver(new URL("http://www.example.com"), capabilities);
		
		
		
		
				    
  
 * */




