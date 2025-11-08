package com.example.promethues.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EasterEggController {

    @Autowired
    private CustomMetricsService customMetricsService;
    @GetMapping("/easter-egg")
    @ResponseBody
    public ResponseEntity<String> easterEgg() {
        customMetricsService.incrementEasterEggsCount();
        return ResponseEntity.ok("You found me!");
    }
}
