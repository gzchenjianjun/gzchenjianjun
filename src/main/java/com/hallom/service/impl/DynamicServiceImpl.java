package com.hallom.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hallom.dao.DynamicDao;
import com.hallom.entity.Dynamic;
import com.hallom.entity.User;
import com.hallom.service.DynamicService;
import com.hallom.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cb
 */
@Service
public class DynamicServiceImpl implements DynamicService{
    @Autowired
    private DynamicDao dynamicDao;
    @Autowired
    private UserUtil userUtil;
    @Override
    public void save(Dynamic param) {
        String json = JSON.toJSONString(param.getImageUrlList());
        User user=userUtil.getUser();
        param.setSchoolId(user.getSchoolId());
        param.setUserId(user.getUid());
        param.setImageUrlJson(json);
        dynamicDao.save(param);
    }

    @Override
    public List<Dynamic> getAllDynamic(Long pageIndex,Long pageSize) {
        Long schoolId=userUtil.getUser().getSchoolId();

        return dynamicDao.getAllDynamic((pageIndex-1)*pageSize,pageSize,schoolId);
    }

    @Override
    public List<Dynamic> getHotDynamic(Long pageIndex, Long pageSize) {
        List<Dynamic> list=dynamicDao.getHotDynamic((pageIndex-1)*pageSize,pageSize);
        chargeImage(list);
        return list;
    }

    @Override
    public List<Dynamic> getFollowDynamic(Long pageIndex, Long pageSize) {
        Long userId=userUtil.getUser().getUid();
        List<Dynamic> list=dynamicDao.getFollowDynamic((pageIndex-1)*pageSize,pageSize,userId);
        chargeImage(list);
        return list;
    }

    @Override
    public List<Dynamic> geUserDynamic(Long pageIndex, Long pageSize) {
        Long userId=userUtil.getUser().getUid();
        List<Dynamic> list=dynamicDao.getUserDynamic((pageIndex-1)*pageSize,pageSize,userId);
        chargeImage(list);
        return list;
    }

    @Override
    public Long count() {
        return dynamicDao.count();
    }

    @Override
    public Long hotCount() {
        return dynamicDao.hotCount();
    }

    private void chargeImage(List<Dynamic> list){
        for (Dynamic vo:list){
            vo.setImageUrlList(JSONArray.parseArray(vo.getImageUrlJson(),String.class));
        }
    }
}
