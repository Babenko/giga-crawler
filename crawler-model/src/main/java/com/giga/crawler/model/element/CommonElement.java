package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Sem Babenko
 */
public abstract class CommonElement implements Element {

    protected List<Attribute> attributes;

    protected String payload = "";

    protected List<Element> children = new ArrayList<>();

    protected Element parent;

    protected Element previous;

    protected Element next;

    @Override
    public List<Element> getChildren() {
        return children;
    }

    @Override
    public String getPayload() {
        return payload;
    }

    @Override
    public List<Attribute> getAttributes() {
        return attributes;
    }

    @Override
    public void addChild(Element child) {
        children.add(child);
    }

    @Override
    public Element getParent() {
        return parent;
    }

    @Override
    public void setParent(Element parent) {
        this.parent = parent;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public Element getNext() {
        return next;
    }

    @Override
    public Element getPrevious() {
        return previous;
    }

    @Override
    public void append(Element element) {
        next = element;
    }

    @Override
    public void prepend(Element element) {
        previous = element;
    }

    @Override
    public void setPayload(String payload) {
        Objects.requireNonNull(payload);
        this.payload += payload + System.lineSeparator();
    }
}
