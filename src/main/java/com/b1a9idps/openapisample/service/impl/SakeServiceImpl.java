package com.b1a9idps.openapisample.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.b1a9idps.openapisample.entity.Sake;
import com.b1a9idps.openapisample.excepton.NotFoundException;
import com.b1a9idps.openapisample.repository.SakeRepository;
import com.b1a9idps.openapisample.request.SakeCreateRequest;
import com.b1a9idps.openapisample.response.SakeResponse;
import com.b1a9idps.openapisample.service.SakeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SakeServiceImpl implements SakeService {

    private final SakeRepository sakeRepository;

    @Override
    public List<SakeResponse> list() {
        return sakeRepository.findAll().stream()
                .map(SakeResponse::newInstance)
                .collect(Collectors.toList());
    }

    @Override
    public SakeResponse get(Integer id) {
        return sakeRepository.findById(id)
                .map(SakeResponse::newInstance)
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public SakeResponse create(SakeCreateRequest request) {
        Sake sake = new Sake();
        sake.setName(request.getName());
        sake.setBrewingName(request.getBrewingName());

        return SakeResponse.newInstance(sakeRepository.save(sake));
    }
}
