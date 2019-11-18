import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class test {
    WebDriver driver;

    @BeforeClass
    public void testSetup()
    {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void openBrowserNow()
    {
        driver.get("https://www.browserstack.com/");
        driver.findElement(By.id("signupModalButton")).click();
        System.out.println("We are currently on the following URL" +driver.getCurrentUrl());
    }

    @Test(description="This method validates the sign up functionality")
    public void signUpNow()
    {
        driver.findElement(By.id("user_full_name")).sendKeys("Sadhvi Singh");
        driver.findElement(By.id("user_email_login")).sendKeys("sadhvisingh9049+1@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("BrowserStack123*");
        driver.findElement(By.xpath("//input[@name='terms_and_conditions']")).click();
        driver.findElement(By.id("user_submit")).click();
    }

    @Test(description="This method validates the sign up functionality")
    public void openBstack()
    {
        driver.get("http://demo.guru99.com/test/facebook.html");
        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("pass"));
        email.sendKeys("hi guys its me mario");
        password.sendKeys("notgonnatellya");
        password.submit();
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
