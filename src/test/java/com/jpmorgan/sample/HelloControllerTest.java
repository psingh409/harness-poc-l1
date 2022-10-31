/*
 * Date: 11/6/16 11:18 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHello() throws Exception {
        mvc.perform(get("/api/hello").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

}
