let token  = Auth.getToken();
var global_username = null;
var global_authArr = [];

//判断
if(token !=null && token !="") {
    //将token放到axios的headers中
    axios.defaults.headers.common[Auth.USER_AUTH_KEY] = token;
    //TODO
    //根据业务需求查询出更多数据
    global_username = Auth.getUserName();
    let auth = Auth.getAuth();
    if(auth) {
        auth.forEach(item => {
            global_authArr.push(item.authority);
        });
    }
}else {
    console.log("goto login page.....",token);
    //如果没有登录，跳转到登录页面
    Auth.gotoLogin(token);
}
//导出，让其它模块使用
//export {token,username,authArr};