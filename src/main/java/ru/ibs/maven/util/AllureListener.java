package ru.ibs.maven.util;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.ibs.maven.manager.DriverManager;

public class AllureListener extends AllureJunit4 {

    @Override
    public void testFailure (final Failure failure){

        byte[] byteImage =  ((TakesScreenshot) DriverManager.getDriverManager()).getScreenshotAs(OutputType.BYTES);
        getLifecycle().addAttachment("Screenshot", "imag/png", null, byteImage);
        super.testFailure(failure);



    }
}
