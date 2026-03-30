package com.globant.mobile.utils;

import com.github.javafaker.Faker;

public class DataGenerator {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPassword() {
        return faker.internet().password(8, 12, true, true, true);
    }
}