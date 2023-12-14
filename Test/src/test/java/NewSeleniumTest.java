import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class NewSeleniumTest {

    private WebDriver driver;


    @Test
    public void start() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();

//Test 1. Verify that the url leads you to the right page
        driver.get("https://selenium-blog.herokuapp.com");
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(2500);
        driver.quit();

    }

    @Test
    public void SuccessfulSignupPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test 2. Verify that when user clicks on the signup button, the user is directed to the signup page.
        String expectedUrl = "https://selenium-blog.herokuapp.com";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("Correct Webpage");
        else
            //Fail
            System.out.println("Wrong Webpage");
        Thread.sleep(2500);
        driver.quit();

    }

    @Test
    public void LessThanTwoChaPassword() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test 3: Verify that user can sign up with less than two character password.
        driver.findElement(By.id("user_username")).sendKeys("ifeomaezenwajiakuda");
        driver.findElement(By.id("user_email")).sendKeys("ifyness1da@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys(".");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2500);
        driver.quit();
    }


    @Test
    public void negativeSignup() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test 4: Verify user cannot sigh up with an already existing email.
        driver.findElement(By.id("user_username")).sendKeys("ifeomaezenwajiakuam");
        driver.findElement(By.id("user_email")).sendKeys("ifyness1@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("#IfeomaEze001");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void positiveSignup() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test 5 Verify that user can sign up with valid credentials.
        driver.findElement(By.id("user_username")).sendKeys("ifeomaezenwajiakudb");
        driver.findElement(By.id("user_email")).sendKeys("ifyness1db@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("#IfeomaEze001");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void blankFields() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys(" ");
        driver.findElement(By.id("user_email")).sendKeys(" ");
        driver.findElement(By.id("user_password")).sendKeys(" ");
        // test 6 Verify you cannot sign up with all field blank.
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void SuccessfulLogout() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("ifeomaezenwajiakudc");
        driver.findElement(By.id("user_email")).sendKeys("ifyness1dc@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("#IfeomaEze001");//Click on signup button and submit.
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
//Test7: Verify that when the user logout, he/she is directed back to the home page
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if (expectedTitle.contains(actualTitle))
//Pass
            System.out.println("Correct Webpage");
        else
//Fail
            System.out.println("Wrong Webpage");
        driver.quit();
    }

    @Test
    public void badSignup() throws InterruptedException {
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);

        //Test 8: Verify that user cannot sign in with less than 4-character username.
        driver.findElement(By.id("user_username")).sendKeys("ife");
        driver.findElement(By.id("user_email")).sendKeys("ifyness1dd@yahoo.com");
        driver.findElement(By.id("user_password")).sendKeys("Ify");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2500);
        driver.quit();
    }

    @Test
    public void verifyItem() throws InterruptedException {
        //locate where the chromedriver is
        System.setProperty("webdriver.chrome.drive", "resources/chromedriver.exe");
        //1. Open your Chrome browser
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        Thread.sleep(5000);
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Input your username on the user field.
        driver.findElement(By.id("user_username")).sendKeys("ifeomaezenwajiakucadg");
        //Locate the email address field and input an email address on the email field.
        driver.findElement(By.id("user_email")).sendKeys("ifyness1dg@yahoo.com");
        //Locate the email password field and input a password on the password field.
        driver.findElement(By.id("user_password")).sendKeys("#IfeomaEze001");
        //Click on signup button and submit.
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2500);
        //Verify that first user is present.
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]")).click();
        Thread.sleep(2500);
        //Search for an item(using Python with selenium) and confirm it is present.
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        Thread.sleep(2500);
        //Click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        Thread.sleep(2500);
        //Quit browser.
        driver.quit();

    }
    @AfterTest
    public void closeBrowser(){
        driver.quit();

    }

}
