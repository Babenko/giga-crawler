package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * @author Sem Babenko
 */
public class Html extends CommonElement {

    @Override
    public ElementName getName() {
        return ElementName.HTML;
    }

    @Override
    public boolean isClosable() {
        return true;
    }

    @Override
    public Element getParent() {
        return null;
    }
}
