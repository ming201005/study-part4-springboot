/**
 * 小明哥
 * @type {{setAuth(*=): void, _getVal(*): (*|null), getAuth(): *, _getAuth(): void, getToken(): *, authObj: null, getUserName(): *, delAuth(): void, gotoLogin(*=): void, USER_AUTH_KEY: string, managerCenter(*=): void}}
 */

//api访问地址，可修改
let global_api_url = "http://localhost:8083/";

let Auth = {
    USER_AUTH_KEY: "Authorization",
    authObj:null,

    /**
     * 登录
     */
    login(user) {
        if(this._verify(user)) {
            axios.post(global_api_url+"login", user).then(rs => {
                if (rs.data.code == 0) {
                    //登录成功
                    let userAuth = rs.data.data;
                    //存用户权限信息
                    this.setAuth(userAuth);
                    //决定是否跳转
                    this.gotoManagerCenter(userAuth.token);
                } else {
                    alert(rs.data.msg);
                }
            }).catch(err => {
                alert(err);
            });
        }
    },

    /**
     * 退出
     */
    logout() {
        axios.get(global_api_url+"logout").then(rs=>{
            if(rs.data.code ==0 ) {
                this.deleteAuth();
                document.location.reload();
            }else{
                alert(rs.data.msg);
            }
        }).catch(err=>{
            alert(err)
        });
    },

    /**
     * 保存用户基本权限信息
     * @param auth
     */
    setAuth(auth) {
        if (auth) {
            let authString = JSON.stringify(auth);
            window.sessionStorage.setItem(this.USER_AUTH_KEY, authString);
        }
    },
    /**
     * 清除sessionStorage中的userAuth
     */
    deleteAuth(){
        window.sessionStorage.removeItem(this.USER_AUTH_KEY);
    },

    /**
     * 可以直接调用此方法获得当前登录人
     * @returns {null}
     */
    getUserName() {
        return this._getVal("username");
    },

    /**
     * 可以直接调用此方法获得角色名称
     * @returns {null}
     */
    getAuth(){
        return this._getVal("auth");
    },

    /**
     * 可以直接调用此方法获得该用户的菜单
     * @returns {null}
     */
    getMenus() {
        return this._getVal("menus");
    },


    /**
     * 可以直接调用此方法获得token，一般不需要调用
     * 在checkIsLogin.js中已经设置到全局的headers中
     * 访问后台API时，自动携带了token，无须每次都设置
     * @returns {null}
     */
    getToken(){
        return this._getVal("token");
    },

    /**
     * 进入管理中心
     * @param token
     */
    gotoManagerCenter(token) {
        if(token) {
            document.location.href = "./index.html";
        }
    },

    /**
     * 进入登录页面
     * @param token
     */
    gotoLogin(token) {

        if(!token) {
            document.location.href = "./login.html";
        }
    },

    _getAuth() {
       let authString =  window.sessionStorage.getItem(this.USER_AUTH_KEY);
       if(authString) {
           this.authObj = JSON.parse(authString);
       }
    },
    _getVal(val){
        if(this.authObj == null){
            //console.log("加载sessionStorage中的userAuth信息......");
            this._getAuth();
        }
        return  this.authObj? this.authObj[val] : null;
    },

    //登录验证
    _verify(user) {
        let errArr = [];
        //做一个简单的验证
        if (user.username == null || user.username =="") {
            errArr.push("请输入账号！");
        }else if(user.password == null || user.password ==""){
            errArr.push("请输入密码！");
        }else if(user.password.length<6 || user.password.length>12){
            errArr.push("密码范围是6~12位数！");
        }
        if(errArr.length>0){
            alert(errArr);
        }else {
            return true;
        }
        return false;
    }

}