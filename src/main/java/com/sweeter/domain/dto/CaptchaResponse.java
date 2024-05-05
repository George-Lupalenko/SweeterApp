package com.sweeter.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaResponse {
    private boolean sucsses;
    @JsonAlias("error-codes")
    private Set<String> errorCode;

    public boolean isSucsses() {
        return sucsses;
    }

    public void setSucsses(boolean sucsses) {
        this.sucsses = sucsses;
    }

    public Set<String> getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Set<String> errorCode) {
        this.errorCode = errorCode;
    }
}
