import request from '@/utils/request'

// 查询安全项点记录列表
export function listSafepointmanage(query) {
  return request({
    url: '/safepoint/safepointmanage/list',
    method: 'get',
    params: query
  })
}

// 查询安全项点记录详细
export function getSafepointmanage(safepointId) {
  return request({
    url: '/safepoint/safepointmanage/' + safepointId,
    method: 'get'
  })
}

// 新增安全项点记录
export function addSafepointmanage(data) {
  return request({
    url: '/safepoint/safepointmanage',
    method: 'post',
    data: data
  })
}

// 修改安全项点记录
export function updateSafepointmanage(data) {
  return request({
    url: '/safepoint/safepointmanage',
    method: 'put',
    data: data
  })
}

// 删除安全项点记录
export function delSafepointmanage(safepointId) {
  return request({
    url: '/safepoint/safepointmanage/' + safepointId,
    method: 'delete'
  })
}
