package org.example.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ConstructorPage extends AbstractPage {
    @FindBy(how = How.CSS, using = "section.BurgerIngredients_ingredients__1N8v2 div:nth-child(2) div:nth-child(1)")
    private SelenideElement scrollToBunButton;

    @FindBy(how = How.CSS, using = "section.BurgerIngredients_ingredients__1N8v2 div:nth-child(2) div:nth-child(2)")
    private SelenideElement scrollToSauceButton;

    @FindBy(how = How.CSS, using = "section.BurgerIngredients_ingredients__1N8v2 div:nth-child(2) div:nth-child(3)")
    private SelenideElement scrollToFillingButton;
}
