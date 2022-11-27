package org.example.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends AbstractPage {
    @ElementName("Email field")
    @FindBy(how = How.CSS, using = "div fieldset:nth-child(1) input")
    private SelenideElement emailField;

    @ElementName("Password field")
    @FindBy(how = How.CSS, using = "div fieldset:nth-child(2) input")
    private SelenideElement passwordField;

    @ElementName("Enter button")
    @FindBy(how = How.XPATH, using = ".//button[text()='Войти']")
    private SelenideElement enterButton;

    @ElementName("Register link")
    @FindBy(how = How.CLASS_NAME, using = "Auth_link__1fOlj")
    private SelenideElement registerLink;
}
