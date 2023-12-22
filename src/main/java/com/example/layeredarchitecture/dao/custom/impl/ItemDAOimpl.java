package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.ItemDAO;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.*;
import java.util.ArrayList;

 public class ItemDAOimpl implements ItemDAO {
    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exucute("SELECT * FROM Item");
        ArrayList<ItemDTO> allItems = new ArrayList<>();

        while (rst.next()){
            ItemDTO itemDTO = new ItemDTO(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand")
            );
            allItems.add(itemDTO);
        }
        return allItems;
    }

    @Override
    public boolean delete(String code) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("DELETE FROM Item WHERE code=?",code);
    }

    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(), dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand());
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?", dto.getDescription(), dto.getUnitPrice(), dto.getQtyOnHand(), dto.getCode());
    }

    @Override
    public boolean exist(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exucute("SELECT code FROM Item WHERE code=?", code);
        return rst.next();
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exucute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }
    }

    @Override
    public ItemDTO search(String code) throws SQLException, ClassNotFoundException {
        ResultSet rst = SQLUtil.exucute("SELECT * FROM Item WHERE code=?", code);

        rst.next();
        return new ItemDTO(
                code,
                rst.getString("description"),
                rst.getBigDecimal("unitPrice"),
                rst.getInt("qtyOnHand"));
    }
}
