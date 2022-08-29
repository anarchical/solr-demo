package com.leaf.solrdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.request.CoreAdminRequest;
import org.apache.solr.client.solrj.response.CoreAdminResponse;
import org.apache.solr.common.params.CoreAdminParams;
import org.apache.solr.common.util.NamedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YeYaqiao
 */
@Slf4j
@Service
public class CoreService {

    @Autowired
    private SolrClient solrClient;


    public List<String> core() {
        List<String> cores = new ArrayList<>();

        CoreAdminRequest request = new CoreAdminRequest();
        request.setAction(CoreAdminParams.CoreAdminAction.STATUS);
        try {
            CoreAdminResponse process = request.process(solrClient);
            NamedList<NamedList<Object>> coreStatus = process.getCoreStatus();
            for (int i = 0; i < coreStatus.size(); i++) {
                cores.add(coreStatus.getName(i));
            }
        } catch (Exception e) {
            log.error("CoreService", e);
        }
        return cores;
    }


}
