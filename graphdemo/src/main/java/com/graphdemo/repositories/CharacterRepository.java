package com.graphdemo.repositories;

import com.graphdemo.model.Character;

import java.util.List;

public class CharacterRepository {

    private List<Character> characters;

    public CharacterRepository(List<Character> characters) {
        this.characters = characters;
    }

    public Character findById(int id) {
        return characters.stream().filter(character -> character.getId() == id).findFirst().get();
    }

    public Character findByName(String name) {
        return characters.stream().filter(character -> character.getName().equalsIgnoreCase(name)).findFirst().get();
    }

    public Character add(String name, int age) {
        Character character = new Character(name, age);
        characters.add(character);
        return character;
    }
}
