package com.giga.crawler.model.element;

import com.giga.crawler.model.attribute.Attribute;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sem Babenko
 */
public abstract class CommonElement implements Element {

    protected List<Attribute> attributes;

    protected String payload;

    protected List<Element> children = new ArrayList<>();

    protected Element parent;

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
}
