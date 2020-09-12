package com.b1a9idps.openapisample.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.b1a9idps.openapisample.excepton.NotFoundException;
import com.b1a9idps.openapisample.request.SakeCreateRequest;
import com.b1a9idps.openapisample.response.SakeResponse;
import com.b1a9idps.openapisample.service.SakeService;

@Service
public class SakeServiceImpl implements SakeService {

    @Override
    public List<SakeResponse> list() {
        return sakeResponseStream().collect(Collectors.toList());
    }

    @Override
    public SakeResponse get(Integer id) {
        return sakeResponseStream()
                .filter(sake -> sake.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public SakeResponse create(SakeCreateRequest request) {
        return new SakeResponse(4, request.getName(), request.getBrewingName());
    }

    private Stream<SakeResponse> sakeResponseStream() {
        return Stream.of(
                new SakeResponse(1, "若波", "若波酒造"),
                new SakeResponse(2, "新政", "新政酒造"),
                new SakeResponse(3, "十四代", "高木酒造"));
    }
}
