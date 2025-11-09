package DAO;

import connection.Connect;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO {

    public void registerUser(User user) {

        String query = "INSERT INTO user (name, login, password, email) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Connect.getConnection().prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
