package DAO;

import connection.Connect;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void deleteUser(int id) {
        String query = "DELETE FROM user WHERE iduser = ?";
        if (findUser(id) != null) {
            PreparedStatement ps = null;
            try {
                ps = Connect.getConnection().prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("User not found");
        }
        }

    public void updateUser(int id, User user) {
        String query = "UPDATE user SET name = ?, login = ?, password = ?, email = ? WHERE iduser = ?";
        PreparedStatement ps = null;
        try {
            ps = Connect.getConnection().prepareStatement(query);
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User findUser(int id) {
        String query = "SELECT * FROM user WHERE iduser = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            ps = Connect.getConnection().prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            user = new User(
                rs.getString("name"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("email")
            );
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public User[] findAllUsers() {
        String query = "SELECT * FROM user";
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            ps = Connect.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(
                        rs.getString("name"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("email")
                ));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users.toArray(new User[users.size()]);
    }

}
