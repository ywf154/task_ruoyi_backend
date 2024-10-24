package com.ruoyi.banner.mapper;

import java.util.List;
import com.ruoyi.banner.domain.Banner;

/**
 * 横幅Mapper接口
 * 
 * @author yi
 * @date 2024-10-22
 */
public interface BannerMapper 
{
    /**
     * 查询横幅
     * 
     * @param id 横幅主键
     * @return 横幅
     */
    public Banner selectBannerById(Long id);

    /**
     * 查询横幅列表
     * 
     * @param banner 横幅
     * @return 横幅集合
     */
    public List<Banner> selectBannerList(Banner banner);

    /**
     * 新增横幅
     * 
     * @param banner 横幅
     * @return 结果
     */
    public int insertBanner(Banner banner);

    /**
     * 修改横幅
     * 
     * @param banner 横幅
     * @return 结果
     */
    public int updateBanner(Banner banner);

    /**
     * 删除横幅
     * 
     * @param id 横幅主键
     * @return 结果
     */
    public int deleteBannerById(Long id);

    /**
     * 批量删除横幅
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBannerByIds(Long[] ids);
}
