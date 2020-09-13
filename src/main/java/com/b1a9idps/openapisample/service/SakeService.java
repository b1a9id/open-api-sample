package com.b1a9idps.openapisample.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.b1a9idps.openapisample.request.SakeCreateRequest;
import com.b1a9idps.openapisample.response.SakeResponse;

public interface SakeService {

    Page<SakeResponse> page(Pageable pageable);

    List<SakeResponse> list();

    SakeResponse get(Integer id);

    SakeResponse create(SakeCreateRequest request);
}
