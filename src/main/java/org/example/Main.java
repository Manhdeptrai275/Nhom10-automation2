package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement username = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));

        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(By.id("login-button"));
        login.click();

        WebElement menu = driver.findElement(By.xpath("//button[text()='Open Menu']"));
        menu.click();

        WebElement sortDropdown = driver.findElement(By.className("product_sort_container"));
        Select sortSelect = new Select(sortDropdown);
        sortSelect.selectByValue("lohi");

        WebElement item = driver.findElement(By.xpath("//div[@class='inventory_item_desc']"));
        System.out.println(item.getText());
        // thêm 2 sp đầu tiên
        WebElement addToCartButton1 = driver.findElement(By.xpath("//div[@class='inventory_item'][1]//button"));
        WebElement addToCartButton2 = driver.findElement(By.xpath("//div[@class='inventory_item'][2]//button"));
        addToCartButton1.click();
        addToCartButton2.click();
//Chọn giỏ hàng
        WebElement cartButton = driver.findElement(By.className("shopping_cart_container"));
        cartButton.click();
//in giỏ hàng
        WebElement cartItems = driver.findElement(By.className("cart_list"));
        System.out.println("Thông tin giỏ hàng:");
        System.out.println(cartItems.getText());
//        remove sản phẩm
        WebElement removeButton2 = driver.findElement(By.xpath("//div[@class='cart_item'][2]//button[text()='Remove']"));
        removeButton2.click();
//        continue
        WebElement continueShoppingButton = driver.findElement(By.id("continue-shopping"));
        continueShoppingButton.click();
//        thếmsp
        WebElement addToCartButton = driver.findElement(By.xpath("//div[@class='inventory_item'][1]//button"));
        addToCartButton.click();
//        Chọn giỏ hàng
        cartButton = driver.findElement(By.className("shopping_cart_container"));
        cartButton.click();
//        click ckeckout
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
//        thông tin bất kì
        WebElement firstNameInput = driver.findElement(By.id("first-name"));
        WebElement lastNameInput = driver.findElement(By.id("last-name"));
        WebElement zipCodeInput = driver.findElement(By.id("postal-code"));

        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");
        zipCodeInput.sendKeys("12345");
//        Click continue và lưu lại thông tin
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();
        String orderSummary = driver.findElement(By.className("summary_info")).getText();
        System.out.println("Thông tin đơn hàng:");
        System.out.println(orderSummary);
//        Logout
        WebElement menuButton = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
        menuButton.click();
        WebElement logoutLink = driver.findElement(By.xpath("//a[text()='Logout']"));
        logoutLink.click();






    }
}