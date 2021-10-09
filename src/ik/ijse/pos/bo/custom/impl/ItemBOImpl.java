/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.bo.custom.impl;

import ik.ijse.pos.bo.custom.CustomerBO;
import ik.ijse.pos.bo.custom.ItemBO;
import ik.ijse.pos.dao.DAOFactry;
import ik.ijse.pos.dao.custom.CustomerDAO;
import ik.ijse.pos.dao.custom.ItemDAO;
import ik.ijse.pos.dto.CustomerDTO;
import ik.ijse.pos.dto.ItemDTO;
import ik.ijse.pos.entity.Customer;
import ik.ijse.pos.entity.Item;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class ItemBOImpl implements ItemBO {

    static ItemDAO itemDAO= (ItemDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.ITEM);


    @Override
    public boolean addItem(ItemDTO itemDTO) throws ClassNotFoundException, SQLException {
        return itemDAO.add(new Item(itemDTO.getCode(),itemDTO.getName(),itemDTO.getPrice()));

    }
}
