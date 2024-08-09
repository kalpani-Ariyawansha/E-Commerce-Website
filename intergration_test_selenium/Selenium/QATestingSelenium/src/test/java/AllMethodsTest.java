import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AllMethodsTest {

    @Test
    public void logIn() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:5173/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("1223")));

        loginButton.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fullName")));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));

        usernameField.sendKeys("YourUsername");
        emailField.sendKeys("youremail@example.com");
        passwordField.sendKeys("YourPassword");

        WebElement signInButton = driver.findElement(By.xpath("//button[text()='SIGN IN']"));
        signInButton.click();
        Thread.sleep(4000);
        driver.quit();
    }
    @Test
    public  void signUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:5173/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("1223")));


        loginButton.click();
        WebElement register = wait.until(ExpectedConditions.elementToBeClickable(By.id("223")));
        register.click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("fullName")));
        WebElement emailField = driver.findElement(By.name("email"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement mobileNumber = driver.findElement(By.name("number"));

        usernameField.sendKeys("YourUsername");
        emailField.sendKeys("youremail@example.com");
        passwordField.sendKeys("YourPassword");
        mobileNumber.sendKeys("0775894555");


        WebElement signInButton = driver.findElement(By.xpath("//button[text()='SIGN UP']"));
        signInButton.click();

        Thread.sleep(4000);
        driver.quit();
    }

    @Test
    public void searchAndClickFirstResult() {
        try{
            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();

            driver.get("http://localhost:5173/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
            WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("667")));

            searchBar.sendKeys("laptop");
            Thread.sleep(4000);

            WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("699")));
            searchButton.click();

            Thread.sleep(3000);

            WebElement itemButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("1")));
            itemButton.click();

            Thread.sleep(4000);
            driver.quit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void fillContactForm() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:5173/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement contactForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("form")));

            WebElement firstName = driver.findElement(By.name("firstName"));
            firstName.sendKeys("Theekshana");

            WebElement lastName = driver.findElement(By.name("lastName"));
            lastName.sendKeys("Vimukthi");

            WebElement email = driver.findElement(By.name("email"));
            email.sendKeys("Vimukthi@gmail.com");

            WebElement message = driver.findElement(By.name("message"));
            message.sendKeys("This is a test message. This is a test. I used selenium.");
            Thread.sleep(3000);
            WebElement submitButton = driver.findElement(By.id("88"));
            submitButton.click();
            Thread.sleep(3000);

            wait.until(ExpectedConditions.alertIsPresent());

            driver.switchTo().alert().accept();

            Thread.sleep(3500);
            driver.quit();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
