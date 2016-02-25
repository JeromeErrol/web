package com.example.web;

import com.example.domain.Entry;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class EntryResourceAssembler implements ResourceAssembler<Entry, Resource<Entry>> {
    @Override
    public Resource<Entry> toResource(Entry entry) {
        Resource<Entry> entryResource = new Resource<Entry>(entry);
        entryResource.add(linkTo(UserController.class).slash(entry.getId()).withSelfRel());
        return entryResource;
    }
}
