package org.example.page_object;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractPage {
    public SelenideElement get(String elementName) {
        Class<?> clazz = this.getClass();
        List<Field> fields = new ArrayList<>();
        for (Field field : getAllFields(fields, clazz)) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(ElementName.class)) {
                ElementName elementNameAnnotation = field.getAnnotation(ElementName.class);
                if (elementNameAnnotation.value().replaceAll("\\s+", "")
                        .equalsIgnoreCase(elementName.replaceAll("\\s+", ""))) {
                    try {
                        return (SelenideElement) field.get(this);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        throw new IllegalArgumentException("There is no such element with name " + elementName);
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));

        if (type.getSuperclass() != null) {
            getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    @ElementName("Account button")
    @FindBy(how = How.XPATH, using = "//p[contains(text(),'Личный Кабинет')]")
    private SelenideElement accountButton;
}
