/*
author: chetan.koranga,
date of creation: 03/06/22
*/

package com.stackroute.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvcBuilder;

public class TagControllerTest {

    @MockBean
    TagController tagController;



    MockMvcBuilder mockBuilder;

    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer();



    @Test
    void testBookSlot() {
//        Arrange



        //Act


        //Assert
    }
}
