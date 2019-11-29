package huixuan.ou.mall.service;

import huixuan.ou.mall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @program: mall
 * @description:
 * @author: ouhuixuan
 * @create: 2019-11-25 17:24
 **/
public interface PmsBrandService {

    List<PmsBrand> listAllBrand();
    int createBrand(PmsBrand pmsBrandDto);
    int updateBrand(Long id,PmsBrand pmsBrand);
    int deleteBrand(Long id);
    List<PmsBrand> listBrand(int pageNum,int pageSize);
    PmsBrand getBrand(Long id);
}
