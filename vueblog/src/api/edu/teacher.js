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
    },
    deleteTeacherId(id) {
        return request({
            url: `/eduservice/teacher/${id}`,
            method: 'delete'
        })
    },
    addTeacher(teacher) {
        return request({
            url: `/eduservice/teacher/addTeacher`,
            method: 'post',
            data: teacher
        })
    },
    getTeacherInfo(id) {
        return request({
            url: `eduservice/teacher/getTeacher/${id}`,
            method: "get"
        });
    },
    updateTeacher(teacher) {
        return request({
            url: `eduservice/teacher/updateTeacher`,
            method: "post",
            data: teacher
        });
    }
}
