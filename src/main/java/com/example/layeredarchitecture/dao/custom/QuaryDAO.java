package com.example.layeredarchitecture.dao.custom;

import com.example.layeredarchitecture.model.CustomerOrderDetailsDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface QuaryDAO {
    ArrayList<CustomerOrderDetailsDTO> customerOrderDetails() throws SQLException, ClassNotFoundException;
}
