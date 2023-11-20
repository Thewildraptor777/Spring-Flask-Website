package com.music.web.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserReader {
    public static List<User> run() {
        String url = "jdbc:mysql://localhost:3306/spring-flask";
        String username = "spring";
        String password = "WlG(@ZBQMHFGgTA4";
        List<User> users = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM user_data");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setPlaylists(rs.getString("playlists"));
                users.add(user);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
}

class User {
    private int id;
    private String name;
    private String password;
    private String playlists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlaylists() {
        return playlists;
    }

    public void setPlaylists(String playlists) {
        this.playlists = playlists;
    }
}