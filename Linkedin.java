import java.io.*;
import java.util.List;
import java.util.Iterator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class Linkedin {
    public static void main(String[] args) {
	System.out.println("Test");
	WebDriver browser = Login.StartBrowser("https://www.linkedin.com");
	Scroll scroll = new Scroll(browser);
	System.out.println("Enter your Email: ");
	Scanner EmailScan = new Scanner(System.in);
	String Email = EmailScan.nextLine();
	System.out.println("Enter your Password: ");
	Scanner PasswordScan = new Scanner(System.in);
	String Email = PasswordScan.nextLine();
	MyNetwork.LogIn(Email, Password, browser);
	MyNetwork.MyConnection(browser, 0, scroll);
	MyNetwork.allConnection(browser, 5, scroll);
	Messages.sendMessage(browser);
    }
}

class Login {
    
    static void Sleep(int time)
    {
	try
	    {
	    String string = String.format("Waiting %d seconds",time);
	    System.out.println(string);
	    TimeUnit.SECONDS.sleep(time);
	}
	catch(Exception e)
	    {
		System.out.println(e);
	    }
    }
    static WebDriver StartBrowser(String url) {
	WebDriver browser = new FirefoxDriver();
	browser.get(url);
	return browser;
    }
    static void LogIn(String email, String passw, WebDriver browser) {
	WebElement Email = browser.findElement(By.id("login-email"));
	WebElement Password = browser.findElement(By.id("login-password"));
	WebElement SingIn = browser.findElement(By.id("login-submit"));
	Email.sendKeys(email);
	Password.sendKeys(passw);
	SingIn.click();
	Sleep(5);
    }
	
}

class MyNetwork extends Login {
    
    static void MyConnection(WebDriver browser, int number, Scroll scroll) {
	WebElement myConnection = browser.findElement(By.id("mynetwork-nav-item"));
	myConnection.click();
	Sleep(5);
	scroll.scroll_bottom(number);
    }
    static void allConnection(WebDriver browser, int number, Scroll scroll) {
	WebElement seeAll = browser.findElement(By.linkText("See all"));
	seeAll.click();
	Sleep(5);
	scroll.scroll_bottom(number);
	Sleep(4);
    }
    static void connectPeople(WebDriver browser){
	List<WebElement> Buttons = browser.findElements(By.tagName("span"));
	Iterator<WebElement> iter = Buttons.iterator();
	while(iter.hasNext()) {
	    try {
		WebElement Button = iter.next();
		String Text =  Button.getText();
		if(Text.equals("Connect")) {
		    String TextFormat = String.format("Click on: %s", Text);
		    System.out.println(TextFormat);
		    Button.click();
		    System.out.println("Connect");
		    Sleep(1);
		}
	    }catch(Exception e) {
	    	System.out.println(e);
	    }
	}
    }
}

class Messages extends MyNetwork {
    
    static void sendMessage(WebDriver browser) {
	List<WebElement> allMessage = browser.findElements(By.tagName("span"));
	Iterator<WebElement> iter = allMessage.iterator();
	while(iter.hasNext()) {
	    try {
		WebElement Element = iter.next();
		String Text = Element.getText();
		if(Text.equals("Message")) {
		    String Output = String.format("Send message to: %s", Text);
		    System.out.println(Output);
		    all.Message
		}
	    }catch(Exception e) {
		System.out.print("Error");
	    }
	}
    }
}
	
		
						  

	
