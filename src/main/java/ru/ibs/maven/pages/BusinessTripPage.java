package ru.ibs.maven.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * @author Arkadiy_Alaverdyan
 * Класс описывающий страничку выбора полиса
 */
public class BusinessTripPage extends BasePage {

    @FindBy(xpath = "//a[@title = 'Создать командировку']")
    private WebElement btnCreateBusinessTrip;

    @FindBy(xpath = "//h1[@class = 'oro-subtitle']")
    WebElement title;

    /**
     * Проверка открытия страницы, путём проверки title страницы
     *
     * @return BusinessTripPage - т.е. остаемся на этой странице
     */
    public BusinessTripPage checkOpenBusinessTripPage() {
        wait.until(ExpectedConditions.visibilityOf(title));
        wait.until(ExpectedConditions.attributeContains(title, "class", "oro-subtitle"));
        return this;
    }

    /**
     * Открываем страницу создания командировки
     *
     * @return CreateBusinessTripPage - т.е. перешли на страницу создания командировки
     */
    public CreateBusinessTripPage selectCreateBusinessTrip() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateBusinessTrip));
        wait.until(ExpectedConditions.attributeContains(btnCreateBusinessTrip, "title", "Создать командировку"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCreateBusinessTrip.click();
        return  pageManager.getOpenCreateBusinessTripPage().checkOpenCreateBusinessTripPage();

    }

    /**
     * Клик по кнопке "Оформить"
     *
     * @return RegistrationFormPage - т.е. переходим на страницу {@link ru.appline.framework.pages.RegistrationFormPage}
     */
//    public RegistrationFormPage checkoutInsuranceOnline() {
//        scrollToElementJs(checkoutButton);
//        waitUtilElementToBeClickable(checkoutButton).click();
//        return pageManager.getRegistrationFormPage().checkOpenRegistrationFormPage();
//    }


}
