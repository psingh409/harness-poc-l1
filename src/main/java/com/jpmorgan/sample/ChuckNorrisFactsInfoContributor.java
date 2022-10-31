/*
 * Date: 11/6/16 10:22 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@Component
public class ChuckNorrisFactsInfoContributor implements InfoContributor {

    private static final LocalDate CHUCK_NORRIS_DOB = LocalDate.of(1940, Month.MARCH, 10);

    @Override
    public void contribute(final Info.Builder builder) {
        builder.withDetail("chuckNorrisAge", Period.between(CHUCK_NORRIS_DOB, LocalDate.now()).getYears());
    }

}
