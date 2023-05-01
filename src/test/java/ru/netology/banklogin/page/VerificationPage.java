package  ru.netology.banklogin.page;

import static com.codeborne.selenide.Condition.visible;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id='code'] input");
    private SelenideElement verifyButton = $("[data-test-id='action-verify']");

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return page(DashboardPage.class);
    }

    public void verifyVerificationPageVisibility() {
        codeField.shouldBe(visible);
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}