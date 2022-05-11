package ru.ibs.maven.manager;

import ru.ibs.maven.pages.BusinessTripPage;
import ru.ibs.maven.pages.CreateBusinessTripPage;
import ru.ibs.maven.pages.RegistrationFormPage;
import ru.ibs.maven.pages.TrainingPage;


/**
 * @author Arkadiy_Alaverdyan
 * Класс для управления страничками
 */
public class PageManager {

    /**
     * Менеджер страничек
     */
    private static PageManager pageManager;

    /**
     * Стартовая страничка
     */
    private CreateBusinessTripPage homePage;

    /**
     * Страничка страхование путешественников
     */
    private TrainingPage insurancePage;

    /**
     * Страничка командировок
     */
    private BusinessTripPage openBusinessTripPage;

    /**
     * Страничка создания командировки
     */
    private CreateBusinessTripPage openCreateBusinessTripPage;

    /**
     * Страничка оформления полиса страхования
     */
    private RegistrationFormPage registrationFormPage;

    /**
     * Конструктор специально был объявлен как private (singleton паттерн)
     *
     * @see PageManager#getPageManager()
     */
    private PageManager() {
    }

    /**
     * Ленивая инициализация PageManager
     *
     * @return PageManager
     */
    public static PageManager getPageManager() {
        if (pageManager == null) {
            pageManager = new PageManager();
        }
        return pageManager;
    }

    /**
     * Ленивая инициализация {@link CreateBusinessTripPage}
     *
     * @return StartPage
     */
    public CreateBusinessTripPage getHomePage() {
        if (homePage == null) {
            homePage = new CreateBusinessTripPage();
        }
        return homePage;
    }

    /**
     * Ленивая инициализация {@link TrainingPage}
     *
     * @return InsurancePage
     */
    public TrainingPage getInsurancePage() {
        if (insurancePage == null) {
            insurancePage = new TrainingPage();
        }
        return insurancePage;
    }

    /**
     * Ленивая инициализация {@link BusinessTripPage}
     *
     * @return BusinessTripPage
     */
    public BusinessTripPage getOpenBusinessTripPage() {
        if (openBusinessTripPage == null) {
            openBusinessTripPage = new BusinessTripPage();
        }
        return openBusinessTripPage;
    }

    /**
     * Ленивая инициализация {@link BusinessTripPage}
     *
     * @return BusinessTripPage
     */
    public CreateBusinessTripPage getOpenCreateBusinessTripPage() {
        if (openCreateBusinessTripPage == null) {
            openCreateBusinessTripPage = new CreateBusinessTripPage();
        }
        return openCreateBusinessTripPage;
    }

    /**
     *
     *
     * @return RegistrationFormPage
     */
    public RegistrationFormPage getRegistrationFormPage() {
        if (registrationFormPage == null) {
            registrationFormPage = new RegistrationFormPage();
        }
        return registrationFormPage;
    }
}
