import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class test1 {
    WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void initBrowser()
    {
        driver.get("https://www.w3schools.com/");
        driver.findElement(By.className("w3-hover-green")).click();
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

    @Test(description="This method validates the sign up functionality")
    public void clickRun()
    {
        driver.findElement(By.className("w3-hover-text-green"));
        String noe = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/h1")).getText();
        System.out.println("first "+ noe);
        String hi = driver.findElement(By.xpath("/html/body/div[7]/div[1]/div[1]/a[2]")).getText();
        System.out.println("second "+hi);
        driver.findElement(By.className("w3-hover-text-green")).click();
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertEquals(driver.getTitle(), "W3Schools Online Web Tutorials");
    }

    @AfterMethod
    public void postSignUp()
    {
        System.out.println(driver.getCurrentUrl());
    }

    @AfterClass
    public void afterClass()
    {
        driver.quit();
    }
}
