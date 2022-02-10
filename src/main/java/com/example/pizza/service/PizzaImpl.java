package com.example.pizza.service;

import com.example.pizza.model.Pizza;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PizzaImpl implements PizzaService {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<Pizza> list() {
        String sql ="SELECT img * FROM pizza";
        List<Pizza> listSale = jdbcTemplate.query(sql,
                BeanPropertyRowMapper.newInstance(Pizza.class));
        return listSale;
    }

    @Override
    public void save(Pizza pizza) {
        SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
        insertActor.withTableName("pizza").usingColumns("img");
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pizza);

        insertActor.execute(param);
    }

    @Override
    public Pizza get(int id) {
        String sql = "SELECT * FROM pizza WHERE id = ?";
        Object[] args = {id};
        return jdbcTemplate.queryForObject(sql, args,
                BeanPropertyRowMapper.newInstance(Pizza.class));
    }

    @Override
    public void update(Pizza pizza) {
        String sql = "UPDATE pizza SET item=:item, quantity=:quantity, amount=:amount WHERE id=:id";
        BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(pizza);
        NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
        template.update(sql, param);
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM pizza WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void insert(Pizza citizen) {

    }
}
