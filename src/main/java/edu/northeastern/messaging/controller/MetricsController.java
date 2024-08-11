package edu.northeastern.messaging.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.messaging.service.metrics.MetricsService;

@RestController
@RequestMapping("/metrics")
public class MetricsController {

    @GetMapping
    public Map<String, Integer> get() {
        return MetricsService.PUBLISHER.getMetrics();
    }
}
