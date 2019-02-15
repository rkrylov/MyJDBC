package mate.academy.myJdbc.dao;

import mate.academy.myJdbc.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends AbstractDao implements UserDao {
    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Long create(User user) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(
                    "INSERT INTO developing.users(user_username, user_password, user_mail)" +
                    "VALUES(?, ?, ?)");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getMail());
            statement.execute();

            statement = connection.prepareStatement("SELECT MAX(user_id) FROM developing.users");
            ResultSet rs = statement.executeQuery();
            rs.next();
            Long userId = rs.getLong("MAX(user_id)");

            return userId;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    @Override
    public User findById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT user_id, user_username, " +
                    "user_password, user_mail FROM developing.users WHERE user_id = ?");
            statement.setLong(1, id);
            return getUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findByUsername(String username) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT user_id, user_username, " +
                    "user_password, user_mail FROM developing.users WHERE user_username = ?");
            statement.setString(1, username);
            return getUser(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM developing.users WHERE user_id = ?");
            statement.setLong(1, id);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "UPDATE developing.users SET user_username=?, user_password=?, user_mail=? " +
                            "WHERE user_id=?");
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getMail());
            statement.setLong(4, user.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User getUser(PreparedStatement statement) throws SQLException {
        ResultSet rs = statement.executeQuery();
        rs.next();
        User user = new User.Builder()
                .id(rs.getLong("user_id"))
                .username(rs.getString("user_username"))
                .password(rs.getString("user_password"))
                .mail(rs.getString("user_mail"))
                .build();
        return user;
    }
}
