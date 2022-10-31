/*
 * Date: 10/10/16 1:41 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
public class ChuckNorrisFactsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChuckNorrisFactsController.class);

    private final ChuckNorrisFactsRepository repository;

    public ChuckNorrisFactsController(final ChuckNorrisFactsRepository repository) {
        this.repository = repository;

    }

    @RequestMapping(value = "/facts", method = RequestMethod.GET)
    public ChuckNorrisServiceResponse facts() {
        LOGGER.info("Request Received for [/facts]");
        final ChuckNorrisServiceResponse response = new ChuckNorrisServiceResponse();
        response.setType("success");
        final List<ChuckNorrisFact> facts = StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        response.setValue(facts);
        return response;
    }

    @RequestMapping(value = "/facts/{factId}", method = RequestMethod.GET)
    public ChuckNorrisServiceResponse fact(@PathVariable("factId") final Long id) {
        LOGGER.info("Request Received for [/facts/{factId}]");
        final ChuckNorrisServiceResponse response = new ChuckNorrisServiceResponse();
        response.setType("success");
        final List<ChuckNorrisFact> facts = new ArrayList<>();
        repository.findById(id).ifPresent(facts::add);
        response.setValue(facts);
        return response;
    }

    public static class ChuckNorrisServiceResponse {

        private String type;

        private List<ChuckNorrisFact> value;

        public String getType() {
            return type;
        }

        public void setType(final String type) {
            this.type = type;
        }

        public List<ChuckNorrisFact> getValue() {
            return value;
        }

        public void setValue(final List<ChuckNorrisFact> value) {
            this.value = value;
        }
    }

}
