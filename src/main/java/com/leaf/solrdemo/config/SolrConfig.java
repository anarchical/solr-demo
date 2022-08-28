package com.leaf.solrdemo.config;

import org.apache.solr.client.solrj.SolrClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;

/**
 * @author YeYaqiao
 */
@Configuration
public class SolrConfig {

    @Bean
    @ConditionalOnMissingBean(SolrClient.class)
    public SolrTemplate solrTemplate(SolrClient solrClient) {
        return new SolrTemplate(solrClient);
    }
}
