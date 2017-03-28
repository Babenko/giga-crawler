package com.giga.crawler.core.parse;

import com.giga.crawler.model.element.Element;
import com.giga.crawler.model.element.ElementFactory;
import com.giga.crawler.model.element.ElementName;
import com.giga.crawler.model.element.Html;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Sem Babenko
 */
public class TopToBottomParser implements Parser{

    private final char[] DOCUMENT;
    private LinkedList<ElementName> elementNames = new LinkedList<>();
    private ElementFactory elementFactory = new ElementFactory();
    private StringBuilder sb = new StringBuilder();
    private int charIndex = 0;

    public TopToBottomParser(String document) {
        DOCUMENT = document.toCharArray();
    }

    @Override
    public Element getRoot() {
        charIndex = 0;
        return processing();
    }

    private Element processing() {
        Element currentElement, lastParsedElement, root = new Html();
        currentElement = lastParsedElement = root;
        for(; charIndex < DOCUMENT.length; charIndex++) {
            char currentChar = DOCUMENT[charIndex];
            if(currentChar == Parser.OPEN_BRACKET) {
                sb.setLength(0);
                readOpenTag();
                if(!sb.toString().contains("/")) {
                    sb.append(DOCUMENT[charIndex]);
                    System.out.println("--------------");
                    System.out.println(sb.toString());
                    System.out.println("--------------");
                    Element newElem = getElementByStringName(sb.toString());
                    if(newElem.getName().equals(ElementName.UNKNOWN)) {
                        continue;
                    }
                    elementNames.add(newElem.getName());
                    currentElement.addChild(newElem);
                    newElem.setParent(currentElement);
                    handleSiblings(lastParsedElement, newElem);
                    currentElement = newElem;
                } else if(!elementNames.isEmpty()) {
                    elementNames.removeLast();
                    lastParsedElement = currentElement;
                    currentElement = currentElement.getParent();
                }
            }
        }
        return root;
    }

    private void handleSiblings(Element first, Element second) {
        if(first.getParent() != null && first.getParent().equals(second.getParent())) {
            first.append(second);
            second.prepend(first);
        }
    }

    private Element getElementByStringName(String elem) {
        return elementFactory.getElementByName(validate(elem.toLowerCase()));
    }

    private ElementName validate(String name) {
        Pattern pattern = Pattern.compile("\\w*");//Pattern.compile("<(\\\"[^\\\"]*\\\"|'[^']*'|[^'\\\">])*>");
        Matcher matcher = pattern.matcher(name);
        if(matcher.find(1)) {
            return ElementName.valueOf(matcher.group().trim().toUpperCase());
        }
        return ElementName.UNKNOWN;
    }

    private void readOpenTag() {
        do {
            sb.append(DOCUMENT[charIndex]);
        } while (DOCUMENT[++charIndex] != Parser.CLOSE_BRACKET);
    }
}

//(?<=>)[\n\s]*\w.*
