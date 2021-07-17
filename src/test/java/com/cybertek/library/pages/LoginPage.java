package com.cybertek.library.pages;

import com.cybertek.library.utilities.BrowserUtils;
import com.cybertek.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement email;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signIn;

    public void login(String username, String password) {
        BrowserUtils.sleep(1);
        email.sendKeys(username);
        BrowserUtils.sleep(1);
        passwordBox.sendKeys(password);
        BrowserUtils.sleep(1);
        signIn.click();
        Driver.getDriver().getTitle();
    }

    public void loginParamUser(String username) {
        BrowserUtils.sleep(1);
        email.sendKeys(username);
        BrowserUtils.sleep(1);
    }
    public void loginParamPass(String password) {
        BrowserUtils.sleep(1);
        passwordBox.sendKeys(password);
    }

}
