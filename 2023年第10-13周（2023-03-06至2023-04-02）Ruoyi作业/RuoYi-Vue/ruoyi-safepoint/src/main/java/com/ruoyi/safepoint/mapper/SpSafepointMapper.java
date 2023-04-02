package com.ruoyi.safepoint.mapper;

import java.util.List;
import com.ruoyi.safepoint.domain.SpSafepoint;

/**
 * 安全项点记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface SpSafepointMapper 
{
    /**
     * 查询安全项点记录
     * 
     * @param safepointId 安全项点记录主键
     * @return 安全项点记录
     */
    public SpSafepoint selectSpSafepointBySafepointId(Integer safepointId);

    /**
     * 查询安全项点记录列表
     * 
     * @param spSafepoint 安全项点记录
     * @return 安全项点记录集合
     */
    public List<SpSafepoint> selectSpSafepointList(SpSafepoint spSafepoint);

    /**
     * 新增安全项点记录
     * 
     * @param spSafepoint 安全项点记录
     * @return 结果
     */
    public int insertSpSafepoint(SpSafepoint spSafepoint);

    /**
     * 修改安全项点记录
     * 
     * @param spSafepoint 安全项点记录
     * @return 结果
     */
    public int updateSpSafepoint(SpSafepoint spSafepoint);

    /**
     * 删除安全项点记录
     * 
     * @param safepointId 安全项点记录主键
     * @return 结果
     */
    public int deleteSpSafepointBySafepointId(Integer safepointId);

    /**
     * 批量删除安全项点记录
     * 
     * @param safepointIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSpSafepointBySafepointIds(Integer[] safepointIds);
}
