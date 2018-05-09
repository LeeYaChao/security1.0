package com.lyc.cloud.ip.security.core.repository;

import com.lyc.cloud.ip.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    UserInfo findByUserName(String userName);

    UserInfo findByMobile(String mobile);
}
