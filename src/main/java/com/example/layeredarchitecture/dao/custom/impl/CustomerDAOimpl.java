package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOimpl implements CustomerDAO {
    @Override
    public ArrayList<CustomerDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.exucute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomers = new ArrayList<>();

        while (rst.next()){
            CustomerDTO customerDTO = new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address")
            );
            allCustomers.add(customerDTO);
        }
        return allCustomers;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)", dto.getId(), dto.getName(), dto.getAddress());
    }

    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("UPDATE Customer SET name=?, address=? WHERE id=?", dto.getName(), dto.getAddress(), dto.getId());
    }

    @Override
    public boolean exist(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exucute("SELECT id FROM Customer WHERE id=?", id);
        return rst.next();
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("DELETE FROM Customer WHERE id=?", id);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {

        ResultSet rst = SQLUtil.exucute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }
    }

    @Override
    public CustomerDTO search(String id) throws SQLException, ClassNotFoundException {
       ResultSet rst = SQLUtil.exucute("SELECT * FROM customer WHERE id=?",id);

        if (rst.next()) {
            return new CustomerDTO(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3)
            );
        }
        return null;
    }
}
