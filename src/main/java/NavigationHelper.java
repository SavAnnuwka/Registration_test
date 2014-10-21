package main.java;


import org.openqa.selenium.By;

public class NavigationHelper extends HelperWithWebDriverBase {
	

	public NavigationHelper(ApplicationManager manager){
		super(manager);
		}
	
	
	public void goToGroupListPage() {
		clickByLink(By.linkText("groups"));
	}

	//open main page
	public void openMainPage() {		
		openUrl(app.getProperty("baseUrl"));
	}


}
