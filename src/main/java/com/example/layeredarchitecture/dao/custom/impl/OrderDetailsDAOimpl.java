package com.example.layeredarchitecture.dao.custom.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;

public class OrderDetailsDAOimpl implements OrderDetailsDAO {
    @Override
    public boolean saveOrderDetail(String orderId, OrderDetailDTO detail) throws SQLException, ClassNotFoundException {
        return SQLUtil.exucute("INSERT INTO orderdetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)",orderId,detail.getItemCode(),detail.getUnitPrice(),detail.getQty());

    }
}
