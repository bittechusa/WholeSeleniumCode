package com;

import static org.testng.Assert.assertNotSame;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.interactions.internal.Locatable;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Play 
{
	WebDriver dr;
	WebElement element;
	String text;
	boolean result;
	List<WebElement> elements;
	Set<String> windows;
	Options option;
	Navigation nevigate;
	TargetLocator locate;
	@Test
	public void test1()
	{
		//Method from driver
		dr.close();//to close focus window
		dr.quit();//to clocse whole instance
		dr.get("");//go to url
		element=dr.findElement(By.id(""));//to find any element
		elements=dr.findElements(By.id(""));//to find more than one element
		text=dr.getPageSource();//to get source code of html page
		text=dr.getTitle();//to get the title
		text=dr.getCurrentUrl();//to get the current url of page
		text=dr.getWindowHandle();//to get parent window
		windows=dr.getWindowHandles();//to get all child window
		 option=dr.manage();
		 nevigate=dr.navigate();
		 locate=dr.switchTo();
		
		
		//method from Webelement
		 element.clear();//to clear text boix
		 element.click();//to click on element
		 element.findElement(By.id(""));//to find an element under another element
		 element.getAttribute("id");//to get the attribute value
		 element.getCssValue("");//to get the cssValue
		 element.getLocation().getX();//to get x coordinate size
		 element.getLocation().getY();//to get y coordinate size
		 File f=element.getScreenshotAs(OutputType.FILE);//to take screen shot
		 element.getTagName();//to know the tag name to create particuler element
		 element.getText();//to get the text from element
		 element.getSize();////to get the size of Dimension
		 result=element.isDisplayed();//to check element is present or not in webPage
		 result=element.isEnabled();//to check element is enabled or not
		 result=element.isSelected();//to check checkbox is selected or
		 element.sendKeys("");//to type on text box
		 element.submit();//to click on element without click
		
		//method from Select
		 Select s=new Select(element);
		 s.selectByIndex(0);//to get drop down option by index
		 s.selectByValue("");//to get drop down option by text from DOM
		 s.selectByVisibleText("");//to get drop down option by visible text value from UI
		 s.getFirstSelectedOption();//to get first option from drop down without parameter
		 elements=s.getOptions();
		 elements.size();
		 elements=s.getAllSelectedOptions();
		 //note from select class any method u have for select there are all methods for deselect also
		 
		//method from dr.switchTo();
		 Alert alert=dr.switchTo().alert();
		 alert.accept();
		 alert.dismiss();
		 alert.getText();
		 alert.sendKeys("ngf");
		 
		 /*Automation challenge
		 if we see customized button in alert box like done dismiss etc selenium cannot
		 handle this for that we need third party API called Sikulli and Robot Class ,
		 this two api can handle any desktop 
		base application and viseo as well.*/
		
		 //iframe
		dr.switchTo().frame(0);
		dr.switchTo().frame("");
		dr.switchTo().frame(element);
		dr.switchTo().defaultContent();
		dr.switchTo().parentFrame();
		
		//Automation challenge
		//To handle multiple frame is not easy
		
	
		//method from Actions
		Actions a=new Actions(dr);
		a.click();//to click
		a.click(element);//to click on element
		a.clickAndHold();
		a.clickAndHold(element);
		a.contextClick();//right click
		a.contextClick(element);//right click on element
		a.doubleClick();//double click
		a.dragAndDrop(element, element).build().perform();;
		a.dragAndDropBy(element, 200, 500).build().perform();
		a.keyDown(Keys.ARROW_DOWN);//scroll down
		a.moveToElement(element).build().perform();//hover over
		a.sendKeys(Keys.ENTER);//to click from Enter button from keyboard

		
		//method from dr.nevigate()
		dr.navigate().back();
		dr.navigate().forward();
		dr.navigate().refresh();
		dr.navigate().to("http://www.google.com");
		
		
		
		 //methods from dr.manage()
		//to handle cookies of webPage
		Cookie c=dr.manage().getCookieNamed("");
		dr.manage().addCookie(c);
		Set<Cookie> cookies=dr.manage().getCookies();
		dr.manage().deleteCookie(c);
		dr.manage().deleteAllCookies();
		
		//window specific
		dr.manage().window().fullscreen();
		dr.manage().window().maximize();
		dr.manage().window().getSize();
		
		dr.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);//its for
		//whole UI and it wait upto given time
		
		
		//Method from JavascriptExecutor,ScrrenShot,KeyBoard,Keys,HasInputDevices,Coordinates
		JavascriptExecutor js=(JavascriptExecutor)dr;
		js.executeScript("window.scrollBy(100, 0)");
		js.executeScript("document.getElementById('email').click()");
		// JavascriptExecutor is an interface using this we can perform all action which we can
		//do using selenium 
		
		File f1=((TakesScreenshot)dr).getScreenshotAs(OutputType.FILE);
		
		Coordinates co=((Locatable)element).getCoordinates();
		co.inViewPort();
		
		Keyboard k=((HasInputDevices)dr).getKeyboard();
		k.sendKeys(Keys.chord(Keys.COMMAND,Keys.SHIFT,"p"));
	
		//ExplicitWait
		
		waitForElement(element).click();
		
		
	
	}
	
	public WebElement waitForElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}
	
	public ExpectedCondition<WebElement> waitForElement1(WebElement element)
	{
		FluentWait wait=new FluentWait(dr);
		return ExpectedConditions.visibilityOf(element);
		
	}
	
	
	public void junitPractice()
	{
		//before vs beforeClass
		//some annotation  @Test,@Before,@After,@BeforeClass,@AfterClass,@Ignore, 
		//@RunWith.@Parameter,@suite
		//important class  Assertion--assertEqual(),assertTrue().assertFalse();
	}
	public void testNGPract()
	{
		/*//why testNg is better than Junit
		ANS: More Annotation,Have more Control over project using Testng.xml file
		has lots of parameter,can perform datadriver testing using @DataProvider
		has TestListner,has IReporter,can run only failed test, builtin report
		can be run by group wise, suitewise testwise methodwise
		parameter annotation for read xml
		can perform parallel test*/
	}
	public void mavenprac()
	{
		/*maven life cycle
		verify,  compile, test, package, install
		what is .m2 folder---> local repository
		what u can add in pom--> dependecies and plugin and properties
		surefire plugin for report
		maven compiler plugin to compile project*/
	}
	
	public void gitPrac()
	{
		//git status
		//git log  git blame, git revert,git branch branchname
		//git checkout branchname
		//git stash, git diff 
		/*what was the process of git
		we use branching concept
		i had my own branch where i wrote code
		then i push into my branch then create a pull request to reviewr
		thrn reviewer will review the if code is ok then my job is done
		otherwise i have to do same process again*/
	}
	
	public void gridPrac()
	{
		/*start hub
		register node
		write code using DesiredCapabilities class
		Define RemoteWebdriver class
		configure testng.xml file to run test case parallaly*/
	}
	
	
	
	
	
	
	
	
	

}
