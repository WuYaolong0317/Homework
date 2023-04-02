package com.ruoyi.safepoint.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.safepoint.domain.SpSafepoint;
import com.ruoyi.safepoint.service.ISpSafepointService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 安全项点记录Controller
 * 
 * @author ruoyi
 * @date 2023-03-30
 */
@RestController
@RequestMapping("/safepoint/safepointmanage")
public class SpSafepointController extends BaseController
{
    @Autowired
    private ISpSafepointService spSafepointService;

    /**
     * 查询安全项点记录列表
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:list')")
    @GetMapping("/list")
    public TableDataInfo list(SpSafepoint spSafepoint)
    {
        startPage();
        List<SpSafepoint> list = spSafepointService.selectSpSafepointList(spSafepoint);
        return getDataTable(list);
    }

    /**
     * 导出安全项点记录列表
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:export')")
    @Log(title = "安全项点记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SpSafepoint spSafepoint)
    {
        List<SpSafepoint> list = spSafepointService.selectSpSafepointList(spSafepoint);
        ExcelUtil<SpSafepoint> util = new ExcelUtil<SpSafepoint>(SpSafepoint.class);
        util.exportExcel(response, list, "安全项点记录数据");
    }

    /**
     * 获取安全项点记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:query')")
    @GetMapping(value = "/{safepointId}")
    public AjaxResult getInfo(@PathVariable("safepointId") Integer safepointId)
    {
        return success(spSafepointService.selectSpSafepointBySafepointId(safepointId));
    }

    /**
     * 新增安全项点记录
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:add')")
    @Log(title = "安全项点记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SpSafepoint spSafepoint)
    {
        return toAjax(spSafepointService.insertSpSafepoint(spSafepoint));
    }

    /**
     * 修改安全项点记录
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:edit')")
    @Log(title = "安全项点记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SpSafepoint spSafepoint)
    {
        return toAjax(spSafepointService.updateSpSafepoint(spSafepoint));
    }

    /**
     * 删除安全项点记录
     */
    @PreAuthorize("@ss.hasPermi('safepoint:safepointmanage:remove')")
    @Log(title = "安全项点记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{safepointIds}")
    public AjaxResult remove(@PathVariable Integer[] safepointIds)
    {
        return toAjax(spSafepointService.deleteSpSafepointBySafepointIds(safepointIds));
    }
}
