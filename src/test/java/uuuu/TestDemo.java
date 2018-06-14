package uuuu;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class TestDemo {
  @Test
  public void f0() {
	  System.out.println("This is  f0()");
  }
  @Test
  public void f1() {
	  System.out.println("This is  f1()");
  }
  @Test
  public void f2() {
	  System.out.println("This is  f2()");
  }
  @Test
  public void f3() {
	  System.out.println("This is  f3()");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("This is  beforeMethod()");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is  afterMethod()");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is  beforeClass()");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is  afterClass()");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is  beforeTest()");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is  afterTest()");
  }

}
