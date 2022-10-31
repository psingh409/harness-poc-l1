/*
 * Date: 11/6/16 8:11 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ChuckNorrisFactsHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("message", "Chuck Norris HealthIndicator always succeeds").build();
    }

}
