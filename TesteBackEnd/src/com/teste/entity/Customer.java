
package com.teste.entity;

import java.math.BigDecimal;

/**
 * Model customer com encapsulamento
 * @author Arthur
 */
public class Customer {
    
    private Long id_customer;
    
    private String cpf_cnpj;
    
    private String nm_customer;
    
    private boolean is_active;
    
    private BigDecimal vl_total;

    public Long getId_customer() {
        return id_customer;
    }

    public void setId_customer(Long id_customer) {
        this.id_customer = id_customer;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public String getNm_customer() {
        return nm_customer;
    }

    public void setNm_customer(String nm_customer) {
        this.nm_customer = nm_customer;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public BigDecimal getVl_total() {
        return vl_total;
    }

    public void setVl_total(BigDecimal vl_total) {
        this.vl_total = vl_total;
    }

    public Customer(Long id_customer, String cpf_cnpj, String nm_customer, boolean is_active, BigDecimal vl_total) {
        this.id_customer = id_customer;
        this.cpf_cnpj = cpf_cnpj;
        this.nm_customer = nm_customer;
        this.is_active = is_active;
        this.vl_total = vl_total;
    }

    public Customer() {
    }
    
    
    
    
}
