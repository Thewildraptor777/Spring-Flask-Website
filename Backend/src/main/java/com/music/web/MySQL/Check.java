package com.music.web.MySQL;

import java.util.List;

public class Check {
    private String username;
    private String password;
    private String playlists;
    private Boolean correctInformation = false;
    private List<User> UsersList = UserReader.run();

    public Check(String inputUsername, String inputPassword) {
        username = inputUsername;
        password = inputPassword;
        check(UsersList);
    }

    public String getPlaylistData() {
        if (correctInformation) {
            return playlists;
        } else {
            return "No Data";
        }
    }

    private void check(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            User USER = users.get(i);
            if (username.equals(USER.getUsername()) && password.equals(USER.getPassword()) ) {
                correctInformation = true;
                playlists = USER.getPlaylists();
            }

        }

    }

    public static void main(String[] args) {
        Check check = new Check("dev2", "test");
        System.out.println(check.getPlaylistData());
    }
}