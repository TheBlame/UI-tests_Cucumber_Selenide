package org.example.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage extends AbstractPage {

    @ElementName("Name field")
    @FindBy(how = How.CSS, using = "div fieldset:nth-child(1) input")
    private SelenideElement nameField;

    @ElementName("Email field")
    @FindBy(how = How.CSS, using = "div fieldset:nth-child(2) input")
    private SelenideElement emailField;

    @ElementName("Password field")
    @FindBy(how = How.CSS, using = "div fieldset:nth-child(3) input")
    private SelenideElement passwordField;

    @ElementName("Register button")
    @FindBy(how = How.XPATH, using = ".//button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;

    @ElementName("Incorrect password message")
    @FindBy(how = How.CSS, using = ".input__error.text_type_main-default")
    private SelenideElement incorrectPasswordMessage;
}
