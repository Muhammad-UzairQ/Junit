package JunitTests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.Users;
import pages.loginPage;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class login {

    public static WebDriver driver;
    @Before
  public  void Setup() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/windows/chromedriver.exe");
        driver = new ChromeDriver();
        // options.addArguments("--auto-open-devtools-for-tabs");
        //  WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa.ztmesh.io/login");
    }


    @Test
   public void login(){
        driver.findElement(loginPage.EMAIL).sendKeys("ztna.automation@gmail.com");
        driver.findElement(loginPage.PASSWORD).sendKeys("Ztna@123");
        driver.findElement(loginPage.SIGN_IN).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(Users.ZTNA_TU).click();
        String C= driver.findElement(Users.ZTNA_MAIL).getText();
        assertEquals(C, "ztna.automation@gmail.com", "The String " +
                "ztna.automation@gmail.com is not present");
    }



    @After
   public void TearDown() {

        driver.quit();
    }

}
