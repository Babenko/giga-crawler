package com.giga.crawler.core;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import util.ResourceLoader;

/**
 * @author Sem Babenko
 */
@State(Scope.Thread)
public class GigaBhm {

    private final String SIMPLE_HTML_PATH = "integration/simple-html.html";

    private byte[] simple_html;

    @Setup
    public void setup() throws Exception {
        simple_html = ResourceLoader.loadFileAsStream(SIMPLE_HTML_PATH);
    }


    @Benchmark
    public void simplePageParsing() throws Exception {
        Giga.of(simple_html).getRoot();
    }
}
