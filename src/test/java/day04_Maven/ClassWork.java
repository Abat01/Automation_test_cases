package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ClassWork {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //1. go to "http://zero.webappsecurity.com"
        driver.get("http://zero.webappsecurity.com");

        //2.go to sign icon button and inspect it then click
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();

        //3. got to Log in space

       WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");

        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.navigate().back();

        //6 online banking go to pay bill click the button //strong[text()='Online Banking']
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();

        driver.findElement(By.xpath("//*[text()='Pay Bills']")).click();

        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("1000");

        //click the date...taken with xpath
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2022-09-10");


        //click the PAY button..inspect it PLEASEEEEEEE! :D
        driver.findElement(By.id("pay_saved_payees")).click();

        //“The payment was successfully submitted.” control the “The payment was successfully submitted.” and take WITH TEXT PLEASEEEE!

        WebElement message = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));

        if (message.isDisplayed()){
            System.out.println("TEST PASSED");

        }else System.out.println("TEST FAILD TRY AGAIN!");

        //CLOSE THE WEB PAGE

        driver.close();

    }

}
