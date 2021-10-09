/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.bo.custom.impl;

import ik.ijse.pos.bo.custom.CustomerBO;
import ik.ijse.pos.dao.DAOFactry;
import ik.ijse.pos.dao.custom.CustomerDAO;
import ik.ijse.pos.dto.CustomerDTO;
import ik.ijse.pos.entity.Customer;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class CustomerBOImpl implements CustomerBO {

    static CustomerDAO customerDAO= (CustomerDAO) DAOFactry.getInstance().getDAO(DAOFactry.DAOType.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) throws ClassNotFoundException, SQLException {
        return customerDAO.add(new Customer(customerDTO.getNic(),customerDTO.getName(),customerDTO.getEmail(),customerDTO.getAddress()));
    }
}
