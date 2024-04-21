package com.atharv.expensetrackercliapplication.repository;

import com.atharv.expensetrackercliapplication.beans.Income;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class IncomeRepository {
    private final JdbcTemplate springJdbcTemplate;

    public IncomeRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    private static String INSERT_QUERY = """
            insert into income values(?,?,?);
            """;

    private static String DELETE_QUERY= """
            delete from income where id = ?;
            """;

    private static String UPDATE_QUERY = """
            update income set amount = ?, source = ? where id = ?;
            """;

    private static String READ_QUERY= """
            select * from income;
            """;

    private static String CHECK_QUERY= """
            select id from income where id = ?;
            """;

    public void insert(int id, Income income){
        springJdbcTemplate.update(INSERT_QUERY,id,income.getAmount(),income.getSource());
    }

    public void deleteById(int id){
        springJdbcTemplate.update(DELETE_QUERY,id);
    }

    public void updateById(int id, Income income){
        springJdbcTemplate.update(UPDATE_QUERY,income.getAmount(),income.getSource(),id);
    }
    public void readALl(){
        springJdbcTemplate.query(READ_QUERY,(ResultSet rs)->{
            try {
                if (rs != null)
                    do {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Amount: " + rs.getInt("amount"));
                        System.out.println("Source: " + rs.getString("source"));
                        System.out.println();
                    } while (rs.next());
            }
            catch (SQLException e){
                System.out.println(e);
            }
        });
    }
    public Boolean checkId(int id){
        try {
            springJdbcTemplate.queryForObject(CHECK_QUERY,Integer.class,id);
            return  true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
