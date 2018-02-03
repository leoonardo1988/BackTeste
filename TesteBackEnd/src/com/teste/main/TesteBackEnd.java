
package com.teste.main;

import com.teste.controller.Controller;
import java.sql.SQLException;

public class TesteBackEnd {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        // Chama a classe controller com o metodo da logica pedida
        Controller c = new Controller();    
        c.logicaTeste();
        
    }
    
}
