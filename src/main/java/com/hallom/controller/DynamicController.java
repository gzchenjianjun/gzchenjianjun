package com.hallom.controller;

import com.hallom.entity.Dynamic;

import com.hallom.entity.PageResult;
import com.hallom.entity.Result;
import com.hallom.service.DynamicService;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RequestMapping("/app/dynamic")
@RestController
public class DynamicController {
    private static final Log logger= LogFactory.getLog(DynamicController.class);
    @Autowired
    private DynamicService dynamicService;
    @RequestMapping("/save")
    public Result save(@RequestBody @Valid Dynamic param){
        dynamicService.save(param);
        return Result.success();
    }

    @RequestMapping("getByUser")
    public Result<PageResult> getByUser(@RequestBody @Valid Param param){
        PageResult pageResult=PageResult.success(dynamicService.geUserDynamic(param.getPageIndex(),param.getPageSize()),
                dynamicService.count(),param.getPageSize(),
                param.getPageIndex());
        return new Result<PageResult>(true,pageResult);
    }
    @RequestMapping("/getAllDynamic")
    public Result<PageResult> getAllDynamic(@RequestBody @Valid Param param){
           PageResult pageResult=PageResult.success(dynamicService.getAllDynamic(param.getPageIndex(),param.getPageSize()),
                dynamicService.count(),param.getPageSize(),
                param.getPageIndex());
        return new Result<PageResult>(true,pageResult);
    }
    @RequestMapping("/getHotDynamic")
    public Result<PageResult> getHotDynamic(@RequestBody @Valid Param param){
          PageResult pageResult=PageResult.success(dynamicService.getHotDynamic(param.getPageIndex(),param.getPageSize()),
                dynamicService.count(),param.getPageSize(),
                param.getPageIndex());
        return new Result<PageResult>(true,pageResult);
    }
    @RequestMapping("/getFollowDynamic")
    public Result<PageResult> getFollowDynamic(@RequestBody @Valid Param param){
          PageResult pageResult=PageResult.success(dynamicService.getFollowDynamic(param.getPageIndex(),param.getPageSize()),
                dynamicService.count(),param.getPageSize(),
                param.getPageIndex());
        return new Result<PageResult>(true,pageResult);
    }
//    @RequestMapping("/getDynamicBySchool")
//    public PageListVO<DynamicVO> getDynamicBySchool(@RequestBody DynamicSO so){
//        return dynamicService.getFollowDynamic(so);
//    }
//    /**
//     * @author cb
//     * @date 2018/1/15/015
//     * @time 19:26
//     * @param
//     * @retrun
//    */
//    @RequestMapping("/delete")
//    public StoreBoolean delete(@RequestBody DynamicSO so){
//        dynamicService.delete(so);
//        dynamicUtils.deleteCollect(so);
//        return new StoreBoolean();
//    }
//    /**
//     * @author cb
//     * @date 2018/1/25/025
//     * @time 10:43
//     * @param
//     * @retrun
//    */
//    @RequestMapping("/stick")
//    public StoreBoolean stick(@RequestBody StickSO so) throws HallomException {
//        dynamicService.stick(so);
//        return new StoreBoolean();
//    }

}
@Data
class Param{
    @NotNull(message = "当前页不能为空")
    private Long pageIndex;
    @NotNull(message = "一页数量不能为空")
    private Long pageSize;
}
