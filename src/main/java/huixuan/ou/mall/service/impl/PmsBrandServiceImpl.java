package huixuan.ou.mall.service.impl;

import com.github.pagehelper.PageHelper;
import huixuan.ou.mall.mbg.mapper.PmsBrandMapper;
import huixuan.ou.mall.mbg.model.PmsBrand;
import huixuan.ou.mall.mbg.model.PmsBrandExample;
import huixuan.ou.mall.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mall
 * @description: 品牌管理service
 * @author: ouhuixuan
 * @create: 2019-11-26 08:57
 **/
@Service
public class PmsBrandServiceImpl implements PmsBrandService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private PmsBrandMapper pmsBrandMapper;
    @Override
    public List<PmsBrand> listAllBrand() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public int createBrand(PmsBrand pmsBrandDto) {
        int i = pmsBrandMapper.insertSelective(pmsBrandDto);
        return i;
    }

    @Override
    public int updateBrand(Long id, PmsBrand pmsBrand) {
        pmsBrand.setId(id);
        int update = pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
        return update;
    }

    @Override
    public int deleteBrand(Long id) {
        int key = pmsBrandMapper.deleteByPrimaryKey(id);
        return key;
    }

    @Override
    public List<PmsBrand> listBrand(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return  pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public PmsBrand getBrand(Long id) {
        PmsBrand pmsBrand = pmsBrandMapper.selectByPrimaryKey(id);
        return pmsBrand;
    }
}
