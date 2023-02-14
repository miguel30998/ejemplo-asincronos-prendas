package com.hiberus.users.application.services;

import com.hiberus.users.domain.model.User;
import com.hiberus.users.domain.ports.in.GetUserByIdUseCase;
import com.hiberus.users.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class GetUserByID implements GetUserByIdUseCase {
    private final UserPort userPort;

    @Override
    public User getUser(String userId) {
        return userPort.getUser(userId);
    }
}
