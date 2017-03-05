package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public interface Parentable {

    Element getParent();

    void setParent(Element parent);
}
