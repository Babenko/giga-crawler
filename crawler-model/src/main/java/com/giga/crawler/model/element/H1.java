package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public class H1 extends CommonElement {

    @Override
    public ElementName getName() {
        return ElementName.H1;
    }

    @Override
    public boolean isClosable() {
        return true;
    }
}
