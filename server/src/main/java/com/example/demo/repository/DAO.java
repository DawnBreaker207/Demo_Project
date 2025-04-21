package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    public List<T> getAll() throws SQLException;

    public T getOne(long id) throws SQLException;

    public T create(T t) throws SQLException;

    public T update(T t) throws SQLException;

    public void delete(int id) throws SQLException;
}
