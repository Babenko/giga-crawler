package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.List;

/**
 * @author Sem Babenko
 */
public class Div extends CommonElement {

    @Override
    public ElementName getName() {
        return ElementName.DIV;
    }

    @Override
    public boolean isClosable() {
        return true;
    }
}
