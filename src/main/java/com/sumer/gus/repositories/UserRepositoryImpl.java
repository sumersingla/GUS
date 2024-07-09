package com.sumer.gus.repositories;

import com.sumer.gus.pojos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository(value = "UserRepo")
public class UserRepositoryImpl implements IUserRepository{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findById(Long id) {
        String query = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (rs, rowNum) -> mapRowToUser(rs));
    }

    @Override
    public User findByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{email}, (rs, rowNum) -> mapRowToUser(rs));
    }

    @Override
    public List<User> findAll() {
        String query = "SELECT * FROM users";
        return jdbcTemplate.query(query, (rs, rowNum) -> mapRowToUser(rs));
    }

    @Override
    public void save(User user) {
        String query = "INSERT INTO users (name, email, password, last_login) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword(), user.getLastLogin());
    }

    @Override
    public void update(User user) {
        String query = "UPDATE users SET name = ?, email = ?, password = ?, last_login = ? WHERE id = ?";
        jdbcTemplate.update(query, user.getName(), user.getEmail(), user.getPassword(), user.getLastLogin(), user.getId());
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(query, id);
    }

    private User mapRowToUser(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .email(resultSet.getString("email"))
                .password(resultSet.getString("password"))
                .lastLogin(resultSet.getTimestamp("last_login").toLocalDateTime()) // Assuming 'last_login' is stored as TIMESTAMP in MySQL
                .build();
    }
}
