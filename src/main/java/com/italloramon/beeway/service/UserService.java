package com.italloramon.beeway.service;

import com.italloramon.beeway.dto.UserDto;
import com.italloramon.beeway.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
