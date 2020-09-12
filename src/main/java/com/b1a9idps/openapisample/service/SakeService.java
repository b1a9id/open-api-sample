package com.b1a9idps.openapisample.service;

import java.util.List;

import com.b1a9idps.openapisample.request.SakeCreateRequest;
import com.b1a9idps.openapisample.response.SakeResponse;

public interface SakeService {

    List<SakeResponse> list();

    SakeResponse get(Integer id);

    SakeResponse create(SakeCreateRequest request);
}
