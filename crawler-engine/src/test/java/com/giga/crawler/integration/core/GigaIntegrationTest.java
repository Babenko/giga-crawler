package com.giga.crawler.integration.core;

import com.giga.crawler.core.Giga;
import com.giga.crawler.model.element.Element;
import com.giga.crawler.model.element.ElementName;
import org.junit.Test;
import util.ResourceLoader;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

/**
 * @author Sem Babenko
 */
public class GigaIntegrationTest extends IntegrationTest {

    private final String SIMPLE_HTML = "integration/simple.html";
    private final String SIMPLE_SIBLING_HTML = "integration/simple-sibling.html";
    private final String SIMPLE_PAYLOAD_HTML = "integration/simple-payload.html";

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

    @Test
    public void testSimplePageWithSiblings() throws Exception {
        
        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_SIBLING_HTML)).getRoot();
        assertNull(root.getNext());
        assertNull(root.getPrevious());

        Element div = root.getChildren()
                .stream()
                .filter(element -> element.getName().equals(ElementName.BODY))
                .flatMap(element -> element.getChildren().stream())
                .filter(element -> element.getName().equals(ElementName.DIV))
                .findFirst()
                .orElse(null);

        assertNotNull(div);
        assertThat(div.getPrevious().getName(), equalTo(ElementName.H1));
        assertThat(div.getNext().getName(), equalTo(ElementName.SPAN));
        
        Element h1 = div.getPrevious();
        assertThat(h1.getNext().getName(), equalTo(ElementName.DIV));
        assertNull(h1.getPrevious());

        Element span = div.getNext();
        assertThat(span.getPrevious().getName(), equalTo(ElementName.DIV));
        assertNull(span.getNext());
    }

    @Test
    public void testSimpleElementPayload() throws Exception {
        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_HTML)).getRoot();

        Element div = root.getChildren()
                .stream()
                .filter(element -> element.getName().equals(ElementName.BODY))
                .flatMap(element -> element.getChildren().stream())
                .filter(element -> element.getName().equals(ElementName.DIV))
                .findFirst()
                .orElse(null);

        assertThat(div, notNullValue());

        assertThat(div.getPayload().trim(), equalTo("simple html"));
    }

    @Test
    public void testSimplePageWithSiblingsPayload() throws Exception {

        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_SIBLING_HTML)).getRoot();
        assertNull(root.getNext());
        assertNull(root.getPrevious());

        Element div = root.getChildren()
                .stream()
                .filter(element -> element.getName().equals(ElementName.BODY))
                .flatMap(element -> element.getChildren().stream())
                .filter(element -> element.getName().equals(ElementName.DIV))
                .findFirst()
                .orElse(null);

        assertNotNull(div);

        assertThat(div.getPayload().trim(), equalTo("simple div"));

        Element h1 = div.getPrevious();

        assertThat(h1.getPayload().trim(), equalTo("Some header"));

        Element span = div.getNext();

        assertThat(span.getPayload().trim(), equalTo("simple span"));

    }

    @Test
    public void testSimplePayload() throws Exception {
        Element root = Giga.of(ResourceLoader.loadFile(SIMPLE_PAYLOAD_HTML)).getRoot();

        Element div = root.getChildren()
                .stream()
                .filter(element -> element.getName().equals(ElementName.BODY))
                .flatMap(element -> element.getChildren().stream())
                .filter(element -> element.getName().equals(ElementName.DIV))
                .findFirst()
                .orElse(null);

        assertThat(div, notNullValue());

        assertThat(div.getChildren().get(0).getPayload().trim(), equalTo("span text"));

        String divPayload = div.getPayload();
        List<String> filteredPayload = Stream.of(divPayload.split("\n"))
                .map(String::trim)
                .filter(val -> !val.isEmpty())
                .collect(Collectors.toList());

        assertThat(filteredPayload.size(), equalTo(2));
        assertThat(filteredPayload, hasItems("before span", "after span"));
    }

}
