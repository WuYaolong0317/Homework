package com.ruoyi.safepoint.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.safepoint.mapper.SpSafepointMapper;
import com.ruoyi.safepoint.domain.SpSafepoint;
import com.ruoyi.safepoint.service.ISpSafepointService;

/**
 * 安全项点记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@Service
public class SpSafepointServiceImpl implements ISpSafepointService 
{
    @Autowired
    private SpSafepointMapper spSafepointMapper;

    /**
     * 查询安全项点记录
     * 
     * @param safepointId 安全项点记录主键
     * @return 安全项点记录
     */
    @Override
    public SpSafepoint selectSpSafepointBySafepointId(Integer safepointId)
    {
        return spSafepointMapper.selectSpSafepointBySafepointId(safepointId);
    }

    /**
     * 查询安全项点记录列表
     * 
     * @param spSafepoint 安全项点记录
     * @return 安全项点记录
     */
    @Override
    public List<SpSafepoint> selectSpSafepointList(SpSafepoint spSafepoint)
    {
        return spSafepointMapper.selectSpSafepointList(spSafepoint);
    }

    /**
     * 新增安全项点记录
     * 
     * @param spSafepoint 安全项点记录
     * @return 结果
     */
    @Override
    public int insertSpSafepoint(SpSafepoint spSafepoint)
    {
        return spSafepointMapper.insertSpSafepoint(spSafepoint);
    }

    /**
     * 修改安全项点记录
     * 
     * @param spSafepoint 安全项点记录
     * @return 结果
     */
    @Override
    public int updateSpSafepoint(SpSafepoint spSafepoint)
    {
        return spSafepointMapper.updateSpSafepoint(spSafepoint);
    }

    /**
     * 批量删除安全项点记录
     * 
     * @param safepointIds 需要删除的安全项点记录主键
     * @return 结果
     */
    @Override
    public int deleteSpSafepointBySafepointIds(Integer[] safepointIds)
    {
        return spSafepointMapper.deleteSpSafepointBySafepointIds(safepointIds);
    }

    /**
     * 删除安全项点记录信息
     * 
     * @param safepointId 安全项点记录主键
     * @return 结果
     */
    @Override
    public int deleteSpSafepointBySafepointId(Integer safepointId)
    {
        return spSafepointMapper.deleteSpSafepointBySafepointId(safepointId);
    }
}
