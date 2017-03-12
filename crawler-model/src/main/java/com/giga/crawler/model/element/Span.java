package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public class Span extends CommonElement {

    @Override
    public ElementName getName() {
        return ElementName.SPAN;
    }

    @Override
    public boolean isClosable() {
        return true;
    }
}
