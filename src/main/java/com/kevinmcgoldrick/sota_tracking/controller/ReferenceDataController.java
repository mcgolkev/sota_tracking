package com.kevinmcgoldrick.sota_tracking.controller;

import com.kevinmcgoldrick.sota_tracking.model.Mode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/reference")
public class ReferenceDataController {

        @GetMapping("/modes")
        public List<String> getModes() {
            return Arrays.stream(Mode.values())
                    .map(Enum::name)
                    .toList();
        }
    }
