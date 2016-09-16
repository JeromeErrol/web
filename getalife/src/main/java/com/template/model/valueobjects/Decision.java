package com.template.model.valueobjects;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Decision {
    /***
     * If haven't fasted in over a walk then fast
     * <p>
     * If haven't worked out in over three days and not fasting then workout
     * <p>
     * If haven't cold showered in over three days then cold shower
     * <p>
     * If haven't Skyped with Maxime in over two weeks and is Saturday or is Sunday morning then skype her
     * <p>
     * If haven't written a micro story in few days then write micro story
     */


    public static String getName() {
        return "Jerome";
    }

    @Test
    public void testB(){
        Integer blep = null;
        Optional<Integer> optInt = Optional.ofNullable(blep);
        optInt.orElse(new Integer(10));
        System.out.println(optInt.get());

    }

    private static List<String> names = new ArrayList<>();

    public static void addToList(String name) {
        if (names == null) {
            names = new ArrayList<>();
        }
        names.add(name);
    }

    @Test
    public void test() {
        Consumer<String> stringConsumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> blep = name -> names.add(name + "blep");

        List namesA = new ArrayList<>();
        Supplier<String> nameSupplier = Decision::getName;
        namesA.add(nameSupplier.get());
        namesA.add("Tom");
        namesA.add("Sally");
        namesA.parallelStream().forEach(Decision::doSomething);
    }

    private static void doSomething(Object o) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }

    public static String addBlep(String o) {
        return o + "blep";
    }

}
