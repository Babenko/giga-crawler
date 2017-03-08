package com.giga.crawler.core.parse;

import com.giga.crawler.model.element.Element;

/**
 * @author Sem Babenko
 */
public class RegexpParser implements Parser {

    private String document;

    public RegexpParser(String document) {
        this.document = document;
    }

    @Override
    public Element getRoot() {
        return null;
    }
}
