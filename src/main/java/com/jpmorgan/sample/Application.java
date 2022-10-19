/*
 * Date: 10/10/16 10:46 AM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner seedFacts(final ChuckNorrisFactsRepository repository) {
        return args -> {
            repository.save(createFact("Chuck Norris does not sleep; he waits."));
            repository.save(createFact("Chuck Norris doesn't dial the wrong number. You answered the wrong phone."));
            repository.save(createFact("Chuck Norris doesn't wear a watch. HE decides what time it is."));
            repository.save(createFact("Chuck Norris CAN believe it's not butter."));
            repository.save(createFact(
                    "Chuck Norris doesn't read books. He stares them down until he gets the information he wants."));
            repository.save(createFact("Chuck Norris can touch MC Hammer."));
            repository.save(createFact("Chuck Norris got out of checkmate."));
            repository.save(createFact("Chuck Norris can kill two stones with one bird."));
            repository.save(createFact("Chuck Norris can speak French... In Russian."));
            repository.save(createFact("Death once had a near-Chuck-Norris experience."));

            for (final ChuckNorrisFact fact : repository.findAll()) {
                LOGGER.info("Loaded: [{}]", fact);
            }
        };
    }

    private ChuckNorrisFact createFact(final String fact) {
        final ChuckNorrisFact chuckNorrisFact = new ChuckNorrisFact();
        chuckNorrisFact.setFact(fact);
        return chuckNorrisFact;
    }

}