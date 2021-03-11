package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("http://localhost:4567");
        /* Epäonnistunut kirjautuminen tunnuksella, jota ei ole
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        */

        /* Epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("Jaska");
        element = driver.findElement(By.name("password"));
        element.sendKeys("aksaj");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);
        */

        /* Onnistunut kirjautuminen: oikea käyttäjätunnus, oikea salasana
        sleep(2);

        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("Jaska");
        element = driver.findElement(By.name("password"));
        element.sendKeys("jokunen");
        element = driver.findElement(By.name("login"));

        sleep(2);
        element.submit();

        sleep(3);
        */

        /* uuden käyttäjätunnuksen luominen
        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep123");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("akkep123");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();
        */

        /* uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta */
        sleep(2);

        WebElement element = driver.findElement(By.linkText("register new user"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pirjo");
        element = driver.findElement(By.name("password"));
        element.sendKeys("orjip123");
        element = driver.findElement(By.name("passwordConfirmation"));
        element.sendKeys("orjip123");
        element = driver.findElement(By.name("signup"));

        sleep(2);
        element.submit();

        // kirjaudutaan vielä ulos
        element = driver.findElement(By.linkText("continue to application mainpage"));
        element.click();
        sleep(2);

        element = driver.findElement(By.linkText("logout"));
        element.click();
        sleep(2);

        sleep(5);
        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
