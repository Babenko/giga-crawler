package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.List;

/**
 * @author Sem Babenko
 */
public class Body extends CommonElement {

    @Override
    public ElementName getName() {
        return ElementName.BODY;
    }

    @Override
    public boolean isClosable() {
        return true;
    }
}
