package com.ybb.mall.repository;

import com.ybb.mall.domain.SysRole;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the SysRole entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

}
