package base;



import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class DriverBase {
	//启动浏览器
	private static WebDriver driver;
	//提供一个外部获得driver的方法
	public WebDriver getDriver(){
		return driver;
	}
	//构造方法
	public DriverBase(){
		driver = new FirefoxDriver();
		PageFactory.initElements(driver, this);
	}	
	//关闭浏览器
	public void close(){
		driver.close();
	}
	//打开网址get封装
	public void openUrl(String url){
		driver.get(url);
	}
	//定位元素封装Element方法
	public WebElement findElement(By by){
		WebElement element = driver.findElement(by);
		return element;
	}
	//窗口最大化
	public void maxSize(){
		driver.manage().window().maximize();
	}
	
	//职能等待
	
	public void waitForElementToLoad(int timeOut, final By By) {       
		try {
		(new WebDriverWait(driver, timeOut)).until(new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
		WebElement element = driver.findElement(By);
		return element.isDisplayed();
		}
		});
		} catch (TimeoutException e) {
		Assert.fail("超时!! " + timeOut + " 秒之后还没找到元素 [" + By + "]",e);
		}
		}

	

	
}
