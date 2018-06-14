package uuuu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class KaoShi {
  @Test
  public void login() {
	  WebDriver driver = new FirefoxDriver();
	  JavascriptExecutor  js = (JavascriptExecutor) driver;
	 // js.executeScript("argements[0].", );
  }
}
