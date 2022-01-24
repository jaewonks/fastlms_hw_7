package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import com.zerobase.fastlms.member.entity.LoginHistory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public List<LoginHistory> getLoginHistory(String userId) {

        if (userId == null || userId.equals("")) {
            return null;
        }

        Optional<List<LoginHistory>> optionalLoginHistoryList = loginHistoryRepository.findByUserId(userId);

        if (!optionalLoginHistoryList.isPresent()) {
            return null;
        }
        return optionalLoginHistoryList.get();
    }

    @Override
    public boolean insertLoginHistory(HttpServletRequest request, String userName) {

        System.out.println("userName" + userName);

        LoginHistory loginHistory = LoginHistory.builder()
                .loginDt(LocalDateTime.now())
                .ip(request.getRemoteAddr())
                .userId(userName)
                .userAgent(request.getHeader("User-Agent")).build();

        loginHistoryRepository.save(loginHistory);

        return true;
    }

}