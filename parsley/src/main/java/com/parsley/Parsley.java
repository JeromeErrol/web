package com.parsley;

import java.util.ArrayList;
import java.util.List;

public class Parsley {

    public ParserContainer parserContainer;

    private static Parsley INSTANCE = new Parsley();

    public Parsley() {
        parserContainer = new ParserContainer(getPrimitiveParsers());
    }

    public static <T> T parse(Object object, Class<T> klass) {
        return INSTANCE.parserContainer.parse(object, klass);
    }

    private List<Parser> getPrimitiveParsers() {
        List<Parser> parsers = new ArrayList<Parser>();
        return parsers;
    }
}
