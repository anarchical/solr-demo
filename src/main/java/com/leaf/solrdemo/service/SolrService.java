package com.leaf.solrdemo.service;

import com.alibaba.fastjson.JSONObject;
import com.leaf.solrdemo.entity.Solr;
import com.leaf.solrdemo.repository.SolrSearchRepository;
import com.leaf.solrdemo.vo.PageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

/**
 * @author YeYaqiao
 */
@Service
public class SolrService {

    @Autowired
    private SolrSearchRepository solrSearchRepository;

    public Page<Solr> queryPage(PageRequestVO pageRequest) {
        return solrSearchRepository.queryPageSize(pageRequest);
    }
}
