package com.gj.repository;

import com.gj.domain.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gjing
 **/
@Repository
public interface CustomRepository extends JpaRepository<Custom,Integer> {
    /**
     * 通过用户名查询
     * @param customName 用户名
     * @return 用户
     */
    Custom findByCustomName(String customName);
}
