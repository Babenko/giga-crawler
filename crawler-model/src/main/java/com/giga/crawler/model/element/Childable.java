package com.giga.crawler.model.element;

import java.util.List;

/**
 * @author Sem Babenko
 */
public interface Childable {

    void addChild(Element child);

    List<Element> getChildren();

    boolean hasChildren();

}
