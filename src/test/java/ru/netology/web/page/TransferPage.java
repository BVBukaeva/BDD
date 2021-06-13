package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement amountInput = $("[data-test-id = amount] input");
    private final SelenideElement fromInput = $("[data-test-id = from] input");
    private final SelenideElement transferButton = $("[data-test-id = action-transfer]");
    private final SelenideElement error = $("[data-test-id = error-notification]");

    public TransferPage() {
        SelenideElement heading = $(byText("Пополнение карты"));
        heading.shouldBe(visible);
    }

    public void withoutMoneyTransfer(DataHelper.TransferInfo TransferInfo, String amount) {
        amountInput.setValue(amount);
        fromInput.setValue(TransferInfo.getCard());
        transferButton.click();
        new DashboardPage();
    }

    public void moneyTransfer(DataHelper.TransferInfo TransferInfo, int amount) {
        amountInput.setValue(String.valueOf(amount));
        fromInput.setValue(TransferInfo.getCard());
        transferButton.click();
        new DashboardPage();
    }

    public void invalidMoneyTransfer() {
        error.shouldBe(visible);
    }

}
