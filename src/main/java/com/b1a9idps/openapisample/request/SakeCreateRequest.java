package com.b1a9idps.openapisample.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Value;

@Value
public class SakeCreateRequest {
    @NotNull
    @Size(min = 1, max = 20)
    String name;
    @NotNull
    String brewingName;
}
