package com.project.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BanControllerTest {

    @InjectMocks
    private BanController banController;

    @Test
    void testReturnBanPage() {
        String result = banController.banPage();

        assertEquals("ban-page",result);
    }
}