package org.example.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.page_object.AbstractPage;
import org.example.page_object.ConstructorPage;
import org.example.page_object.LoginPage;
import org.example.page_object.RegisterPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class MyStepDef {
    private ConstructorPage constructorPage = page(ConstructorPage.class);
    private LoginPage loginPage = page(LoginPage.class);
    private RegisterPage registerPage = page(RegisterPage.class);

    @Given("^Open \"([^\"]*)\"$")
    public void openPage(String arg0) {
        open(arg0);
    }

    @Then("^Verify that page with url \"([^\"]*)\" is opened$")
    public void verifyThatPageWithUrlIsOpened(String arg0) {
        sleep(2000);
        String currentUrl = webdriver().driver().getWebDriver().getCurrentUrl();
        assertEquals(arg0, currentUrl);
    }

    @When("^Click \"([^\"]*)\" on \"([^\"]*)\"$")
    public void clickOn(String elementName, String page) {
        String requestedPage = page.replaceAll("\\s+", "");

        if ("constructorPage".equalsIgnoreCase(requestedPage)) {
            constructorPage.get(elementName).click();
        } else if ("loginPage".equalsIgnoreCase(requestedPage)) {
            loginPage.get(elementName).click();
        } else if ("registerPage".equalsIgnoreCase(requestedPage)) {
            registerPage.get(elementName).click();
        }
    }

    @When("^Enter valid credentials on \"([^\"]*)\"$")
    public void enterValidCredentialsOn(String page, DataTable dataTable) {
        Map<String, String> map = dataTable.asMap(String.class, String.class);
        String requestedPage = page.replaceAll("\\s+", "");

        if ("loginPage".equalsIgnoreCase(requestedPage)) {
            setValuesFromMap(loginPage, map);
        } else if ("registerPage".equalsIgnoreCase(requestedPage)) {
            setValuesFromMap(registerPage, map);
        }
    }

    @And("Verify that user token in localStorage not null")
    public void verifyThatUserTokenInLocalStorageNotNull() {
        String token = localStorage().getItem("accessToken");
        assertThat(token, notNullValue());
    }

    @And("^Verify that \"([^\"]*)\" in localStorage not null$")
    public void verifyThatInLocalStorageNotNull(String tokenName) {
        String token = localStorage().getItem(tokenName);
        assertThat(token, notNullValue());
    }

    private void setValuesFromMap(AbstractPage page, Map<String, String> map) {
        for (var v : map.entrySet()) {
            page.get(v.getKey()).setValue(v.getValue());
        }
    }
}
