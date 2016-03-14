package com.market.service.stock;

import com.market.domain.Stock;
import com.market.web.StockController;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Component
public class StockResourceAssembler implements ResourceAssembler<Stock, Resource<Stock>> {

    @Override
    public Resource<Stock> toResource(Stock stock) {
        Resource<Stock> resource = new Resource<Stock>(stock);
        resource.add(linkTo(StockController.class).slash(stock.getId()).withSelfRel());
        return resource;
    }
}
