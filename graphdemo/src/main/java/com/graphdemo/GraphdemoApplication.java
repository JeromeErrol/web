package com.graphdemo;

import com.graphdemo.model.Character;
import com.graphdemo.model.Item;
import com.graphdemo.model.ItemType;
import com.graphdemo.repositories.CharacterRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@SpringBootApplication
public class GraphdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphdemoApplication.class, args);
    }

    @Bean
    public CharacterRepository characterRepository() {

        Character jerome = new Character("Jerome", 26);
        Character bill = new Character("Bill", 15);
        Character mary = new Character("Mary", 30);

        jerome.getItems().add(new Item("sword", 10, ItemType.EQUIPPABLE));
        jerome.getItems().add(new Item("shield", 5, ItemType.EQUIPPABLE));
        jerome.getItems().add(new Item("Health Potion", 1, ItemType.CONSUMABLE));
        jerome.getItems().add(new Item("Mana Potion", 1, ItemType.CONSUMABLE));

        return new CharacterRepository(Arrays.asList(jerome, bill, mary));
    }
}
