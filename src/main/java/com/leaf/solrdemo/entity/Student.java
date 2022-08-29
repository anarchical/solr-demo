package com.leaf.solrdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author YeYaqiao
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "student")
public class Student {

    @Id
    @Indexed
    private String id;

    @Indexed
    private String name;

    @Indexed
    private String gender;
}
