package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MemberDto {
    
    String userId;
    String userName;
    String phone;
    String password;
    LocalDateTime regDt;
    
    boolean emailAuthYn;
    LocalDateTime emailAuthDt;
    String emailAuthKey;
    
    String resetPasswordKey;
    LocalDateTime resetPasswordLimitDt;
    
    boolean adminYn;
    String userStatus;
    LocalDateTime lastLoginDt;
    
    //추가컬럼
    long totalCount;
    long seq;
    
    
    public static MemberDto of(Member member) {
        
        return MemberDto.builder()
                .userId(member.getUserId())
                .userName(member.getUserName())
                .phone(member.getPhone())
                //.password(member.getPassword())
                .regDt(member.getRegDt())
                .emailAuthYn(member.isEmailAuthYn())
                .emailAuthDt(member.getEmailAuthDt())
                .emailAuthKey(member.getEmailAuthKey())
                .resetPasswordKey(member.getResetPasswordKey())
                .resetPasswordLimitDt(member.getResetPasswordLimitDt())
                .adminYn(member.isAdminYn())
                .userStatus(member.getUserStatus())
                .lastLoginDt(member.getLastLoginDt())
                .build();
    }
    
    
}