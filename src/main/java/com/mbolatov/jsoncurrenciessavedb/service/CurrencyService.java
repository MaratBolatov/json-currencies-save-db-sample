package com.mbolatov.jsoncurrenciessavedb.service;

import com.mbolatov.jsoncurrenciessavedb.model.Currency;

import java.util.List;


    public interface CurrencyService {

        void add(Currency currency);
        void update(Currency currency);
        void delete(int currencyId);
        Currency get(int currencyId);
        List<Currency> getAll();

    }

