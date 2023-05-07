package com.italloramon.beeway.service;

import com.italloramon.beeway.dto.UserDto;
import com.italloramon.beeway.model.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    void updateResetPasswordToken(String token, String email) throws RuntimeException;

    User getByResetPasswordToken(String token);

    void updatePassword(User user, String newPassword);
}
