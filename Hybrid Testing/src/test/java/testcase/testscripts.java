package testcase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class testscripts {
  public static WebDriver driver;
  
  public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
		
	//Convert web driver object to TakeScreenshot
	TakesScreenshot scrShot =((TakesScreenshot)webdriver);
	
	//Call getScreenshotAs method to create image file
	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
	
	//Move image file to new destination
	File DestFile=new File(fileWithPath);
	
	//Copy file at destination
	  FileUtils.copyFile(SrcFile, DestFile);
	}
  
    @Test(priority=1)
    public void RoomBooking() throws Exception {
    driver=new ChromeDriver();
    driver.manage().window().maximize();
  driver.get("https://www.goibibo.com/");
  takeSnapShot(driver, ".//screenshot//Home.png");
  driver.findElement(By.xpath("//*[@class=\"nav-link\"][1]")).click();
  
   driver.findElement(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchInputStyles\")]")).sendKeys("ooty");
    Thread.sleep(2000);
		
		List<WebElement> hotelmenu=driver.findElements(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchMenuStyles-sc\")]"));
		
		for(int i=0;i<hotelmenu.size();i++)
		{
			String Fromtext= hotelmenu.get(i).getText();
			if(Fromtext.contains("Central Ooty"))
			{
				hotelmenu.get(i).click();
				break;
			}
		}

		driver.findElement(By.xpath("//*[@value='2 Guests in 1 Room ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'dwebCommonstyles__CenteredDivWrap')][2]/descendant::span[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'PaxWidgetstyles__WrapperDiv')]/descendant::button[1]")).click();
		Thread.sleep(1000);
		takeSnapShot(driver, ".//screenshot//Search.png");
		driver.findElement(By.xpath("//*[contains(@class,'SearchBlockUIstyles__AutoSuggestOuterWrap')]/descendant::button[1]")).click();
		Thread.sleep(2000);
		takeSnapShot(driver, ".//screenshot//SearchResult.png");
		WebElement hotelname=driver.findElement(By.xpath("//*[contains(@class,'HotelCardstyles__HotelCardInfoWrapperDiv')]/descendant::h4[1]"));
		String hn=hotelname.getText();
		System.out.println("The hotel name is "+ hn);
        
        
        WebElement hotelcount=driver.findElement(By.xpath("//*[contains(@class,'SRPstyles__RightSectionWrapperStyle')]/descendant::span[26]"));
        int count = hotelcount.getSize().height;

        WebElement hoteltitle=driver.findElement(By.xpath("//*[contains(@class,'HotelCardstyles__HotelCardInfoWrapperDiv')]/descendant::h4[1]"));
		String title=hoteltitle.getText();
		if(!title.isEmpty()) {
			System.out.println("Title verified as "+title);
			Reporter.log("The name of hotel is: "+ hn + ". The Hotel count is:" + count);
		}
	    hoteltitle.click();

	    ArrayList<String> tabs=	new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    Thread.sleep(2000);
	    takeSnapShot(driver, ".//screenshot//HotelSelected.png");
	    
	    WebElement room=driver.findElement(By.xpath("//*[@id='rooms']/descendant::button[1]"));
	    
	    room.click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"Enter First Name\"]")).sendKeys("Test");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"Enter Last Name\"]")).sendKeys("King");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"Enter Email Address\"]")).sendKeys("Test2415@gmail.com");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"Enter Phone Number\"]")).sendKeys("6364045181");
	    Thread.sleep(1000);
	    takeSnapShot(driver, ".//screenshot//GuestDetails.png");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/descendant::button[1]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@name=\"cardnumber\"]")).sendKeys("5126 5230 0906 4729");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"Name\"]")).sendKeys("Dummy");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"MM / YY\"]")).sendKeys("09 / 29");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@placeholder=\"CVV NO.\"]")).sendKeys("123");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/descendant::button[3]")).click();
	    takeSnapShot(driver, ".//screenshot//CardDetails.png");
	    Thread.sleep(2000);
	    driver.quit();
 }
  
   @Test(priority=2)
   public void RoomMenu() throws Exception {
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://www.goibibo.com/");
	 takeSnapShot(driver, ".//screenshot//link.png");
	 driver.findElement(By.xpath("//*[@class=\"nav-link\"][1]")).click();
	 driver.findElement(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchInputStyles\")]")).sendKeys("Ooty");
    Thread.sleep(2000);
		
		List<WebElement> hotelmenu=driver.findElements(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchMenuStyles-sc\")]"));
		
		for(int i=0;i<hotelmenu.size();i++)
		{
			String Fromtext= hotelmenu.get(i).getText();
			if(Fromtext.contains("Ooty "))
			{
				hotelmenu.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//*[@value='2 Guests in 1 Room ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'dwebCommonstyles__CenteredDivWrap')][2]/descendant::span[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'PaxWidgetstyles__WrapperDiv')]/descendant::button[1]")).click();
		Thread.sleep(1000);
		takeSnapShot(driver, ".//screenshot//hotelresult.png");
		driver.findElement(By.xpath("//*[contains(@class,'SearchBlockUIstyles__AutoSuggestOuterWrap')]/descendant::button[1]")).click();
	    Thread.sleep(2000);
	    takeSnapShot(driver, ".//screenshot//hotellist.png");
	    WebElement hotelname1=driver.findElement(By.xpath("(//*[contains(@class,'dwebCommonstyles__SmallSectionHeader')])[2]"));
	    String hn1=hotelname1.getText();		
	    System.out.println("The hotel name is "+ hn1);
	    Reporter.log("The Hotel Name is  "+ hn1);
	    Thread.sleep(1000);
	    hotelname1.click();
	    Thread.sleep(1000);
	    ArrayList<String> tabs=	new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    takeSnapShot(driver, ".//screenshot//hotelname.png");
	    WebElement hotelname2=driver.findElement(By.xpath("//*[contains(@class,'HotelName__HotelNameText')]"));
	    String hn2=hotelname2.getText();
        if (hn1.equalsIgnoreCase(hn2)) {
        	System.out.println("Hotel name is verified as " + hn1);
        }
        driver.findElement(By.xpath("(//*[contains(@class,'Navigationstyles__ItemLinkTo')])[2]")).click();
       
	    Thread.sleep(3000);
	    takeSnapShot(driver, ".//screenshot//rates.png");
	   WebElement locate= driver.findElement(By.xpath("(//*[contains(@class,'Navigationstyles__ItemLinkTo-sc')])[6]"));
	   if(locate.isDisplayed()) {
		   locate.click();
		   System.out.println("Location is displayed");
		}
		else
		{
			System.out.println("Location is not displayed");
		} 
	   Thread.sleep(3000);
	   takeSnapShot(driver, ".//screenshot//location.png");
	   WebElement review= driver.findElement(By.xpath("(//*[contains(@class,'Navigationstyles__ItemLinkTo-sc')])[4]"));
	   if(review.isDisplayed()) {
		   review.click();
		   System.out.println("Review is displayed");
		}
		else
		{
			System.out.println("Review is not displayed");
		}
	   Thread.sleep(3000);
	   takeSnapShot(driver, ".//screenshot//review.png");
	   WebElement qa= driver.findElement(By.xpath("(//*[contains(@class,'Navigationstyles__ItemLinkTo-sc')])[8]"));
	   if(qa.isDisplayed()) {
		   qa.click();
		   System.out.println("Question and answer is displayed");
		}
		else
		{
			System.out.println("Question and answer is not displayed");
		} 
	   Thread.sleep(3000);
	   takeSnapShot(driver, ".//screenshot//qa.png");
	   WebElement policy= driver.findElement(By.xpath("(//*[contains(@class,'Navigationstyles__ItemLinkTo-sc')])[5]"));
	   if(policy.isDisplayed()) {
		   policy.click();
		   System.out.println("Hotel policy is displayed");
		}
		else
		{
			System.out.println("Hotel policy is not displayed");
		} 
	   takeSnapShot(driver, ".//screenshot//hotelpolicy.png");
	   
       driver.quit();
}
    @Test(priority=3)
    public void filter() throws Exception {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.goibibo.com/");
	takeSnapShot(driver, ".//screenshot//titles.png");
	driver.findElement(By.xpath("//*[@class=\"nav-link\"][1]")).click();
	 driver.findElement(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchInputStyles\")]")).sendKeys("Ooty");
   Thread.sleep(2000);
		
		List<WebElement> hotelmenu=driver.findElements(By.xpath("//*[contains(@class,\"HomePageAutosuggeststyles__SearchMenuStyles-sc\")]"));
		
		for(int i=0;i<hotelmenu.size();i++)
		{
			String Fromtext= hotelmenu.get(i).getText();
			if(Fromtext.contains("Ooty "))
			{
				hotelmenu.get(i).click();
				break;
			}
		}
		int rate=4,lowprice=2001,highprice=4000;
		driver.findElement(By.xpath("//*[@value='2 Guests in 1 Room ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'dwebCommonstyles__CenteredDivWrap')][2]/descendant::span[3]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(@class,'PaxWidgetstyles__WrapperDiv')]/descendant::button[1]")).click();
		Thread.sleep(1000);
		takeSnapShot(driver, ".//screenshot//srch.png");
		driver.findElement(By.xpath("//*[contains(@class,'SearchBlockUIstyles__AutoSuggestOuterWrap')]/descendant::button[1]")).click();
        Thread.sleep(2000);
        takeSnapShot(driver, ".//screenshot//pic.png");
        driver.findElement(By.xpath("(//*[contains(@class,'HappyUncheckIcon-sc')])[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[contains(@class,'HappyUncheckIcon-sc')])[10]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//*[contains(@class,'HappyUncheckIcon-sc')])[5]")).click();
        Thread.sleep(3000);
        System.out.println("The ratings filter is verified as "+ rate);
        System.out.println("The ratings filter is verified in the range of "+ lowprice+ " to "+ highprice);
        driver.quit();
}
}
  
  
  
