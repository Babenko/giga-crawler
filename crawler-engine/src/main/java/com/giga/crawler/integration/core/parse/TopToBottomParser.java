package com.giga.crawler.integration.core.parse;

import com.giga.crawler.model.element.Element;
import com.giga.crawler.model.element.ElementFactory;
import com.giga.crawler.model.element.ElementName;
import com.giga.crawler.model.element.Html;
import com.sun.javadoc.Doc;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sem Babenko
 */
public class TopToBottomParser implements Parser{

    private final String DOCUMENT;
    private LinkedList<ElementName> elementNames = new LinkedList<>();


    public TopToBottomParser(String document) {
        this.DOCUMENT = document;
    }

    @Override
    public Element getRoot() {
        return processing();
    }

    private Element processing() {
        Element root = new Html();
        Element currentElement = root;
        for(int charIndex = 0; charIndex < DOCUMENT.length(); charIndex++) {
            char currentChar = DOCUMENT.charAt(charIndex);
            if(currentChar == Parser.OPEN_BRACKET) {
                StringBuilder sb = new StringBuilder();
                do {
                    sb.append(DOCUMENT.charAt(charIndex));
                } while (DOCUMENT.charAt(++charIndex) != Parser.CLOSE_BRACKET);
                if(!sb.toString().contains("/")) {
                    sb.append(DOCUMENT.charAt(charIndex));
                    Element newElem = getElementByStringName(sb.toString());
                    if(newElem.getName().equals(ElementName.UNKNOWN)) {
                        continue;
                    }
                    elementNames.add(newElem.getName());
                    currentElement.addChild(newElem);
                    newElem.setParent(currentElement);
                    currentElement = newElem;
                } else if(!elementNames.isEmpty()) {
                    elementNames.removeLast();
                    currentElement = currentElement.getParent();
                }
            }
        }
        return root;
    }

    private Element getElementByStringName(String elem) {
        ElementFactory elementFactory = new ElementFactory();
        return elementFactory.getElemenetByName(validate(elem.toLowerCase()));
    }

    private ElementName validate(String name) {
        Pattern pattern = Pattern.compile("\\w*");//Pattern.compile("<(\\\"[^\\\"]*\\\"|'[^']*'|[^'\\\">])*>");
        Matcher matcher = pattern.matcher(name);
        if(matcher.find(1)) {
            return ElementName.valueOf(matcher.group().trim().toUpperCase());
        }
        return ElementName.UNKNOWN;
    }
}
