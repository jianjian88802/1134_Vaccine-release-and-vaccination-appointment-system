const base = {
    get() {
        return {
            url : "http://localhost:8080/yimiaofabuhejiezhong/",
            name: "yimiaofabuhejiezhong",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/yimiaofabuhejiezhong/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫苗发布和接种预约系统"
        } 
    }
}
export default base
