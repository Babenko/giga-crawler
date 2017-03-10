package com.giga.crawler.integration.core;

import com.giga.crawler.integration.core.parse.Parser;
import com.giga.crawler.integration.core.parse.RegexpParser;
import com.giga.crawler.integration.core.parse.TopToBottomParser;
import com.giga.crawler.model.element.Element;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
