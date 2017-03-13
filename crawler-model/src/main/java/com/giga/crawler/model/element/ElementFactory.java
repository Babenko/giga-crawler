package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public class ElementFactory {

    public Element getElementByName(ElementName elementName) {
        if (elementName.equals(ElementName.DIV)) {
            return new Div();
        } else if (elementName.equals(ElementName.HEAD)) {
            return new Head();
        } else if (elementName.equals(ElementName.BODY)) {
            return new Body();
        } else if (elementName.equals(ElementName.H1)) {
            return new H1();
        } else if (elementName.equals(ElementName.SPAN)) {
            return new Span();
        }
        return new Unknown();
    }
}
