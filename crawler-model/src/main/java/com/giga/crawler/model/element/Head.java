package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.List;

/**
 * @author Sem Babenko
 */
public class Head extends CommonElement {


    @Override
    public ElementName getName() {
        return ElementName.HEAD;
    }

    @Override
    public boolean isClosable() {
        return true;
    }
}
