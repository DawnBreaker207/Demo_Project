package com.example.demo.repository;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
    List<T> getAll() throws SQLException;

    T getOne(long id) throws SQLException;

    T create(T t) throws SQLException;

    T update(T t) throws SQLException;

    void delete(long id) throws SQLException;
}
