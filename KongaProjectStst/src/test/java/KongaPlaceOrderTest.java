import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class KongaPlaceOrderTest {

    //import the selenium WebDrive
    private WebDriver driver;



    @Test (priority = 1)
    public void correctURL() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();


        //Test 1. Visit the URL Konga
        driver.get("https://www.konga.com");
        if(driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(2500);

        driver.manage().window().maximize();
        Thread.sleep(10000);

    }


    @Test (priority = 2)
    public void successfulLogin() throws InterruptedException {

        //Test 2. Sign in to Konga Successfully.

        //2a. Click on login/signup button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();
        Thread.sleep(5000);

        //2b. Input valid email or phone number.
        driver.findElement(By.id("username")).sendKeys("ifyness1@gmail.com");

        //2c. Input valid password
        driver.findElement(By.id("password")).sendKeys("#Testing001");

        //2d. Click login
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 3)
    public void selectCategory() throws InterruptedException {

        //Test 3. From the Categories, click on “Computers and Accessories”

        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 4)
    public void selectSubCategory() throws InterruptedException {

        //Test 4. Click on the Laptop Subcategory
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 5)
    public void selectItem() throws InterruptedException {
        //Test 5. Click on the Apple MacBooks-Add an item to the cart
        //5a. Click on Apple MacBooks
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[4]/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(5000);

        //5b. Add an item to Cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[4]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(5000);

        //5c. Click on your cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(5000);

        //5d. Click on check-out
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 6)
    public void selectAddress() throws InterruptedException {

        //**** Test 6. Select Address-Continue to make payment
        //6a. Click on change address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        Thread.sleep(5000);

        //6b. Click on add delivery address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/main/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(5000);

        //6c. Click on preferred address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[2]/div/div/div[2]/div/form/button")).click();
        Thread.sleep(5000);

        //6d. Click use this address
        driver.findElement(By.xpath("/html/body/div[1]/div/section/div[2]/section/section/aside/div[3]/div/div/div/a")).click();
        Thread.sleep(5000);

    }

    @Test (priority = 7)
    public void paymentMethod() throws InterruptedException {

        // Test 7. Select a Card Payment Method-Input invalid card details

        //7a. Click pay now
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
        Thread.sleep(5000);

        //7b Click continue to payment
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(5000);

        //7c. Switch to frame
        driver.switchTo().frame("kpg-frame-component");
        Thread.sleep(5000);

        //7d. select card payment method
        WebElement cardpayment = driver.findElement(By.className("Card"));
        cardpayment.click();
        System.out.println("select card method");
        Thread.sleep(5000);

    }

    @Test (priority = 8)
    public void cardPayment() throws InterruptedException {

        //8 print out the error message - invalid card number

        //8a input card number in its field
        WebElement carddigit = driver.findElement(By.id("card-number"));
        carddigit.sendKeys("5399412109851204");
        Thread.sleep(5000);

        //8b input date in its field
        WebElement datedigit = driver.findElement(By.id("expiry"));
        datedigit.sendKeys("0827");
        Thread.sleep(5000);

        //8c input CVV in its field
        WebElement cvvdigit = driver.findElement(By.id("cvv"));
        cvvdigit.sendKeys("024");
        Thread.sleep(5000);
        System.out.println("input card details");

        //8d print out the error message
        WebElement error = driver.findElement(By.id("card-number_unhappy"));
        System.out.println(error.getText());
        Thread.sleep(1000);

    }

    @Test (priority = 9)
    public void closeFrame() throws InterruptedException {

        //9 close the Iframe that displays input card details
        WebElement exitframe = driver.findElement(By.className("data-card__close"));
        exitframe.click();

        System.out.println("exit iframe");
        Thread.sleep(1000);

    }

    @Test (priority = 10)
    public void closeBrowser(){
        // Test 10. Quit the browser.
        driver.quit();

    }
}

