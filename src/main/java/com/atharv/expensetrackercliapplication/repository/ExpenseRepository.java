package com.atharv.expensetrackercliapplication.repository;

import com.atharv.expensetrackercliapplication.beans.Expense;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ExpenseRepository {
    private final JdbcTemplate springJdbcTemplate;

    public ExpenseRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }

    private static String INSERT_QUERY = """
            insert into expense values(?,?,?,?,?);
            """;

    private static String DELETE_QUERY = """
            delete from expense where id = ?;
            """;

    private static String UPDATE_QUERY = """
            update expense set amount = ?, category = ?, date = ?, description= ? where id =?;
            """;

    private static String READ_QUERY = """
            select * from expense;
            """;

    private static String CHECK_QUERY = """
            select id from expense where id = ?;
            """;

    public void insert(int id, Expense expense) {
        springJdbcTemplate.update(INSERT_QUERY, id, expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getDescription());
    }

    public void deleteById(int id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public void updateById(int id, Expense expense) {
        springJdbcTemplate.update(UPDATE_QUERY, expense.getAmount(), expense.getCategory(), expense.getDate(), expense.getDescription(),id);
    }

    public void readALl() {
        springJdbcTemplate.query(READ_QUERY, (ResultSet rs) -> {
            try {
                if (rs != null)
                    do {
                        System.out.println("ID: " + rs.getInt("id"));
                        System.out.println("Amount: " + rs.getInt("amount"));
                        System.out.println("Category: " + rs.getString("category"));
                        System.out.println("Date: " + rs.getString("date"));
                        System.out.println("Description: " + rs.getString("description"));
                        System.out.println();
                    } while (rs.next());
            } catch (SQLException e) {
                System.out.println(e);
            }
        });
    }

    public Boolean checkId(int id) {
        try {
            springJdbcTemplate.queryForObject(CHECK_QUERY, Integer.class, id);
            return true;
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

}
