package DAO;

import connection.Connect;
import entities.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public boolean registerUser(User user) {
        String query = "INSERT INTO user (name, login, password, email) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // substituir por logger
            return false;
        }
    }

    public boolean deleteUser(int id) {
        String query = "DELETE FROM user WHERE iduser = ?";
        try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateUser(int id, User user) {
        String query = "UPDATE user SET name = ?, login = ?, password = ?, email = ? WHERE iduser = ?";
        try (PreparedStatement ps = Connect.getConnection().prepareStatement(query)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            ps.setInt(5, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public User findUser(int id) {
        String query = "SELECT * FROM user WHERE iduser = ?";
        try (PreparedStatement ps = Connect.getConnection().prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, id);
            if (rs.next()) {
                return new User(
                    rs.getString("name"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement ps = Connect.getConnection().prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(new User(
                    rs.getString("name"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("email")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
