package com.fast.automation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FastAutomation {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("----start-maximized");
		
		WebDriver wd = new ChromeDriver(options);
		wd.get("https://fast.com/");
		
		WebDriverWait wait = new WebDriverWait(wd,Duration.ofSeconds(20));
		
		By SpeedValueLocator = By.id("speed-value");
		By SpeedUnitLocator = By.id("speed-units");
		
		String className;
		
		while(true) {
		WebElement speedValueElement=wait.until(ExpectedConditions.visibilityOfElementLocated(SpeedValueLocator));	
		WebElement speedUnitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(SpeedUnitLocator));
		
		System.out.println(speedValueElement.getText()+" " +speedUnitElement.getText());
		
		
		className = speedValueElement.getAttribute("class");
		if(className!= null && className.contains("succeeded")) {
			
			break;
		}
			
		}
			
		WebElement speedValueElement=wait.until(ExpectedConditions.visibilityOfElementLocated(SpeedValueLocator));	
		WebElement speedUnitElement=wait.until(ExpectedConditions.visibilityOfElementLocated(SpeedUnitLocator));
		System.out.println("------Final Speed");
		System.out.println(speedValueElement.getText()+" " +speedUnitElement.getText());
		
		
	}

}
