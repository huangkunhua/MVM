package uuuu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class wett {
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getLogger(wett.class);
		PropertyConfigurator.configure(".\\Log4j.properties");
		//System.setProperty("webdriver.firefox.bin", "D:/Program Files (x86)/Mozilla Firefox/firefox.exe");
		//DesiredCapabilities capa=DesiredCapabilities.firefox();
		//capa.setCapability("firefox_binary", "D:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		WebDriver  driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//driver.manage().window().setSize(new Dimension(1000, 1000));
		driver.get("http://mvw-testing.oss-cn-beijing.aliyuncs.com/cttms-ui/pc/manage/index.html?token=3f2edd03b65746ba9bcb75e686c6d339");
		//((JavascriptExecutor)driver).executeScript("window.scrollTo(0,1000);");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//教学活动
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div[37]/span[1]")));	
		
		Thread.sleep(10);
		
		//发布活动
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div[38]/div[2]/span")));
		
		//添加
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div[1]/div/button[2]")));
		
		//下拉菜单
		Select se1 = new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[1]/select")));
		
		se1.selectByIndex(2);
		
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[2]/input")).sendKeys("自动发布活动1");
		//院内院外
		Select se2 = new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[3]/select")));
		se2.selectByIndex(0);
		//自动刷选师资库
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[3]/input")).sendKeys("小");
		Thread.sleep(5);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//li[@data-id='0']")));
		//人数限制：无
		js.executeScript("arguments[0].click()", driver.findElement(By.name("isLimit")));
		//活动开始、
		js.executeScript("arguments[0].value=\"2018-5-20 17:15:20\"" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[1]/input")));
		//结束时间
		js.executeScript("arguments[0].value=\"2018-5-21 17:15:20\"" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[2]/input")));
		js.executeScript("arguments[0].click()" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[2]/input")));
		//iframe时间组件
		WebElement frame=driver.findElement(By.xpath("/html/body/div[2]/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div/div[6]/input[3]")).click();
		driver.switchTo().defaultContent();
		
		
		//课室
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[2]/label[2]/span[2]")));
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[3]/label")));
		
		Select se3= new Select(driver.findElement(By.name("classRoomId")));
		se3.selectByIndex(1);
		//接收对象-全部
		driver.findElement(By.name("recObject")).click();
		//查询
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/form/div/button")).click();
		Thread.sleep(5000);
		//添加选定-全选
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/table[2]/tr/th/input")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/h4[1]/button")).click();
		//选定已选人员，保存
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[3]/div/div[1]/div/table[2]/tr/th/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/div[4]/input[1]")).click();
		
		Thread.sleep(5000);
		//活动保存成功，选择活动-发布
		js.executeScript("arguments[0].click()",driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div/div[3]/div/div[2]/table[2]/tbody/tr[2]/td[1]/input")));		
		//发布活动按钮注释掉
		//driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div[1]/div/button[4]")).click();
		//关闭浏览器
		driver.quit();
		logger.info("活动保存成功");
		logger.error("活动保存成功,但是没有发布");
	}
	
}
