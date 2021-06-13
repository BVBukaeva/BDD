package ru.netology.web.data;

import lombok.AllArgsConstructor;
import lombok.Value;

public class DataHelper {
    private DataHelper() {
    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }

    public static AuthInfo getAuthInfo() {
        return new AuthInfo("vasya", "qwerty123");
    }

    @Value
    public static class VerificationCode {
        String code;
    }

    public static VerificationCode getVerificationCodeFor() {
        return new VerificationCode("12345");
    }

    @Value
    @AllArgsConstructor
    public static class TransferInfo {
        String card;
    }

    public static TransferInfo getFirstCardNumber() {
        return new TransferInfo("5559000000000001");
    }

    public static TransferInfo getSecondCardNumber() {
        return new TransferInfo("5559000000000002");
    }

    public static TransferInfo getEmptyCardNumber() {
        return new TransferInfo("");
    }

    public static TransferInfo getIrrelevantCardNumber() {
        return new TransferInfo("5559000000002222");
    }

    public static int getExpectedBalanceIfBalanceIncreased(int balance, int amount) {
        return balance + amount;
    }

    public static int getExpectedBalanceIfBalanceDecreased(int balance, int amount) {
        return balance - amount;
    }
}