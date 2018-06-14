package testcase;

import org.testng.annotations.Test;

import base.DriverBase;
import pages.TeachingActivities;
import utils.LogConfiguration;
import uuuu.jiaoXueTestng;

public class NewTest {
  @Test
  public void f() throws Exception {
	  
	  //LogConfiguration.initLog(NewTest.class.getName());
	  
	String url="http://mvw-testing.oss-cn-beijing.aliyuncs.com/cttms-ui/pc/manage/index.html?token=3f2edd03b65746ba9bcb75e686c6d339";
	  DriverBase db = new DriverBase();
	  db.maxSize();
	  db.openUrl(url);
	  //jiaoXueTestng jx= new jiaoXueTestng();
	 // jx.login();
	 // jx.AddHuo();
	 // jx.logOut();
	  TeachingActivities  teach = new TeachingActivities();
	  teach.AddHuo();
	  
  }
}
