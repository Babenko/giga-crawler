package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.List;

/**
 * @author Sem Babenko
 */
public interface Element extends Childable, Parentable, Siblingable {

    ElementName getName();

    boolean isClosable();

    String getPayload();

    void setPayload(String payload);

    List<Attribute> getAttributes();

}
