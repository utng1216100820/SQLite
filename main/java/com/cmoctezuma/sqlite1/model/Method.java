package com.own.sqlite1.model;

/**
 * Created by Marili Arevalo on 2/7/2017.
 */

public class Method {
    private String idCustomer;
    private String firstname;
    private String lastname;

    private String phone;

    public Method(String idCustomer, String firstname, String lastname, String phone) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;

        this.phone = phone;
    }

    public Method() {
        this("","","","");
    }




    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Method{" +
                "idCustomer='" + idCustomer + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
