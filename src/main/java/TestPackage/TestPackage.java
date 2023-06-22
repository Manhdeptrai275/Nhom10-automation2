package TestPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.awt.SystemColor.menu;

public class TestPackage {
    public WebDriver edriver;
    public WebDriverWait ewait;

    @FindBy(how = How.XPATH, using = "//*[@id=\"user-name\"]")
    public WebElement userName;
    @FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
    public WebElement passWord;

    @FindBy(how = How.XPATH, using = "//*[@id=\"login-button\"]")
    public WebElement btnLogin;

    @FindBy(how = How.XPATH, using = "//*[@data-test=\"product_sort_container\"]")
    public WebElement sort;

    @FindBy(how = How.XPATH, using = "//*[@value=\"lohi\"]")
    public WebElement lth;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
    public WebElement addsp1;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    public WebElement addsp2;

    @FindBy(how = How.XPATH, using = "//*[@class=\"shopping_cart_link\"]")
    public WebElement cartButton;

    @FindBy(how = How.CLASS_NAME, using = "cart_list")
    public WebElement cartInfo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"remove-sauce-labs-bike-light\"]")
    public WebElement removesp2;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue-shopping\"]")
    public WebElement continueShoppingButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
    public WebElement addToCartButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"checkout\"]")
    public WebElement checkoutButton;

    @FindBy(how = How.XPATH, using = "//*[@id=\"first-name\"]")
    public WebElement co_firstname;

    @FindBy(how = How.XPATH, using = "//*[@id=\"last-name\"]")
    public WebElement co_lastname;

    @FindBy(how = How.XPATH, using = "//*[@id=\"postal-code\"]")
    public WebElement co_zip;

    @FindBy(how = How.XPATH, using = "//*[@id=\"continue\"]")
    public WebElement continueButton;

    @FindBy(how = How.CLASS_NAME, using = "summary_info")
    public WebElement summaryInfo;

    @FindBy(how = How.XPATH, using = "//*[@id=\"react-burger-menu-btn\"]")
    public WebElement menu;

    @FindBy(how = How.XPATH, using = "//*[@id=\"logout_sidebar_link\"]")
    public WebElement logout;
    public TestPackage() {
        edriver = new ChromeDriver();
        PageFactory.initElements(edriver, this);
        ewait = new WebDriverWait(edriver, Duration.ofSeconds(5));;
    }
    @Before
    public void setUP(){
        edriver.get("https://www.saucedemo.com/");
    }
    @Test()
    public void TestClass() throws Exception{

        waitUntilElementVisible(userName);
        waitUntilElementVisible(passWord);
        userName.sendKeys("standard_user");
        passWord.sendKeys("secret_sauce");

        waitUntilElementVisible(btnLogin);
        btnLogin.click();
//sort
        waitUntilElementVisible(sort);
        sort.click();

        waitUntilElementVisible(lth);
        lth.click();

// thêm 2 sp đầu tiên
        waitUntilElementVisible(addsp1);
        waitUntilElementVisible(addsp2);
        addsp1.click();
        addsp2.click();
//Chọn giỏ hàng
        waitUntilElementVisible(cartButton);
        cartButton.click();
//in gio hang
        System.out.println(cartInfo.getText());
// remove sản phẩm
        waitUntilElementVisible(removesp2);
        removesp2.click();
//continueShopping
        waitUntilElementVisible(continueShoppingButton);
        continueShoppingButton.click();
// thêm sp
        waitUntilElementVisible(addToCartButton);
        addToCartButton.click();
// Chọn giỏ hàng
        waitUntilElementVisible(cartButton);
        cartButton.click();
//click ckeckout
        waitUntilElementVisible(checkoutButton);
        checkoutButton.click();
//checkout info
        waitUntilElementVisible(co_firstname);
        waitUntilElementVisible(co_lastname);
        waitUntilElementVisible(co_zip);
        co_firstname.sendKeys("First");
        co_lastname.sendKeys("Last");
        co_zip.sendKeys("700000");
//continueCheckout
        waitUntilElementVisible(continueButton);
        continueButton.click();
//in checkout
        System.out.println(cartInfo.getText());
        System.out.println(summaryInfo.getText());
//logout
        waitUntilElementVisible(menu);
        menu.click();

        waitUntilElementVisible(logout);
        logout.click();


    }
    @After
    public void tearDown() throws InterruptedException {
        //edriver.close();
    }public void waitUntilElementVisible(WebElement element){
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }

    public void waitUntilElementVisible(String path) throws Exception{
        int tryTimes = 0;
        while (tryTimes < 2){
            try {
                WebElement element = edriver.findElement(By.xpath(path));
                ewait.until(ExpectedConditions.visibilityOf(element));
                break;
            }
            catch (StaleElementReferenceException se){
                tryTimes ++;
                if (tryTimes == 2)
                    throw se;
            }
        }
    }
}