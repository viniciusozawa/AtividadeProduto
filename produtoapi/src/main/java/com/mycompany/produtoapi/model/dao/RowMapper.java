/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.produtoapi.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author yuji
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
