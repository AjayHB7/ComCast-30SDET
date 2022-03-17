package com.crm.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * This class consist of generic methods of webdriverUtility
 * @author AJAY
 *
 */
public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	
	/**
	 * This method will wait for 20 seconds for the element to be visible
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	

	/**
	 * This method will wait for 10 seconds for am=n element to be click able
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBEClickable(WebDriver driver ,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	/**
	 * this method will wait 20 seconds for the element to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	
	/**
	 * This method will select data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	public void select(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver,WebElement src,WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst).perform();
	}
	
	/**
	 * This method will perform double click action on webelement
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick(element).perform();
	}
	
	/**
	 * This method will perform double click action on web page
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * This method will perform right click action on webelement
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
		
	}
	/**
	 * This method will perform right click on web page
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * This method will press enter key
	 * @throws Throwable
	 */
	public void enterKeyPress() throws Throwable
	{
		Robot r =new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will release enter key
	 * @throws AWTException
	 */
	public void enterKeyRelease() throws AWTException
	{
		Robot r =new Robot();
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	/**
	 * This method will switch to frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * This method will switch to frame based on name or id
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, String nameorid )
	{
		driver.switchTo().frame(nameorid);
	}
	
	/**
	 * This method will switch to frame based on webelement
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * This method will switch to parent frame
	 * @param driver
	 * @param index
	 */
	public void switchToParentFrame(WebDriver driver)
	{
		driver.switchTo().parentFrame();
	}
	
	/**
	 * This method will switch to default content
	 * @param driver
	 * @param index
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
		driver.switchTo().defaultContent();	
	}
	/**
	 * This method will accept alert popup
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * This method will switch to the window based on partialWinTitle passed
	 * @param driver
	 * @param partialWinTitle
	 */
	/*
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		
		//step 2: iterate through the windows
		Iterator<String> it = windows.iterator();
		
		//step 3: check whether there is next window
		while(it.hasNext())
		{
			// step4 : capture current window id
			String winId = it.next();
			
			// step 5 : switch to current window and capture title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();
			
			//step 6: check weather the current window matches the expected
			if(currentWinTitle.contains(partialWinTitle));
			{
				break;
			}	
		}	
	}
	*/
	
	/**
	 * This method will switch to the window based on partialWinTitle passed
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		for (String winid : windows) 
		{
			// step 2: switch to current window and capture title
			String currentwindowtitle=driver.switchTo().window(winid).getTitle();
			//step 3: check weather the current window matches the expected
			if(currentwindowtitle.contains(partialWinTitle))
			{
				break;
			}			
		}
	}
	
	/**
	 * This method will switch to window up on index 
	 * @param driver
	 * @param index
	 */
	public void switchToWindow(WebDriver driver, int index)
	{
		//step1: use getWindowHandles to capture all window ids
		Set<String> windows = driver.getWindowHandles();
		//store ids sin array list
		ArrayList<String> arraywin= new ArrayList<String>(windows);
		// switch to window up on index
		driver.switchTo().window(arraywin.get(index));
			
	}
	/**
	 * This method will take screenshot and store it in folder called as Screenshot
	 * @param driver
	 * @param screenshotname
	 * @throws IOException
	 */
	public String getScreenShot(WebDriver driver, String screenshotname) throws IOException
	{
		String path = "./Screenshot/"+screenshotname+".png";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(path);
		FileUtils.copyFile(src, dst);
		
		return dst.getAbsolutePath();
				
	}

	/**
	 * This method will scroll until the specified element is found
	 * @param driver
	 */
	public void scrollAction(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll until the specified element is found
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);
		//js.executeScript("argument[0].scrollIntoView()",element);
		
	}	
	
}
