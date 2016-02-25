package com.example.web;

import com.example.domain.Entry;
import com.example.domain.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/entries")
@RestController
public class EntryController {

    @Autowired
    EntryRepository entryRepository;

    @Autowired
    EntryResourceAssembler entryResourceAssembler;

    @RequestMapping(value = "/{entryId}", method = RequestMethod.GET)
    public Resource<Entry> select(@PathVariable Long entryId) {
        Entry entry = entryRepository.findById(entryId);
        return entryResourceAssembler.toResource(entry);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Resource<Entry> create(@RequestBody Entry entry) {
        entryRepository.save(entry);
        return entryResourceAssembler.toResource(entry);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable Long entryId) {
        entryRepository.delete(entryId);
    }
}
