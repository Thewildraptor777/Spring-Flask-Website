package com.music.web.database;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

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

            ObjectMapper mapper = new ObjectMapper();

            try {
                String jsonString = mapper.writeValueAsString(playlists);

                return jsonString;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        } else {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString("No Data");

            } catch (Exception e) {
                e.printStackTrace();
            }return null;
        }
    }

    private void check(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            User USER = users.get(i);
            if (username.equals(USER.getUsername()) && password.equals(USER.getPassword())) {
                correctInformation = true;
                playlists = USER.getPlaylists();
            }

        }

    }
}