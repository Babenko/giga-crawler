package com.giga.crawler.core;

import com.giga.crawler.core.parse.Parser;
import com.giga.crawler.core.parse.TopToBottomParser;
import com.giga.crawler.model.element.Element;

import java.util.Objects;

/**
 * @author Sem Babenko
 */
public class Giga {

    private byte[] document;
    private Parser parser;

    private Giga(byte[] document) {
        Objects.requireNonNull(document);
        this.document = document;
        this.parser = new TopToBottomParser(new String(document));
    }

    public static Giga of(byte[] document) {
        return new Giga(document);
    }

    public void print() {
        System.out.println(new String(document));
    }

    public Element getRoot() {
        return parser.getRoot();
    }

}
