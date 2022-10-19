/*
 * Date: 10/10/16 1:28 PM
 *
 * The source code contained in this listing is proprietary to JPMorgan Chase, Inc.
 *
 * Unauthorized copying, adaptation, distribution, use, or display is strictly prohibited.
 * This software is Copyright 2016 JPMorgan Chase, Inc.
 */

package com.jpmorgan.sample;

import org.springframework.data.repository.CrudRepository;

public interface ChuckNorrisFactsRepository extends CrudRepository<ChuckNorrisFact, Long> {

}
