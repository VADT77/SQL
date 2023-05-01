package  ru.netology.banklogin.test;

import ru.netology.banklogin.data.DataHelper;
import ru.netology.banklogin.data.SQLHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import ru.netology.banklogin.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;

public class BankLoginTest {

    @AfterAll
    static void teardown() { SQLHelper.cleanDatabase(); }

    @Test
    @DisplayName("Should successfully login to dashboard with exist login and password from SUT test data")
    void shouldSuccessfullLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfoWithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifyVerificationPageVisibility();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }
}