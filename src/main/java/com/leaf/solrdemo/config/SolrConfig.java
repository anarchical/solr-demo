package com.leaf.solrdemo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

/**
 * @author YeYaqiao
 */
@Configuration
@EnableSolrRepositories(basePackages = "com.leaf.solrdemo.repository",
        schemaCreationSupport = true)
public class SolrConfig {

    @Bean
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
