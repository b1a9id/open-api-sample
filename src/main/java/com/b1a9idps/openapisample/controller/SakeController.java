package com.b1a9idps.openapisample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.b1a9idps.openapisample.excepton.NotFoundException;
import com.b1a9idps.openapisample.request.SakeCreateRequest;
import com.b1a9idps.openapisample.response.ErrorResponse;
import com.b1a9idps.openapisample.response.SakeResponse;
import com.b1a9idps.openapisample.service.SakeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/sakes")
@RequiredArgsConstructor
public class SakeController {

    private final SakeService sakeService;

    @GetMapping
    public List<SakeResponse> list() {
        return sakeService.list();
    }

    @GetMapping("{id}")
    public SakeResponse get(@PathVariable Integer id) {
        return sakeService.get(id);
    }

    @PostMapping
    public SakeResponse create(@RequestBody @Validated SakeCreateRequest request) {
        return sakeService.create(request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleException(NotFoundException e) {
        return ResponseEntity.of(Optional.of(new ErrorResponse(e.getMessage())));
    }
}
