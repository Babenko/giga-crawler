package com.giga.crawler.model.attribute;

/**
 * @author Sem Babenko
 */
public class Class implements Attribute {

    private String payload;

    public Class(String payload) {
        this.payload = payload;
    }

    @Override
    public AttributeName getName() {
        return AttributeName.CLASS;
    }

    @Override
    public String getPayload() {
        return payload;
    }
}
