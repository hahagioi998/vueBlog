import request from '@/utils/request'

export default {
    //讲师列表（条件查询分页）
    getTeacherListPage(current, limit, teacherQuery) {
        return request({
            url: `/eduservice/teacher/pageTeacherCondition/${current}/${limit}`,
            method: 'post',
            //如果后端参数是requestbody，要加data
            //data表示把对象转换成Json后再传到接口里
            data: teacherQuery 
        })
    }
}
