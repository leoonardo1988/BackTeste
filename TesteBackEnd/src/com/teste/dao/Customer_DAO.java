package com.teste.dao;

import com.teste.config.ConnectAndClose;
import com.teste.entity.Customer;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe com as requisições com o banco de dados
 *
 * @author Arthur
 */
public class Customer_DAO {

    private ConnectAndClose db = new ConnectAndClose();

    /**
     * Insere o cliente
     *
     * @throws SQLException
     */
    public void insert(Customer c) throws SQLException, ClassNotFoundException {

        Connection dbConnection = null;

        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO tb_customer_account"
                + "(ID_CUSTOMER,"
                + " CPF_CNPJ,"
                + " NM_CUSTOMER,"
                + " IS_ACTIVE, "
                + " VL_TOTAL )"
                + " VALUES"
                + "(?,?,?,?,?)";

        try {

            dbConnection = ConnectAndClose.connection();

            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setFloat(1, c.getId_customer());
            preparedStatement.setString(2, c.getCpf_cnpj());
            preparedStatement.setString(3, c.getNm_customer());
            preparedStatement.setBoolean(4, c.isIs_active());
            preparedStatement.setBigDecimal(5, c.getVl_total());

            preparedStatement.execute();

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            dbConnection.rollback();

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    /**
     * Lista os clientes pela regra de negocio
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public ArrayList<Customer> listar() throws SQLException, ClassNotFoundException {

        Connection connection  = null;

        connection = ConnectAndClose.connection();
        
        PreparedStatement preparedStatement = null;

        ArrayList<Customer> lista = new ArrayList<>();

        String slq = "SELECT * FROM tb_customer_account "
                + " WHERE vl_total > 560 "
                + "AND id_customer > 1499 "
                + "AND id_customer < 2701";

        preparedStatement = connection.prepareStatement(slq);

        ResultSet result = preparedStatement.executeQuery();
        
        while (result.next()) {

            Customer c = new Customer(
                    result.getLong("id_customer"),
                    result.getString("cpf_cnpj"),
                    result.getString("nm_customer"),
                    result.getBoolean("is_active"),
                    result.getBigDecimal("vl_total"));

            lista.add(c);
        }

        return lista;

    }

    /**
     * Retorna a media pela regra de negocio
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public BigDecimal media() throws SQLException, ClassNotFoundException {

        Connection connection = null;

        connection = ConnectAndClose.connection();
        
        PreparedStatement preparedStatement = null;

        String slq = "SELECT SUM(VL_TOTAL) / COUNT(id_customer) AS media "
                + "FROM tb_customer_account "
                + "WHERE vl_total > 560 "
                + "AND id_customer > 1499 "
                + "AND id_customer < 2701";

        preparedStatement = connection.prepareStatement(slq);

        BigDecimal media = null;

        ResultSet result = preparedStatement.executeQuery();
        
        while (result.next()) {

            media = result.getBigDecimal("media");

        }

        return media;

    }

}
