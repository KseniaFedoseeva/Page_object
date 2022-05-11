package ru.ibs.maven.manager;

import java.util.concurrent.TimeUnit;

import static ru.ibs.maven.util.PropConst.*;
import static ru.ibs.maven.util.PropConst.IMPLICITLY_WAIT;
import static ru.ibs.maven.util.PropConst.PAGE_LOAD_TIMEOUT;

/**
 * @author Fedoseeva Ksenia
 * Класс для инициализации фреймворка
 */
public class InitManager {

    /**
     * Менеджер properties
     *
     *
     */
    private static final ru.ibs.maven.manager.TestPropManager props = ru.ibs.maven.manager.TestPropManager.getTestPropManager();

    /**
     * Менеджер WebDriver
     *
     *
     */
    private static final ru.ibs.maven.manager.DriverManager driverManager = ru.ibs.maven.manager.DriverManager.getDriverManager();

    /**
     * Инициализация framework и запуск браузера со страницей приложения
     *
     *
     */
    public static void initFramework() {
        driverManager.getDriver().manage().window().maximize();
        driverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
        driverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    }

    /**
     * Завершения работы framework - гасит драйвер и закрывает сессию с браузером
     *
     *
     */
    public static void quitFramework() {
        driverManager.quitDriver();
    }
}
