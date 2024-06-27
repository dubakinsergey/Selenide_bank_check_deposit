import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BankPage {
    private final String URL = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    private SelenideElement buttonCustomerLogin = $x("//button[@ng-click=\"customer()\"]");
    private SelenideElement dropdown = $x("//select[@name=\"userSelect\"]");
    private SelenideElement userName = $(By.name("userSelect"));
    private String searchUserName = "Albus Dumbledore";
    private SelenideElement buttonLoginBeforeSelectUser = $x("//button[@class=\"btn btn-default\"]");
    private SelenideElement accountPageName = $x("//span[@class=\"fontBig ng-binding\"]");
    private SelenideElement pathAccountNumber = $x("//div[@ng-hide=\"noAccount\"]/strong[1]");
    private SelenideElement pathBalance = $x("//div[@ng-hide=\"noAccount\"]/strong[2]");
    private SelenideElement pathCurrency = $x("//div[@ng-hide=\"noAccount\"]/strong[3]");

    private String accountNumber = "1010";
    private String balance = "0";
    private String currency = "Dollar";
    private SelenideElement pathDeposite = $x("//button[@ng-click=\"deposit()\"]");
    private SelenideElement pathPlaceholderAmountDeposite = $x("//input[@placeholder=\"amount\"]");
    private String depositCount = "100";
    private SelenideElement pathStatusDeposit = $x("//span[@class=\"error ng-binding\"]");
    private String statusDepositSuccessful = "Deposit Successful";


    public BankPage openPage() {
        open(URL);
        return this;
    }

    public BankPage checkPageURL() {
        webdriver().shouldHave(url(URL));
        return this;
    }

    public BankPage clickButtonCustomerLogin() {
        buttonCustomerLogin.click();
        return this;
    }

    public BankPage clickDropdown() {
        dropdown.click();
        return this;
    }

    public BankPage selectUserNameDropdown() {
        userName.find(withText(searchUserName)).click();
        return this;
    }

    public BankPage checkUserNameFromDropdown() {
        userName.shouldHave(Condition.text(searchUserName));
        return this;
    }

    public BankPage clickButtonBeforeSelectUser() {
        buttonLoginBeforeSelectUser.click();
        return this;
    }

    public BankPage checkAccountPageName() {
        accountPageName.shouldHave(Condition.text(searchUserName));
        return this;
    }

    public BankPage checkValueAccountNumber() {
        pathAccountNumber.shouldHave(Condition.text(accountNumber));
        return this;
    }

    public BankPage checkValueAccountBalance() {
        pathBalance.shouldHave(Condition.text(balance));
        return this;
    }

    public BankPage checkValueAccountCurrency() {
        pathCurrency.shouldHave(Condition.text(currency));
        return this;
    }

    public BankPage clickButtonDeposite() {
        pathDeposite.click();
        return this;
    }

    public BankPage addDepositeCount() {
        pathPlaceholderAmountDeposite.val(depositCount).pressEnter();
        return this;
    }

    public BankPage checkStatusDepositSuccessful() {
        pathStatusDeposit.shouldHave(Condition.text(statusDepositSuccessful));
        return this;
    }

    public BankPage checkDepositAfterAdd() {
        pathBalance.shouldHave(Condition.text(depositCount));
        return this;
    }

}
