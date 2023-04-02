package com.ruoyi.safepoint.service;

import java.util.List;
import com.ruoyi.safepoint.domain.SpSafepoint;

/**
 * 安全项点记录Service接口
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
public interface ISpSafepointService 
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
     * 批量删除安全项点记录
     * 
     * @param safepointIds 需要删除的安全项点记录主键集合
     * @return 结果
     */
    public int deleteSpSafepointBySafepointIds(Integer[] safepointIds);

    /**
     * 删除安全项点记录信息
     * 
     * @param safepointId 安全项点记录主键
     * @return 结果
     */
    public int deleteSpSafepointBySafepointId(Integer safepointId);
}
