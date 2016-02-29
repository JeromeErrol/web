package com.example.web;

import com.example.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping("/entries")
@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    EntryResourceAssembler entryResourceAssembler;

    @RequestMapping(value = "/{entryId}", method = RequestMethod.GET)
    public Resource<Entry> select(@PathVariable Long entryId) {
        Entry entry = entryRepository.findById(entryId);
        return entryResourceAssembler.toResource(entry);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Resource<Entry> create(@RequestBody EntryTag entryTag) {
        Entry entry = entryRepository.save(entryTag.entry);
        for (String tagWord : entryTag.tags) {
            Tag tag = new Tag(entry.getId(), tagWord);
            tagRepository.save(tag);
        }
        return entryResourceAssembler.toResource(entry);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable Long entryId) {
        entryRepository.delete(entryId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/find")
    public List<Entry> findByTags(@RequestBody TagList tags) {
        List<Entry> entries = new ArrayList<>();
        for (String tag : tags.tags) {
            List<Tag> tagList = tagRepository.findByWord(tag);

            for (Tag tagItem : tagList) {
                Entry entry = entryRepository.findById(tagItem.getEntryId());
                entries.add(entry);
            }
        }
        return entries;
    }
}
