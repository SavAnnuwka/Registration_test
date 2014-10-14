package main.java;


import org.testng.annotations.*;

import java.io.FileReader;
import java.util.Properties;

import java.util.logging.Logger;



public class testBase {
    
	protected Logger log = Logger.getLogger("Common_logger");
	
	public static ApplicationManager app;
	

	@BeforeClass
	public void setUp( ) throws Exception {
        String	configFile = "application.properties";
		Properties props = new Properties();
		props.load(new FileReader(configFile));
		 log.info("setUp start");
		 app =  ApplicationManager.getInstance();
		 app.setProperties(props);
		 log.info("setUp end");
	  }
	
	@AfterClass
	public void tearDown() throws Exception {
        System.out.println("tearDown start");
		 log.info("tearDown start");
        ApplicationManager.getInstance().getWebDriverHelper().stop();
		 log.info("tearDown end");
        System.out.println("tearDown stop");

	  }
	


}

	