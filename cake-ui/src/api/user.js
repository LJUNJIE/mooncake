import request from '@/utils/axios'


export function login(params) {
  return request({
    url: 'http://localhost:8700/oauth/token?username=user1&password=123456&grant_type=password&scope=select&client_id=client_1&client_secret=123456',
    method: 'post',
    data:''
  })
}
export function logout(params) {
  return request({
    url: '/user/logout',
    method: 'get',
    data:params
  })
}


export function getUserInfo(params) {
  return request({
      url: 'http://localhost:8700/info/user',
      method: 'post',
      data: ''
  })
}

export function getUserList(reqData) {
  return request({
    url:'http://localhost:8881/system/user/userPage',
    method: 'post',
    data: reqData
  })
}


