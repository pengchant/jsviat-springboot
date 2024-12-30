package com.jsviat.cs.chap05.repository;

import com.jsviat.cs.chap05.pojo.JpaUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {

    @Query("""
            from user where userName like concat('%',?1, '%')
                    and note like concat('', ?2, '%')
            """)
    List<JpaUser> findUsers(String username, String note);

    /**
     * 按照主键查询
     *
     * @param id
     * @return
     */
    JpaUser getJpaUserById(Long id);

    /**
     * 按照用户名模糊查询
     *
     * @param userName
     * @return
     */
    List<JpaUser> findByUserNameLike(String userName);


    /**
     * 按照用户名或者备注进行模糊查询
     *
     * @param userName
     * @param note
     * @return
     */
    List<JpaUser> findByUserNameLikeOrNoteLike(String userName, String note);


}
