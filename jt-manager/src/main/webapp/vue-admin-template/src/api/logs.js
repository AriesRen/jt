import request from '@/utils/request'

export function getLogs(pageCurrent, pageSize, username) {
  return request({
    url: '/logs/logs',
    method: 'get',
    params: {
      pageCurrent,
      pageSize,
      username
    }
  })
}
