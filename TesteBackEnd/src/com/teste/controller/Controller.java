package com.teste.controller;

import com.teste.dao.Customer_DAO;
import com.teste.entity.Customer;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class Controller{

    private Customer_DAO dao = new Customer_DAO();
    
    public void logicaTeste() throws SQLException, ClassNotFoundException {

        // Insere clientes com id fora da extensão de 1500 e 2700
        for (int i = 0; i < 5; i++) {

            // Set Informações do customer
            Long id = (long) i;

            Customer c = new Customer(
                    id,
                    "50457732598",
                    "Joselito",
                    true,
                    new BigDecimal("561.00"));

            dao.insert(c);

        }

        // Insere clientes com id 1500 ha 1550
        for (int i = 1500; i < 1551; i++) {

            // Set Informações do customer
            Long id = (long) i;

            Customer c = new Customer(
                    id,
                    "50457732598",
                    "Joselito",
                    true,
                    new BigDecimal("561.00"));

            dao.insert(c);

        }

        // Calcula media dos clientes com vl_total > 560 e id dentro da extensão de 1500 e 2700;
        BigDecimal media = dao.media();
        //Imprime media
        System.out.println("Média = " + media);

        // Lista dos clientes com vl_total > 560 e id dentro da extensão de 1500 e 2700
        ArrayList<Customer> listar = dao.listar();
        // Mensagem
        System.out.println("-----Clientes que participaram do calculo-----");
        // Lista cliente pelo id
        for (Customer customer : listar) {
            System.out.println("ID: " + customer.getId_customer());
        }

    }

}
