package com.leaf.solrdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.leaf.solrdemo.entity.Solr;
import com.leaf.solrdemo.service.SolrService;
import com.leaf.solrdemo.vo.PageRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YeYaqiao
 */
@RestController
@RequestMapping("/solr")
public class SolrController {
    @Autowired
    private SolrService service;

    @GetMapping("/page")
    public Page<Solr> page(@RequestBody PageRequestVO pageRequest) {
        return service.queryPage(pageRequest);
    }
}
