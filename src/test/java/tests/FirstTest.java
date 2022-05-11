package tests;

import org.junit.Test;
import ru.ibs.maven.base.basetestsclass.BaseTests;
import ru.ibs.maven.pages.BusinessTripPage;
import ru.ibs.maven.pages.CreateBusinessTripPage;
import ru.ibs.maven.pages.RegistrationFormPage;
import ru.ibs.maven.pages.TrainingPage;

public class FirstTest extends BaseTests {

    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TrainingPage trainingPage = new TrainingPage();
    BusinessTripPage businessTripPage = new BusinessTripPage();
    CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

    @Test
    public void startTest() {

        /**
         * заполнили поля для авторизации
         */

        registrationFormPage.fillField("Логин", "Секретарь");
        registrationFormPage.fillField("Пароль", "testing");

        /**
        * Клик по кнопке войти
        */

        registrationFormPage.clickBtnEnter();

        /**
         * Клик по меню Расходы
         */

        trainingPage.selectCostsBlock();

        /**
         * Выбор меню командировки
         */

        trainingPage.openBusinessTripPage();

        /**
         * Переход к созданию командировки
         */

        businessTripPage.selectCreateBusinessTrip();

        /**
         * Заполнение полей
         */
        
        createBusinessTripPage.choseDepartment();
        createBusinessTripPage.choseCompany();
        createBusinessTripPage.bookingTicket();
        createBusinessTripPage.choseDepartCity("Россия, Пермь");
        createBusinessTripPage.choseArriveCity("Россия, Москва");
        createBusinessTripPage.choseDepartDate("20.05.2022");
        createBusinessTripPage.choseArriveDate("30.05.2022");
        createBusinessTripPage.saveAndClose();




//        app.getHomePage()
//                .closeCookiesDialog()
//                .selectBaseMenu("Страхование")
//                .selectSubMenu("Путешествия")
//                .checkOpenInsurancePage()
//                .checkoutOnline()
//                .checkOpenSelectInsuranceServicePage()
//                .selectTariffMin()
//                .checkoutInsuranceOnline()
//                .checkOpenRegistrationFormPage()
//                .fillField("Застрахованные - Фамилия", "Privet")
//                .fillField("Застрахованные - Имя", "Адам")
//                .fillField("Застрахованные - Дата рождения", "12.06.1990")
//                .fillField("Страхователь - Фамилия", "Петров")
//                .fillField("Страхователь - Имя", "Вася")
//                .fillField("Страхователь - Отчество", "Петрович")
//                .fillField("Страхователь - Дата рождения", "16.07.1980")
//                .fillField("Страхователь - Серия паспорта", "4510")
//                .fillField("Страхователь - Номер паспорта", "745602")
//                .fillField("Страхователь - Дата выдачи", "16.09.2019")
//                .fillField("Страхователь - Кем выдан", "Кем-то")
//                .clickBtnContinue()
//                .checkErrorMessageAtField("Контакты - Мобильный телефон", "Поле не заполнено.")
//                .checkErrorMessageAtField("Контакты - Электронная почта", "Поле не заполнено.")
//                .checkErrorMessageAtField("Контакты - Повтор электронной почты", "Поле не заполнено.")
//                .checkErrorMessageAlert("При заполнении данных произошла ошибка");
    }

}
