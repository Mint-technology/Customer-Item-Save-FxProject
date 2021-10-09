/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.dao;

import ik.ijse.pos.dao.custom.impl.CustomerDAOImpl;
import ik.ijse.pos.dao.custom.impl.ItemDAOImpl;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class DAOFactry {
    private static DAOFactry daoFactry;

    private DAOFactry(){}

    public static DAOFactry getInstance(){
        if(daoFactry==null){
            daoFactry=new DAOFactry();
        }
        return daoFactry;
    }

    public enum DAOType{
        CUSTOMER,ITEM
    }

    public SuperDAO getDAO (DAOType daoType){
        switch (daoType){
            case CUSTOMER:
                return new CustomerDAOImpl();
            case ITEM:
                return new ItemDAOImpl();
            default:
                return null;
        }
    }
}

