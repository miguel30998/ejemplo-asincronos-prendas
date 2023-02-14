package com.hiberus.users.application.services;

import com.hiberus.users.domain.ports.in.DeleteUserUseCase;
import com.hiberus.users.domain.ports.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class DeleteUser implements DeleteUserUseCase {
    private final UserPort userPort;

    @Override
    public boolean deleteUser(String userId) {
        return userPort.deleteUser(userId);
    }
}
