package ru.ibs.maven.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 *
 * Класс, описывающий страничку перехода к расходам
 */
public class TrainingPage extends ru.ibs.maven.pages.BasePage {

    @FindBy(xpath = "//h1[text() = 'Панель быстрого запуска']")
    private WebElement title;

    @FindBy(xpath = "//span[contains(@class, 'title') and text()='Расходы']")
    private WebElement costs;

    @FindBy(xpath = "//span[(@class = 'title') and text()= 'Командировки']")
    private WebElement businessTrip;

    /**
     * Разворачиваем секцию расходы
     *
     * @return TrainingPage - т.е. остаемся на этой странице
     */

    public TrainingPage selectCostsBlock() {
        wait.until(ExpectedConditions.elementToBeClickable(costs));
        costs.click();
        return this;
    }

    /**
     * Переход на страницу командировок
     *
     * @return BusinessTripPage - т.е. переходим на страницу командировок
     */

    public ru.ibs.maven.pages.BusinessTripPage openBusinessTripPage (){
        wait.until(ExpectedConditions.elementToBeClickable(businessTrip));
        businessTrip.click();
        return pageManager.getOpenBusinessTripPage().checkOpenBusinessTripPage();
    }

}
