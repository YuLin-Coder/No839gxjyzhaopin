const base = {
    get() {
        return {
            url : "http://localhost:8080/gxjyzhaopin/",
            name: "gxjyzhaopin",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/gxjyzhaopin/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "高校就业招聘系统"
        } 
    }
}
export default base
