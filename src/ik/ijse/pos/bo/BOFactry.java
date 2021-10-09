/*
 *
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) Mint. All rights reserved.
 *  *  Licensed under the  Sri Lankan Information License. See License.txt in the project root for license information.
 *  *--------------------------------------------------------------------------------------------
 */

package ik.ijse.pos.bo;


import ik.ijse.pos.bo.custom.impl.CustomerBOImpl;

/**
 * @author Sandun Prabashana <sandunprabashana@gmail.com> (prabashana.tk/)
 * @since 10/9/2021
 */
public class BOFactry {

    private static BOFactry boFactry;

    private BOFactry(){

    }

    public static BOFactry getInstance(){
        if(boFactry==null){
            boFactry=new BOFactry();
        }
        return boFactry;
    }

    public enum BOTypes{
        CUSTOMER,
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            default:
                return null;
        }
    }
}

