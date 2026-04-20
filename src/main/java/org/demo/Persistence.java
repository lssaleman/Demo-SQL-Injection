package org.demo;

import java.sql.*;
import java.util.ArrayList;

public class Persistence {
    private static final String URL = "jdbc:sqlite:demo.db";

    public ArrayList<UserDTO> getUserData(String username, String password) {
        String sql = "SELECT * " +
                "FROM UserData u " +
                "JOIN BankData bd ON u.user_id = bd.user_id " +
                "WHERE nutzername = '" + username + "' AND passwort = '" + password + "'";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt = conn.prepareStatement(sql)) {


            ResultSet rs = stmt.executeQuery();
            ArrayList<UserDTO> userDTOs = new ArrayList<>();
            while (rs.next()) {
                UserDTO dto = new UserDTO();
                dto.setNachname(rs.getString("nachname"))
                        .setVorname(rs.getString("vorname"))
                        .setBic(rs.getString("bic"))
                        .setIban(rs.getString("iban"))
                        .setPin(rs.getString("pin"));
                userDTOs.add(dto);
            }
            return userDTOs;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
