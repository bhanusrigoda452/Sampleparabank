package testoprations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Login {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String chromeDriverPath = System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
	String url = "https://jqueryui.com/droppable/";
	

	@Test
	public void test01() throws InterruptedException {

	
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(url);
	Thread.sleep(5000);


	//Handling frame first
	WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));

	driver.switchTo().frame(frameElement);

	Thread.sleep(5000);

	WebElement draggable = driver.findElement(By.id("draggable"));
	WebElement droppable = driver.findElement(By.id("droppable"));

	Actions action = new Actions(driver);

	//Performing Drag and Drop operation - Way1
	action.dragAndDrop(draggable, droppable).perform();

	//Performing Drag and Drop operation - Way2
	//action.clickAndHold(draggable).moveToElement(droppable).release(droppable).perform();

	System.out.println(droppable.getText());

	Thread.sleep(2000);

	driver.quit();
	}


}
