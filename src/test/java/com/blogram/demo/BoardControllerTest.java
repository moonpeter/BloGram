package com.blogram.demo;

import com.blogram.demo.controller.BoardController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = BoardController.class)
public class BoardControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void home이_리턴된다() throws Exception {
        String home = "index2";

        mvc.perform(get("/home")).andExpect(status().isOk()).andExpect(content().string(home));
    }
}
