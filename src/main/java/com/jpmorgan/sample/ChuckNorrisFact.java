/*
 * Date: 10/10/16 1:19 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CHUCK_NORRIS_FACT")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChuckNorrisFact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fact;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(final String fact) {
        this.fact = fact;
    }

    @Override
    public String toString() {
        return String.format("[id=%d,fact=%s]", id, fact);
    }

}
