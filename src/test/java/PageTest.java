import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class PageTest {
    private BankPage bankPage;

    @BeforeTest
    public static void setUp() {
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--disable-blink-features=AutomationControlled");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @AfterClass
    public static void tearDown() {
        closeWebDriver();
    }

    @Test
    public void userLoginTest() {
        bankPage = new BankPage();
        bankPage.openPage();
        bankPage.checkPageURL();
        bankPage.clickButtonCustomerLogin();
        bankPage.clickDropdown();
        bankPage.selectUserNameDropdown();
        bankPage.checkUserNameFromDropdown();
        bankPage.clickButtonBeforeSelectUser();
        bankPage.checkAccountPageName();
        bankPage.checkValueAccountNumber();
        bankPage.checkValueAccountBalance();
        bankPage.checkValueAccountCurrency();
        bankPage.clickButtonDeposite();
        bankPage.addDepositeCount();
        bankPage.checkStatusDepositSuccessful();
        bankPage.checkDepositAfterAdd();

    }

}
