/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.dao.custom.impl;

import ik.ijse.pos.dao.CrudUtil;
import ik.ijse.pos.dao.custom.ItemDAO;
import ik.ijse.pos.entity.Item;
import javafx.collections.ObservableList;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class ItemDAOImpl implements ItemDAO {
    @Override
    public boolean add(Item item) throws ClassNotFoundException, SQLException {
        String SQL = "INSERT INTO Item VALUES (?,?,?,?)";
        return CrudUtil.executeUpdate(SQL,item.getCode(),item.getName(),item.getPrice());
    }

    @Override
    public boolean delete(String s) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public boolean update(Item item) throws ClassNotFoundException, SQLException {
        return false;
    }

    @Override
    public Item search(String s) throws ClassNotFoundException, SQLException {
        return null;
    }

    @Override
    public ObservableList<Item> getAll() throws ClassNotFoundException, SQLException {
        return null;
    }
}
