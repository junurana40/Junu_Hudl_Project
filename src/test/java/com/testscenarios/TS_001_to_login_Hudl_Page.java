package com.testscenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.repository.Locators;
import com.utilities.GenericWrapper;

public class TS_001_to_login_Hudl_Page extends GenericWrapper {
	Locators loc = new Locators();
	
  @Test
  public void Tc_001_to_navigate_to_Hudl_website() {
	  launchChromeBrowser();
	  driver.get("https://www.hudl.com/");
	  implicitWait(4000);
	  
  }
  @Test
  public void Tc_002_verify_login_Page_hyperlink() {
	  ValidateWebelementIsEnabledOrNot(loc.Hudl_login_button);
  }
 @Test
 public void Tc_003_To_click_login_button() {
	 clickByAnylocator(loc.Hudl_login_button);
	 implicitWait(3000);
	 
 }
 
 @Test
 public void Tc_005_verify_user_login_to_hudl_with_valid_Data() {
	 clickByAnylocator(loc.Hudl_Click_login_button);
	 implicitWait(3000);
	 sendKeyByAnyLocator(loc.Hudl_login_username_validData, getData("username"));
	 implicitWait(3000);
	 sendKeyByAnyLocator(loc.Hudl_login_Password_validData, getData("password"));
	 implicitWait(3000);
	 
  }
 @Test
 public void Tc_006_verify_checkbox() {
	 Actions act = new Actions(driver);
	 act.moveToElement(driver.findElement(By.id("remember-me"))).click().perform();
	 
	 //clickByAnylocator(loc.Hudl_login_checkbox);
	 implicitWait(3000);
 }
 @Test
 public void Tc_007_click_login_Button() {
	  clickByAnylocator(loc.Hudl_Click_login_button);
 }
 
 @BeforeTest
 public void beforeTest() {
	  loadTestData("./src/test/resources/inputdata.properties");
 }
}
