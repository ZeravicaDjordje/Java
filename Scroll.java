import java.util.concurrent.TimeUnit;
import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll {
    JavascriptExecutor jse;
    WebDriver browser;
    public Scroll(WebDriver browser) {
	this.browser = browser;
	this.jse = (JavascriptExecutor)browser;
    }
    public void scroll_bottom(int skrol) {
	String stop = "None";
	int incerment = 0;
	long last_height = 0;
	long new_height = 0;
	while(incerment < skrol) {

	    final int SCROLL_PAUSE_TIME = 1;
        
	    // Get scroll height
	    last_height = (long) jse.executeScript("return document.body.scrollHeight");
	    while (incerment < skrol) {

		incerment += 1;
		String print = String.format("Scroll to bottom: %d", incerment);
		System.out.println(print);
        
		// Scroll down to bottom
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Wait to load page
		try {
		    TimeUnit.SECONDS.sleep(SCROLL_PAUSE_TIME);
		}catch(Exception  e) {
		    System.out.println(e);
		}
		// Calculate new scroll height and compare with last scroll height
		new_height = (long) jse.executeScript("return document.body.scrollHeight");
		if (new_height == last_height) {
		    if (stop.equals("None")) {
                        scroll_top();
		    }
		    break;
		}
		last_height = new_height;
	    }
	}

    }
    public void scroll(int height) {
    }
    public void scroll_top() {
	jse.executeScript("window.scrollBy(0,0)","");
    }
}
	
