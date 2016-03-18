package com.market.service.stock;

import com.market.domain.Category;
import com.market.domain.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class StockSearchCriteria {

    @Getter
    @Setter
    private Pageable pageable;

    @Getter
    @Setter
    private List<Long> categories;

    @Getter
    @Setter
    private Double price;

    @Getter
    @Setter
    private Double discount;

    @Getter
    @Setter
    private String title;
}
