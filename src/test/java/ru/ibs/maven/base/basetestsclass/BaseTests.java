package ru.ibs.maven.base.basetestsclass;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import ru.ibs.maven.manager.DriverManager;
import ru.ibs.maven.manager.InitManager;
import ru.ibs.maven.manager.PageManager;
import ru.ibs.maven.manager.TestPropManager;

import static ru.ibs.maven.util.PropConst.BASE_URL;

public class BaseTests {


    /**
     * Менеджер страничек
     * @see PageManager#getPageManager()
     */
    protected PageManager app = PageManager.getPageManager();

    /**
     * Менеджер WebDriver
     *
     * @see DriverManager#getDriverManager()
     */
    private final DriverManager driverManager = DriverManager.getDriverManager();

    @BeforeClass
    public static void beforeAll() {
        InitManager.initFramework();
    }

    @Before
    public void beforeEach() {
        driverManager.getDriver().get(TestPropManager.getTestPropManager().getProperty(BASE_URL));
    }

    @AfterClass
    public static void afterAll() {
        InitManager.quitFramework();
    }
}
