package com.ruoyi.banner.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.banner.mapper.BannerMapper;
import com.ruoyi.banner.domain.Banner;
import com.ruoyi.banner.service.IBannerService;

/**
 * 横幅Service业务层处理
 * 
 * @author yi
 * @date 2024-10-22
 */
@Service
public class BannerServiceImpl implements IBannerService 
{
    @Autowired
    private BannerMapper bannerMapper;

    /**
     * 查询横幅
     * 
     * @param id 横幅主键
     * @return 横幅
     */
    @Override
    public Banner selectBannerById(Long id)
    {
        return bannerMapper.selectBannerById(id);
    }

    /**
     * 查询横幅列表
     * 
     * @param banner 横幅
     * @return 横幅
     */
    @Override
    public List<Banner> selectBannerList(Banner banner)
    {
        return bannerMapper.selectBannerList(banner);
    }

    /**
     * 新增横幅
     * 
     * @param banner 横幅
     * @return 结果
     */
    @Override
    public int insertBanner(Banner banner)
    {
        return bannerMapper.insertBanner(banner);
    }

    /**
     * 修改横幅
     * 
     * @param banner 横幅
     * @return 结果
     */
    @Override
    public int updateBanner(Banner banner)
    {
        return bannerMapper.updateBanner(banner);
    }

    /**
     * 批量删除横幅
     * 
     * @param ids 需要删除的横幅主键
     * @return 结果
     */
    @Override
    public int deleteBannerByIds(Long[] ids)
    {
        return bannerMapper.deleteBannerByIds(ids);
    }

    /**
     * 删除横幅信息
     * 
     * @param id 横幅主键
     * @return 结果
     */
    @Override
    public int deleteBannerById(Long id)
    {
        return bannerMapper.deleteBannerById(id);
    }
}
