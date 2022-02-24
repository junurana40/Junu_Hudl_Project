package com.repository;

import org.openqa.selenium.By;

public class Locators {
	public final By Hudl_login_button = By.xpath("/html/body/div[1]/header/div/a[2]");
	public final By Hudl_login_username_validData = By.id("email");
	public final By Hudl_login_Password_validData = By.name("password");
	public final By Hudl_Click_login_button = By.id("logIn");
	public final By Hudl_login_error_msz = By.xpath("/html/body/div[2]/form[1]/div[3]/div/p/text()");
	public final By Hudl_login_checkbox = By.id("remember-me");
	public final By Hudl_Need_help_link = By.id("forgot-password-link");
}
