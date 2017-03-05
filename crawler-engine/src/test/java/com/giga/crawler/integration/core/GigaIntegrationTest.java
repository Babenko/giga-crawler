package com.giga.crawler.integration.core;

import com.giga.crawler.model.element.Element;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import util.ResourceLoader;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Sem Babenko
 */
public class GigaIntegrationTest extends IntegrationTest {

    private final String SIMPLE_HTML = "integration/simple-html.html";

    @Test
    public void testSimplePageParsing() throws Exception {

        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_HTML)).getRoot();
        List<Element> children = root.getChildren();
        assertThat(children.size(), Matchers.equalTo(2));

    }

}
