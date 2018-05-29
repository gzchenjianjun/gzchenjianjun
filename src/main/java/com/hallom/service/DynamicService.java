package com.hallom.service;

import com.hallom.entity.Dynamic;
import com.hallom.entity.Page;

import java.util.List;

/**
 * @author cb
 */
public interface DynamicService {
    void save(Dynamic param);
    List<Dynamic> getAllDynamic(Long pageIndex,Long pageSize);
    List<Dynamic> getHotDynamic(Long pageIndex,Long pageSize);
    List<Dynamic> getFollowDynamic(Long pageIndex,Long pageSize);
    List<Dynamic> geUserDynamic(Long pageIndex,Long pageSize);
    Long count();
    Long hotCount();
}
