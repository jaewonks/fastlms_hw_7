package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.member.entity.LoginHistory;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginHistoryService {

    List<LoginHistory> getLoginHistory(String userId);

    boolean insertLoginHistory(HttpServletRequest request, String userName);

}
