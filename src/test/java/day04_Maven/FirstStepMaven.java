package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FirstStepMaven {
    public static void main(String[] args) {
        //https://www.amazon.com/ sayfasina gidelim

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com/");

        //arama kutusunu locate edelim
        WebElement search = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //“Airpods Max headphones” ile arama yapalim
        search.sendKeys("Airpods Max headphones"); //after "," we also add "Keys.ENTER"
       search.submit();// Enter click

        //Bulunan sonuc sayisini yazdiralim

        WebElement searchresult = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[8]"));
        System.out.println("search Result" +searchresult.getText());

        //click the third headphones#

        driver.findElement(By.xpath("//*[@class='s-image']")).click();

        List<WebElement> Title = driver.findElements(By.xpath("//h1"));
        for (WebElement w: Title) {
            System.out.println(w.getText());

        }


        // Title.forEach(t-> System.out.println(t.getText())); --- LAMBDA ILE DE YAZILIR

        //close the web page
        driver.close();

    }
}
