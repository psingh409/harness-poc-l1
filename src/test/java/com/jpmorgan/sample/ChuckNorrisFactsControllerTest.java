/*
 * Date: 11/6/16 11:29 PM
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ChuckNorrisFactsControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ChuckNorrisFactsRepository chuckNorrisFactsRepository;

    @Test
    public void testFacts() {
        given(chuckNorrisFactsRepository.findAll())
                .willReturn(Collections.singletonList(chuckNorrisFact(999L, "Test Fact")));
        final ChuckNorrisFactsController.ChuckNorrisServiceResponse response = restTemplate
                .getForObject("/api/facts", ChuckNorrisFactsController.ChuckNorrisServiceResponse.class);
        assertThat(response).isNotNull();
        assertThat(response.getType()).isEqualTo("success");
        assertThat(response.getValue()).hasSize(1);
        assertThat(response.getValue().get(0).getId()).isEqualTo(999L);
        assertThat(response.getValue().get(0).getFact()).isEqualTo("Test Fact");
    }

    @Test
    public void testFactsById() {
        given(chuckNorrisFactsRepository.findById(999L)).willReturn(Optional.of(chuckNorrisFact(999L, "Test Fact")));
        final ChuckNorrisFactsController.ChuckNorrisServiceResponse response = restTemplate
                .getForObject("/api/facts/999", ChuckNorrisFactsController.ChuckNorrisServiceResponse.class);
        assertThat(response).isNotNull();
        assertThat(response.getType()).isEqualTo("success");
        assertThat(response.getValue()).hasSize(1);
        assertThat(response.getValue().get(0).getId()).isEqualTo(999L);
        assertThat(response.getValue().get(0).getFact()).isEqualTo("Test Fact");
    }

    private ChuckNorrisFact chuckNorrisFact(final Long id, final String fact) {
        final ChuckNorrisFact chuckNorrisFact = new ChuckNorrisFact();
        chuckNorrisFact.setId(id);
        chuckNorrisFact.setFact(fact);
        return chuckNorrisFact;
    }

}
