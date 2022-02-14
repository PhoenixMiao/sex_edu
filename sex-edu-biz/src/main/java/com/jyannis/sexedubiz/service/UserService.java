package com.jyannis.sexedubiz.service;

import com.jyannis.sexeducommon.dto.SessionData;
import com.jyannis.sexeducommon.request.UpdateUserByIdRequest;
import com.jyannis.sexeducommon.response.UserResponse;

public interface UserService {
    UserResponse getUserById(Long id);
    void updateUserById(UpdateUserByIdRequest updateUserByIdRequest, Long id);

    /**
     * 登录
     * @param code
     * @return
     */
    SessionData login(String code);
}
