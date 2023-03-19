package org.example.service;


import org.example.DBConnection;
import org.example.dao.IncomeDao;
import org.example.dto.IncomeDto;
import org.example.entity.Income;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class IncomeService {

    private static Income income = new Income();

    private static IncomeDao incomeDao = new IncomeDao();

public static boolean addIncome(BigDecimal kwota, LocalDate dataDodania, String komentarz){
    if(dataDodania != null && kwota != null){
    Income income = new Income(kwota, dataDodania,komentarz);
    incomeDao.save(income);
    return true;
    }
    return false;


}

    public List<IncomeDto> getIncomes() {
        List<Income> incomes = incomeDao.findAll();
        return incomes.stream().map(i -> new IncomeDto(i.getId(), i.getKwota(), i.getDataDodania(), i.getKomentarz())).toList();
    }

    public void deleteById(int selectedId) {
        if (selectedId > 0) {
            incomeDao.deleteById(selectedId);
        } else {
            throw new IllegalArgumentException("id can not be lower than 0");
        }
    }





}
