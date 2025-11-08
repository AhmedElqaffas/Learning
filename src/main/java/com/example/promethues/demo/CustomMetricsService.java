package com.example.promethues.demo;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomMetricsService {

    private final Counter easterEggsCount;

    public CustomMetricsService(MeterRegistry meterRegistry) {
        easterEggsCount = Counter.builder("easter_eggs_count")
                .description("No. of times the easter egg endpoint is visited")
                .tags("environment", "development")
                .register(meterRegistry);
    }

    public void incrementEasterEggsCount() {
        easterEggsCount.increment();
    }
}