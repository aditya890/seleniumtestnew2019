
package com.actitime.test;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.actitime.genericlib.FileLib;

public class CreateCustomerTest {

	public static void main(String[] args) throws Throwable {
		FileLib lib=new FileLib();
		String URL=lib.getPropertykeyValue("url");
		String UserName=lib.getPropertykeyValue("username");
		String passwd=lib.getPropertykeyValue("password");
		
		// read the test Data
		 String CustomerName=lib.getExcelData("sheet1", 1, 4);
		 //step1:login to app
		 WebDriver driver=new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.get(URL);
		 driver.findElement(By.name("username")).sendKeys(UserName);
		 driver.findElement(By.name("pwd")).sendKeys(passwd);
		 driver.findElement(By.id("loginButton")).click();
		 
		 Thread.sleep(5000);
		 
		 //step2:navigate to Task page
		 driver.findElement(By.xpath("//div[text()='TASKS']")).click();
		 
		 //step3: navigate to customer page
		 driver.findElement(By.xpath("//a[text()='Projects & Customers']")).click();
		 
		 /*click on  create customer button*/
		 // step4:create customer
		 driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		 
		 driver.findElement(By.id("customerLightBox_nameField")).sendKeys(CustomerName);
		 
		 Thread.sleep(3000);
		 
		 driver.findElement(By.xpath("//span[text()='Create Customer']")).click();
		 // step5: verify
		 
		String explMsg="has been successfully created";
		
		String actMsg=driver.findElement(By.xpath("//span[@class='successmsg']")).getText();
		
		if(actMsg.contains(explMsg)) {
		System.out.println("pass");
		}
		else
		{
			System.out.println("Fail");
		}
		 
		 
		 
		 }

}
