package org.example.service;


import org.example.dao.IncomeDao;
import org.example.entity.Income;

import java.math.BigDecimal;
import java.time.LocalDate;

public class IncomeService {

    private static Income income = new Income();

    private static IncomeDao incomeDao = new IncomeDao();

public static void addIncome(BigDecimal kwota, LocalDate dataDodania, String komentarz){
    if(income.getDataDodania() != null && income.getKwota() != null){
    Income income = new Income(null, kwota, dataDodania,komentarz);
    incomeDao.save(income);
    }

}

}
