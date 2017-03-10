package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public class Unknown extends CommonElement {
    @Override
    public ElementName getName() {
        return ElementName.UNKNOWN;
    }

    @Override
    public boolean isClosable() {
        return false;
    }
}
