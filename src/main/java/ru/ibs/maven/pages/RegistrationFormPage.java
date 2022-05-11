package ru.ibs.maven.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Arkadiy_Alaverdyan
 * Класс описывающий страничку оформления полиса страхования
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
     * Проверка ошибки относящаяся к конкретному полю на форме
     *
     * @param nameField  - имя веб элемента
     * @param errMassage - ошибка проверяемая которая отображается возле этого поля
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
//    public RegistrationFormPage checkErrorMessageAtField(String nameField, String errMassage) {
//        WebElement element = null;
//        switch (nameField) {
//            case "Контакты - Мобильный телефон":
//                element = phone;
//                break;
//            case "Контакты - Электронная почта":
//                element = email;
//                break;
//            case "Контакты - Повтор электронной почты":
//                element = repeatEmail;
//                break;
//            default:
//                Assert.fail("Поле с наименованием '" + nameField + "' отсутствует на странице " +
//                        "'Оформления страхования путешественников'");
//
//        }
//        element = element.findElement(By.xpath("./..//span"));
//        Assert.assertEquals("Проверка ошибки у поля '" + nameField + "' была не пройдена",
//                errMassage, element.getText());
//        return this;
//    }

    /**
     * Клик по кнопке "Войти"
     *
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public RegistrationFormPage clickBtnEnter() {

        wait.until(ExpectedConditions.elementToBeClickable(btnEnter));
        btnEnter.click();
        return this;
    }

    /**
     * Проверка общей ошибки
     *
     * @return RegistrationFormPage - т.е. остаемся на этой странице
     */
    public RegistrationFormPage checkErrorMessageAlert(String errMessage) {
        Assert.assertEquals("Проверка ошибки у alert на странице " +
                        "'Оформления страхования путешественников' было не пройдено",
                errMessage, errorMessageAlert.getText());
        return this;
    }
}
