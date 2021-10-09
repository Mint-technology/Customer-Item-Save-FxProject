/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.bo.custom;

import ik.ijse.pos.bo.SuperBO;
import ik.ijse.pos.dto.CustomerDTO;

import java.sql.SQLException;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public interface CustomerBO extends SuperBO {
    boolean addCustomer(CustomerDTO customerDTO)throws ClassNotFoundException, SQLException;
}
