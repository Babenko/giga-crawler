package com.giga.crawler.model.element;

/**
 * @author Sem Babenko
 */
public class ElementFactory {

    public Element getElemenetByName(ElementName elementName) {
        if(elementName.equals(ElementName.DIV)) {
            return new Div();
        } else if(elementName.equals(ElementName.HEAD)) {
            return new Head();
        } else if(elementName.equals(ElementName.BODY)) {
            return new Body();
        }
        return new Unknown();
    }
}
