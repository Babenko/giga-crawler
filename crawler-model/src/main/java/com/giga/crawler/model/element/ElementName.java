package com.giga.crawler.model.element;

import java.util.Objects;

/**
 * @author Sem Babenko
 */
public enum ElementName {

    UNKNOWN("unknown"),
    DIV("div"),
    HTML("html"),
    HEAD("head"),
    BODY("body");

    private String name;

    ElementName(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

}
