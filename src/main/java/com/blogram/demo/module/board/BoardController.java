package com.blogram.demo.module.board;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

    @GetMapping("/")
    String Home() {
        return "index";
    }
}
