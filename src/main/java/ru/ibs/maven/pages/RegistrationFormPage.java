package ru.ibs.maven.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * Класс описывающий страничку авторизации
 */
public class RegistrationFormPage extends BasePage {

    @FindBy(xpath = "//h2[@class='title' and contains(text(), 'Логин')]")
    private WebElement titleLoginPage;

    @FindBy(xpath = "//input[@name='_username']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='_password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnEnter;

    @FindBy(xpath = "//div[@class='alert-form alert-form-error']")
    private WebElement errorMessageAlert;

    /**
     * роверка открытия страницы, путём проверки title страницы
     *
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public RegistrationFormPage checkOpenRegistrationFormPage() {
        waitUtilElementToBeVisible(titleLoginPage);
        wait.until(ExpectedConditions.attributeContains(titleLoginPage, "class", "title"));
        return this;
    }

    /**
     * Метод заполнения полей
     *
     * @param nameField - имя веб элемента, поля ввода
     * @param value     - значение вводимое в поле
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    @Step("Заполнение формы входа в систему")
    public RegistrationFormPage fillField(String nameField, String value) {
        WebElement element = null;
        switch (nameField) {
            case "Логин":
                fillInputField(login, value);
                element = login;
                break;
            case "Пароль":
                fillInputField(password, value);
                element = password;
                break;
            default:
                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
                        "'Логин'");

        }
        Assert.assertEquals("Поле '" + nameField + "' было заполнено некорректно",
                value, element.getAttribute("value"));
        return this;
    }


    /**
     * Клик по кнопке
     *
     *
     * @return
     */
    @Step ("Кликаем на кнопку для входа в систему после заполнения логина/пароля")
    public TrainingPage clickBtnEnter() {

        wait.until(ExpectedConditions.elementToBeClickable(btnEnter));
        btnEnter.click();
        return pageManager.getGoToBusinessTripPage();
    }

}
