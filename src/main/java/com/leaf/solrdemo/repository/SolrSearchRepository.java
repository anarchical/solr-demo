package com.leaf.solrdemo.repository;

import com.alibaba.fastjson.JSONObject;
import com.leaf.solrdemo.entity.Solr;
import com.leaf.solrdemo.vo.PageRequestVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Query;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.data.solr.core.query.result.ScoredPage;
import org.springframework.stereotype.Repository;

/**
 * @author YeYaqiao
 */
@Slf4j
@Repository
public class SolrSearchRepository {

    @Autowired
    private SolrTemplate solrTemplate;
    @Value("${solr.core}")
    private String myCore;

    public Page<Solr> queryPageSize(PageRequestVO pageRequest) {
        Query query = new SimpleQuery("*:*");
        long offset = (long) pageRequest.getPageSize() * (pageRequest.getPageNums() - 1);
        query.setOffset(offset);
        query.setRows(pageRequest.getPageSize());
        ScoredPage<Solr> maps = solrTemplate.query(myCore, query, Solr.class);
        log.info("{}", maps);
        return maps;
    }

}
