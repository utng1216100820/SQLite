package com.own.sqlite1.sqlite;


import java.util.UUID;

/**
 * Created by devtacho on 9/03/18.
 */

public class Contract {
    interface OrderHeaderColumns{
        String ID = "id";
        String DATE = "record_date";
        String ID_CUSTOMER = "id_customer";
        String ID_METHOD_PAYMENT = "id_method_payment";
    }

    interface OrderDetailColumns{
        String ID = "id";
        String SEQUENCE = "sequence";
        String ID_PRODUCT = "id_product";
        String QUANTITY = "quantity";
        String PRICE = "price";
    }

    interface ProductColumns{
        String ID = "id";
        String NAME = "name";
        String PRICE = "price";
        String STOCK = "stock";
    }

    interface  CustomerColumns{
        String ID = "id";
        String FIRSTNAME = "firstname";
        String LASTNAME = "lastname";
        String PHONE = "phone";
    }

    interface MethodPaymentColumns{
        String ID = "id";
        String NAME = "name";
    }
    interface  SupplierColumns{
        String ID = "id";
        String FIRSTNAME = "firstname";
        String LASTNAME = "lastname";
        String TYPE = "type";
    }

    //Series - start
    interface SerieColumns{
        String ID = "id";
        String NAME = "name";
        String CREATOR = "creator";
        String GENDER = "gender";
        String YEAR = "year";
        String CHAPTERS = "chapters";
    }
    //Series - end

    public static class OrderHeaders implements OrderHeaderColumns{
        public static String generateIdOrderHeader(){
            return  "OH-"+ UUID.randomUUID().toString();
        }
    }


    public static class OrderDetails implements OrderDetailColumns{

    }

    public static class Products implements ProductColumns{
        public static String generateIdProduct(){
            return  "PR-"+ UUID.randomUUID().toString();
        }
    }

    public static class Customers implements CustomerColumns{
        public static String generateIdCustomer(){
            return  "CU-"+ UUID.randomUUID().toString();
        }
    }

    public static class MethodsPayment implements MethodPaymentColumns{
        public static String generateIdMethodPayment(){
            return  "MP-"+ UUID.randomUUID().toString();
        }
    }
    public static class Suppliers implements SupplierColumns{
        public static String generateIdSupplier(){
            return  "CU-"+ UUID.randomUUID().toString();
        }
    }

    //Series method start
    public static class Series implements SerieColumns{
        public static String generateIdSerie(){
            return  "SG-"+ UUID.randomUUID().toString();
        }
    }
    //Series method end

    private Contract() {}

}//End
