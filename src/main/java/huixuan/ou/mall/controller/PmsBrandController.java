package huixuan.ou.mall.controller;

import huixuan.ou.mall.common.api.CommonPage;
import huixuan.ou.mall.common.api.CommonResult;
import huixuan.ou.mall.mbg.model.PmsBrand;
import huixuan.ou.mall.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @program: mall
 * @description: 品牌管理
 * @author: ouhuixuan
 * @create: 2019-11-25 17:23
 **/
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
@RequestMapping("/brand")
public class PmsBrandController {

    @Autowired
    private PmsBrandService demoService;

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(demoService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int brand = demoService.createBrand(pmsBrand);
        if (brand == 1){
            commonResult = CommonResult.success(pmsBrand);
            logger.debug("create success:{}",pmsBrand);
        }else{
            commonResult = CommonResult.failed("操作失败！");
            logger.debug("create failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @ApiOperation("更新指定ID的品牌信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@PathVariable("id") long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int brand = demoService.updateBrand(id, pmsBrandDto);
        if(brand == 1){
            commonResult = CommonResult.success(pmsBrandDto);
            logger.debug("update success:{}",pmsBrandDto);
        }else {
            commonResult = CommonResult.failed("操作失败！");
            logger.debug("update Failed:{}",pmsBrandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定ID的品牌")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult delete(@PathVariable("id") Long id){
        int deleteBrand = demoService.deleteBrand(id);
        if (deleteBrand == 1 ){
            logger.debug("delete success:{}",id);
            return CommonResult.success(null);
        }else{
            logger.debug("delete failed:{}",id);
            return CommonResult.failed("操作失败！");
        }
    }

    @ApiOperation("分页获取品牌列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> list(@RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
    @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum){
        List<PmsBrand> brandList = demoService.listBrand(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定ID的品牌详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> getOne(@PathVariable("id") Long id){
        return CommonResult.success(demoService.getBrand(id));
    }
}
