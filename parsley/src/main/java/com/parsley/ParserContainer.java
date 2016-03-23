package com.parsley;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParserContainer {

    private Map<Class, Map<Class, Parser>> adapterMap;

    public ParserContainer(List<Parser> adapters) {
        adapterMap = new HashMap<Class, Map<Class, Parser>>();
        for (Parser adapter : adapters) {
            add(adapter);
        }
    }

    private void add(Parser adapter) {
        Map<Class, Parser> objectAdapters = adapterMap.get(adapter.getObjectClass());
        if (objectAdapters == null) {
            objectAdapters = new HashMap<Class, Parser>();
            adapterMap.put(adapter.getObjectClass(), objectAdapters);
        }
        objectAdapters.put(adapter.getTargetClass(), adapter);
    }

    public <T> T parse(Object object, Class T) {
        if (object != null) {
            Map<Class, Parser> objectAdapters = adapterMap.get(object.getClass());
            Parser adapter = objectAdapters.get(T);
            if (adapter != null) {
                return (T) adapter.parse(object);
            } else {
                throw new RuntimeException("No parser found to parse type " + object.getClass().getCanonicalName() + " to " + T.getCanonicalName());
            }
        }
        return null;
    }
}
