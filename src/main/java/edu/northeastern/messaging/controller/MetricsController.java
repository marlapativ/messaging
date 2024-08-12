package edu.northeastern.messaging.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.northeastern.messaging.service.metrics.MetricsService;

/**
 * Controller for handling metrics related requests
 */
@RestController
@RequestMapping("/metrics")
public class MetricsController {

    /**
     * Get the metrics
     * 
     * @return The metrics
     */
    @GetMapping
    public Map<String, Integer> get() {
        return MetricsService.PUBLISHER.getMetrics();
    }
}
