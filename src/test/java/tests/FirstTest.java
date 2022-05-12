package tests;

import org.junit.Test;
import ru.ibs.maven.base.basetestsclass.BaseTests;

public class FirstTest extends BaseTests {

    @Test
    public void startTest() {

        app.getRegistrationFormPage()
                .fillField("Логин", "Секретарь")
                .fillField("Пароль", "testing")
                .clickBtnEnter()
                .selectCostsBlock()
                .openBusinessTripPage()
                .selectCreateBusinessTrip()
                .choseDepartment()
                .choseCompany()
                .bookingTicket()
                .choseDepartCity("Россия, Пермь")
                .choseArriveCity("Россия, Москва")
                .choseDepartDate("20.05.2022")
                .choseArriveDate("30.05.2022")
                .saveAndClose();
    }
}
