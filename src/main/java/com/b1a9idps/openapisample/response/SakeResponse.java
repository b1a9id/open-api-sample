package com.b1a9idps.openapisample.response;

import com.b1a9idps.openapisample.entity.Sake;

import lombok.Value;

@Value
public class SakeResponse {
    Integer id;
    String name;
    String brewingName;

    public static SakeResponse newInstance(Sake sake) {
        return new SakeResponse(sake.getId(), sake.getName(), sake.getBrewingName());
    }
}
