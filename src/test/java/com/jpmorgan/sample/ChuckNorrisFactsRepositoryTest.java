/*
 * Date: 11/7/16 12:17 AM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ChuckNorrisFactsRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private ChuckNorrisFactsRepository chuckNorrisFactsRepository;

    @Test
    public void findById() {
        final ChuckNorrisFact factToInsert = new ChuckNorrisFact();
        factToInsert.setFact("Test Fact");
        entityManager.persist(factToInsert);
        final Optional<ChuckNorrisFact> factFromDb = chuckNorrisFactsRepository.findById(factToInsert.getId());

        assertThat(factFromDb.isPresent()).isTrue();
        assertThat(factFromDb.get().getId()).isEqualTo(factToInsert.getId());
        assertThat(factFromDb.get().getFact()).isEqualTo("Test Fact");
    }

}
