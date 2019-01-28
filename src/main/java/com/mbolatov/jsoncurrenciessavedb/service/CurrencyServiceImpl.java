package com.mbolatov.jsoncurrenciessavedb.service;

import com.mbolatov.jsoncurrenciessavedb.model.Currency;
import com.mbolatov.jsoncurrenciessavedb.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public void add(Currency currency) {
        currencyRepository.save(currency);
    }

    @Override
    public void update(Currency currency) {
        Currency currencyUpdate = currencyRepository.findOne(currency.getId());
        currencyUpdate.setName_kaz(currency.getName_kaz());
        currencyUpdate.setName_rus(currency.getName_rus());
        currencyUpdate.setCodename(currency.getCodename());
        currencyUpdate.setUnit(currency.getUnit());
        currencyUpdate.setRatio(currency.getRatio());
        currencyUpdate.setRate(currency.getRate());
        currencyRepository.save(currencyUpdate);
    }

    @Override
    public void delete(int currencyId) {
        currencyRepository.delete(currencyId);
    }

    @Override
    public Currency get(int currencyId) {
        return currencyRepository.findOne(currencyId);
    }

    @Override
    public List<Currency> getAll() {
        Iterable<Currency> iterable = currencyRepository.findAll();
        return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
    }
}
