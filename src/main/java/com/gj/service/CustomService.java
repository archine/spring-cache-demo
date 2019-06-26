package com.gj.service;

import cn.gjing.RandomUtil;
import com.gj.domain.Custom;
import com.gj.exception.UserNotFoundException;
import com.gj.repository.CustomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Gjing
 **/
@Service
@Slf4j
public class CustomService {
    @Resource
    private CustomRepository customRepository;


    /**
     * 获取一个用户
     *
     * @param customId 用户id
     * @return custom
     */
    @Cacheable(value = "user", key = "#customId")
    public Custom getCustom(Integer customId) {
        log.warn("通过数据库去查询,用户id为:{}", customId);
        return customRepository.findById(customId)
                .orElseThrow(() -> new UserNotFoundException("Users don't exist"));
    }

    @CacheEvict(value = "user", key = "#customId")
    public void deleteCustom(Integer customId) {
        Custom custom = customRepository.findById(customId)
                .orElseThrow(() -> new UserNotFoundException("Users don't exist"));
        customRepository.delete(custom);
    }

    public Boolean insertCustom(String customName) {
        Custom custom = customRepository.findByCustomName(customName);
        if (custom == null) {
            customRepository.save(Custom.builder()
                    .customName(customName)
                    .customNumber(Integer.valueOf(RandomUtil.generateNumber(6)))
                    .build());
            return true;
        }
        return false;
    }
}
