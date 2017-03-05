package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.List;

/**
 * @author Sem Babenko
 */
public interface Element extends Childable, Parentable {

    ElementName getName();

    boolean isClosable();

    String getPayload();

    List<Attribute> getAttributes();

}
