package com.giga.crawler.integration.core;

import com.giga.crawler.core.Giga;
import com.giga.crawler.model.element.Element;
import com.giga.crawler.model.element.ElementName;
import org.junit.Test;
import util.ResourceLoader;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Sem Babenko
 */
public class GigaIntegrationTest extends IntegrationTest {

    private final String SIMPLE_HTML = "integration/simple-html.html";

    @Test
    public void testSimplePageParsing() throws Exception {

        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_HTML)).getRoot();
        List<Element> children = root.getChildren();
        assertThat(children.size(), equalTo(2));
        Element body = children.get(1);
        assertThat(body.getName(), equalTo(ElementName.BODY));
        List<Element> bodyChildren = body.getChildren();
        assertThat(bodyChildren.size(), equalTo(1));
        Element div = bodyChildren.get(0);
        assertThat(div.getName(), equalTo(ElementName.DIV));

    }

}
