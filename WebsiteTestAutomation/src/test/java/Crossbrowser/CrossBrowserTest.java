package Crossbrowser;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CrossBrowserTest {
	WebDriver driver;
	FirefoxOptions firefoxoptions=new FirefoxOptions();
	ChromeOptions chromeoptions=new ChromeOptions();
	EdgeOptions edgeoptions= new EdgeOptions();
	@Parameters("browser")
	@BeforeTest
	public void initialize(String browser) 
	{
		  if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver(firefoxoptions);
            System.out.println("Firefox is launched");
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeoptions);
            System.out.println("Chrome is launched");
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver(edgeoptions);
            System.out.println("Edge is launched");
        }
		    driver.manage().window().maximize();
		
	}
	
    @Test
    public void gfgTest() {
        driver.get("https://www.geeksforgeeks.org/");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("GeeksforGeeks"), "Title does not contain 'GeeksforGeeks'");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

     // Wait for the cookie consent to disappear
     wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cookie-consent")));

        
      

        try {
            System.out.println("Navigating to DSA");
            // Wait for the DSA link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Data Structures"))).click();

            // Scroll down the page
            System.out.println("Scrolling down");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

            // Wait for a moment to observe the scroll
            Thread.sleep(2000); // Optional: pause for visibility (can be removed later)

            // Scroll back up
            System.out.println("Scrolling back up");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
        } catch (NoSuchElementException e) {
            System.err.println("DSA link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        try {
            // Scroll to the bottom of the page slowly
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int scrollPause = 100; // milliseconds to wait between scroll increments
            int scrollHeight = 500; // total scroll height to reach the bottom
            for (int i = 0; i < scrollHeight; i += 50) { // scroll down in increments of 50 pixels
                js.executeScript("window.scrollBy(0, 50);");
                Thread.sleep(scrollPause); // Pause for the scrolling effect
            }

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top slowly
            for (int i = scrollHeight; i > 0; i -= 50) { // scroll up in increments of 50 pixels
                js.executeScript("window.scrollBy(0, -50);");
                Thread.sleep(scrollPause); // Pause for the scrolling effect
            }

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
        }

        
        
        
        
        try {
            System.out.println("Navigating to String in Data Structure");
            // Wait for the DSA link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("String in Data Structure"))).click();

            // Scroll down the page
            System.out.println("Scrolling down");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 500);");

            // Wait for a moment to observe the scroll
            Thread.sleep(2000); // Optional: pause for visibility (can be removed later)

            // Scroll back up
            System.out.println("Scrolling back up");
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -500);");
        } catch (NoSuchElementException e) {
            System.err.println("String in Data Structure link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        
        try {
            // Scroll to the bottom of the page slowly
            JavascriptExecutor js = (JavascriptExecutor) driver;
            int scrollPause = 100; // milliseconds to wait between scroll increments
            int scrollHeight = 500; // total scroll height to reach the bottom
            for (int i = 0; i < scrollHeight; i += 50) { // scroll down in increments of 50 pixels
                js.executeScript("window.scrollBy(0, 50);");
                Thread.sleep(scrollPause); // Pause for the scrolling effect
            }

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top slowly
            for (int i = scrollHeight; i > 0; i -= 50) { // scroll up in increments of 50 pixels
                js.executeScript("window.scrollBy(0, -50);");
                Thread.sleep(scrollPause); // Pause for the scrolling effect
            }

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
        }

        
        
        try {
            System.out.println("Scrolling up");
            // Scroll up the page
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500);");

            System.out.println("Navigating to Introduction to Strings – Data Structure and Algorithm Tutorials");
            // Wait for the Web Technologies link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Introduction to Strings – Data Structure and Algorithm Tutorials"))).click();
        } catch (NoSuchElementException e) {
            System.err.println("Introduction to Strings – Data Structure and Algorithm Tutorials link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to tutorial: " + e.getMessage());
        }
        
        
        
        try {
            // Scroll to the bottom of the page using JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top of the page
            js.executeScript("window.scrollTo(0, 0);");

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
            
            
        }
        
        
        
        
        
        try {
            System.out.println("Scrolling up");
            // Scroll up the page
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500);");

            System.out.println("Navigating to String, Subsequence & Substring");
            // Wait for the Web Technologies link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("String, Subsequence & Substring"))).click();
        } catch (NoSuchElementException e) {
            System.err.println("String, Subsequence & Substring link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to tutorial: " + e.getMessage());
        }
        
        
        
        try {
            // Scroll to the bottom of the page using JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top of the page
            js.executeScript("window.scrollTo(0, 0);");

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
            
            
        }
        
        
       
        
        
        try {
            System.out.println("Scrolling up");
            // Scroll up the page
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500);");

            System.out.println("Navigating to Storage for Strings in C");
            // Wait for the Web Technologies link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Storage for Strings in C"))).click();
        } catch (NoSuchElementException e) {
            System.err.println("Storage for Strings in C link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to tutorial: " + e.getMessage());
        }
        
        
        
        try {
            // Scroll to the bottom of the page using JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top of the page
            js.executeScript("window.scrollTo(0, 0);");

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
            
        }
        
        
        
        
        try {
            System.out.println("Scrolling up");
            // Scroll up the page
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500);");

            System.out.println("Navigating to Applications, Advantages and Disadvantages of String");
            // Wait for the Web Technologies link to be visible and click it
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Applications, Advantages and Disadvantages of String"))).click();
        } catch (NoSuchElementException e) {
            System.err.println("Applications, Advantages and Disadvantages of String link not found: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred while navigating to tutorial: " + e.getMessage());
        }
        

        try {
            // Scroll to the bottom of the page using JavascriptExecutor
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

            // Optional pause after scrolling to the bottom
            Thread.sleep(2000); // Adjust the sleep time as needed

            // Scroll back to the top of the page
            js.executeScript("window.scrollTo(0, 0);");

        } catch (InterruptedException e) {
            System.err.println("Thread was interrupted during sleep: " + e.getMessage());
            Thread.currentThread().interrupt(); // Restore interrupted status
        } catch (Exception e) {
            System.err.println("An error occurred during scrolling: " + e.getMessage());
            
            
        }
        
        
        
        
        
        // changr theme
        try {
            WebElement themeButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/div/ul[2]/li[2]/div/button/div")));


            themeButton.click();

            // Wait for theme change (adjust timeout if needed)
            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait1.until(ExpectedConditions.attributeToBe(themeButton, "class", "gfg-icon gfg-icon_dark-mode")); // Adjust the class name for the dark theme

            // Verify theme change (optional)
            System.out.println("Theme switched successfully!");
        } catch (NoSuchElementException e) {
            System.err.println("Theme button not found: " + e.getMessage());
        } catch (TimeoutException e) {
            System.err.println("Theme change timed out: " + e.getMessage());
//            try {
//                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//                FileUtils.copyFile(screenshot, new File("screenshots/" + actualTitle + "_" + System.currentTimeMillis() + ".png"));
//            } catch (IOException e1) {
//                System.err.println("Failed to capture screenshot: " + e1.getMessage());
//            }
        } catch (Exception e) {
            System.err.println("An error occurred during theme switch: " + e.getMessage());
        }
        
//        
//        
//        try {
//            System.out.println("Performing Search");
//
//            // Locate the search box
//            WebElement searchBox = driver.findElement(By.xpath("//*[@id='gcse-search-input']"));
//
//            // Clear the search box (optional, if there might be pre-existing text)
//            searchBox.clear();
//            searchBox.sendKeys("Java");
//
//            // Locate and click the search button
//            WebElement searchButton = driver.findElement(By.xpath("/html/body/nav/div/div/ul[2]/li[1]/div/form/button/i"));
//            searchButton.click();
//            System.out.println("Search button clicked");
//
//        } catch (NoSuchElementException e) {
//            System.err.println("Search box or button not found: " + e.getMessage());
//        } catch (Exception e) {
//            System.err.println("An error occurred during search: " + e.getMessage());
//        }
//
//
//    }
    

    }
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser is closed");
        }
    }
}
