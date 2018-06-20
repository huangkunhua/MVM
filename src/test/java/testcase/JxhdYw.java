package testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import uuuu.jiaoXueTestng;

public class JxhdYw {
	static Logger  logger=Logger.getLogger(JxhdYw.class);
	WebDriver driver=null;
	@Test
  public void login() {
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//医院管理员testyiyuan
		//driver.get("https://newlztest.mvwchina.com/pc/manage/index.html?token=bce9f4a746d244ebb8f10fd869ef1e28");
		//住培2.0新建管理员用户huanggl
		driver.get("http://mvw-testing.oss-cn-beijing.aliyuncs.com/cttms-ui_v4.1/pc/manage/index.html?token=f575333e62b940fd9fa8e2edeebb523c");
	}
	@Test(dependsOnMethods="login")
	public void AddHuo() throws Exception{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//教学活动
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[1]/div/div/div[37]/span[1]")));	
		
		Thread.sleep(11);
		
		//发布活动
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div[38]/div[2]/span")));
		
		//添加
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div/div[1]/div/button[2]")));
		
		//下拉菜单
		Select se1 = new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[1]/select")));
		
		se1.selectByIndex(2);
		//活动标题
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[2]/input")).sendKeys("自动发布活动院外");
		//主讲人院外
		Select se2 = new Select(driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[3]/select")));
		se2.selectByIndex(1);
		
		
		//主讲人
		driver.findElement(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/div[2]/form/div[3]/input")).sendKeys("黄药师");
		Thread.sleep(3000);
		//职称
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[4]/input[1]")).sendKeys("dsds");
		//driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[4]/input[1]")).sendKeys("副主任");
		Thread.sleep(1000);
		//单位
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[5]/input")).sendKeys("北京故宫");
		//手机号
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[6]/input")).sendKeys("18811140688");
		//证件号
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[7]/input")).sendKeys("411899889");
		//
		
		
		//人数限制：无
		js.executeScript("arguments[0].click()", driver.findElement(By.name("isLimit")));
		//人数限制，输入框		
		//driver.findElement(By.xpath("html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[10]/input")).sendKeys("500");
		//活动开始、
		js.executeScript("arguments[0].value=\"2018-5-6 15:15:20\"" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[1]/input")));
		//结束时间
		js.executeScript("arguments[0].value=\"2018-5-6 17:15:20\"" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[2]/input")));
		js.executeScript("arguments[0].click()" ,driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[1]/div/div[2]/input")));
		//iframe时间组件
		WebElement frame=driver.findElement(By.xpath("/html/body/div[2]/iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.xpath("/html/body/div/div[6]/input[3]")).click();
		driver.switchTo().defaultContent();
		
		
		//课室
		//js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[2]/label[2]/span[2]")));
		//js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[3]/label")));
		
		//Select se3= new Select(driver.findElement(By.name("classRoomId")));
		//se3.selectByIndex(1);
		
		//临时科室
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[2]/label[3]/span[1]/input")));
		driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/div[12]/div[4]/div/input")).sendKeys("临时课室8楼88");		
				
		//接收对象-全部
		js.executeScript("arguments[0].click()",driver.findElement(By.name("recObject")));
		
		//查询
		js.executeScript("arguments[0].click()", driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div[1]/div[2]/form/form/div/button")));
		
		Thread.sleep(10000);
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
	}
	@Test(dependsOnMethods="AddHuo")
	public void logOut(){
		//关闭驱动
		//driver.close();
		//关闭浏览器
		driver.quit();
		
	}
}
