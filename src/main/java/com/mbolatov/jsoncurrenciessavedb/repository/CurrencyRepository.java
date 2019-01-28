package com.mbolatov.jsoncurrenciessavedb.repository;

import com.mbolatov.jsoncurrenciessavedb.model.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {
}