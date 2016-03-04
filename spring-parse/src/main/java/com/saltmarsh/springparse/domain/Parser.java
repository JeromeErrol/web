package com.saltmarsh.springparse.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Parser {

    private Map<Class, Map<Class, IParse>> adapterMap;

    public Parser(List<IParse> adapters) {
        adapterMap = new HashMap<>();
        for (IParse adapter : adapters) {
            add(adapter);
        }
    }

    private void add(IParse adapter) {
        Map<Class, IParse> objectAdapters = adapterMap.get(adapter.getObjectClass());
        if (objectAdapters == null) {
            objectAdapters = new HashMap<>();
            adapterMap.put(adapter.getObjectClass(), objectAdapters);
        }
        objectAdapters.put(adapter.getTargetClass(), adapter);
    }

    public <T> T parse(Object object, Class T) {
        if (object != null) {
            Map<Class, IParse> objectAdapters = adapterMap.get(object.getClass());
            IParse adapter = objectAdapters.get(T);
            if (adapter != null) {
                return (T) adapter.parse(object);
            } else {
                throw new RuntimeException("No parser found to parse type " + object.getClass().getCanonicalName() + " to " + T.getCanonicalName());
            }
        }
        return null;
    }
}
