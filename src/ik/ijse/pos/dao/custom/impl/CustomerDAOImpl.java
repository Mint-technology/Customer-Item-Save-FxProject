/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.dao.custom.impl;

import ik.ijse.pos.dao.CrudUtil;
import ik.ijse.pos.dao.custom.CustomerDAO;
import ik.ijse.pos.entity.Customer;
import javafx.collections.ObservableList;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class CustomerDAOImpl implements CustomerDAO {
    @Override
    public boolean add(Customer customer) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO Customer VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,customer.getNic(),customer.getName(),customer.getEmail(),customer.getAddress());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Customer customer) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Customer search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Customer> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}
