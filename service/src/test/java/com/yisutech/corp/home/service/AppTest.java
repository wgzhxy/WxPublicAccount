package com.yisutech.corp.home.service;

import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        String uuidStr = UUID.randomUUID().toString().replace("-", "");
        System.out.println(uuidStr + ", " + uuidStr.length());
    }
}
