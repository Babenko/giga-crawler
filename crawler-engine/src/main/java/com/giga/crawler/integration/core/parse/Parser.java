package com.giga.crawler.integration.core.parse;

import com.giga.crawler.model.element.Element;

/**
 * @author Sem Babenko
 */
public interface Parser {

    char OPEN_BRACKET = '<';

    char CLOSE_BRACKET = '>';

    char CLOSE_ELEMENT = '/';

    Element getRoot();
}
