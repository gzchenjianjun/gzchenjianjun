package com.hallom.dao;

import com.hallom.entity.Dynamic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cb
 */
@Mapper
public interface DynamicDao {
    void save(Dynamic param);

    /**
     * 查询全部动态
     *
     * @param start
     * @param pageSize
     * @param schoolId
     * @return
     */
    List<Dynamic> getAllDynamic(@Param("start") Long start,
                                @Param("pageSize") Long pageSize,
                                @Param("schoolId") Long schoolId);

    /**
     * 查询热门动态
     *
     * @param start
     * @param pageSize
     * @return
     */
    List<Dynamic> getHotDynamic(@Param("start") Long start,
                                @Param("pageSize") Long pageSize);

    /**
     * 查询关注动态
     *
     * @param start
     * @param pageSize
     * @param userId
     * @return
     */
    List<Dynamic> getFollowDynamic(@Param("start") Long start,
                                   @Param("pageSize") Long pageSize,
                                   @Param("userId") Long userId);

    /**
     * 查询关注动态
     *
     * @param start
     * @param pageSize
     * @param userId
     * @return
     */
    List<Dynamic> getUserDynamic(@Param("start") Long start,
                                   @Param("pageSize") Long pageSize,
                                   @Param("userId") Long userId);

    Long count();

    Long hotCount();
}
