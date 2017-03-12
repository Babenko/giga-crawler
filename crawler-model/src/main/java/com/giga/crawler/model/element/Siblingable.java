package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public interface Siblingable {

    Element getNext();

    Element getPrevious();

    void append(Element element);

    void prepend(Element element);
}
