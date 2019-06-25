<template>
<div id="app">
    <header>
      <el-row>
        <el-col :span="8" class='title'>
          <i class="el-icon-view"></i> &nbsp;&nbsp;学生课程管理系统</el-col>
      </el-row>
    </header>
    <div id="login">
        <el-form :model="loginForm" method="post">         
           <h2>请选择身份登录</h2>
            <el-form-item>
                <el-input v-model="loginForm.id" name="id" placeholder="请输入用户名" auto-complete="on" maxlength=11></el-input>
            </el-form-item>

            <el-form-item>
                <el-input v-model="loginForm.password" name="password" placeholder="请输入密码" auto-complete="on" :show-password="true" maxlength=15></el-input>
            </el-form-item>
            <span>请选择您的身份</span>
            <el-radio-group v-model="loginForm.radio2">
                <el-radio @click.native.prevent="clickitem(3)" :label="3">学生</el-radio>
                <el-radio @click.native.prevent="clickitem(6)" :label="6">老师</el-radio>
                <el-radio @click.native.prevent="clickitem(9)" :label="9">管理员</el-radio>
            </el-radio-group>
            <el-form-item>
                <el-button type="primary" :loading="false" :round="true"  @click="login('loginForm')">登录</el-button>
            </el-form-item>
        </el-form>
    </div>
</div>
</template>


<script>
export default {
  data() {
    return {
        loginForm: {
            id:'',
            password: '',
            radio2: 1
        },
    }
  },
  methods: {           
        clickitem (e) { 
             e === this.radio2 ? this.radio2 = '' : this.radio2 = e,
             this.loginForm.radio2=this.radio2
        },
        login () {
        let _this = this;
        if(this.loginForm.id==""||this.loginForm.password==""){
            this.$message({
          showClose: true,
          message: '账号和密码不能为空！',
          type: 'warning'
        });
        }else if(this.loginForm.radio2!=3&&this.loginForm.radio2!=6&&this.loginForm.radio2!=9){
             this.$message({
          showClose: true,
          message: '请选择身份！',
          type: 'warning'
        });
        }else if(_this.loginForm.radio2==3) {
            _this.$axios.post('http://10.100.253.11:8080/login/studentLogin',_this.$qs.stringify({
                loginsid: _this.loginForm.id,
				password: _this.loginForm.password
            }))
                .then(function (response) {
                    console.log(response);
                    if(response.data!=2){
                          _this.$message({
                        showClose: true,
                        message: '账号或密码错误！',
                        type: 'warning'
                        });
                      }
                      else{
                          _this.$message({
                        showClose: true,
                        message: '亲爱的同学你好！',
                        type: 'success'
                        });
                          setTimeout (() => {
                      _this.$router.replace({
                         path: '/student'
                      })
                   }, 1500)
                      }
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
        else if(_this.loginForm.radio2==6) {
            _this.$axios.post ('http://10.100.253.11:8080/login/teacherLogin', _this.$qs.stringify({
                logintid: _this.loginForm.id,
				password: _this.loginForm.password
            }))
                .then(function (response) {
                      console.log(response);
                      if(response.data!=2){
                          _this.$message({
                        showClose: true,
                        message: '账号或密码错误！',
                        type: 'warning'
                        });
                      }
                      else{
                          _this.$message({
                        showClose: true,
                        message: '老师你好！',
                        type: 'success'
                        });
                          setTimeout (() => {
                      _this.$router.replace({
                         path: '/teacher'
                      })
                   }, 1500)
                     }
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
        else {
            _this.$axios.post('http://10.100.253.11:8080/login/adminLogin', _this.$qs.stringify({
                aname:_this.loginForm.id,
				password: _this.loginForm.password
            }))
                .then(function (response) {
                    console.log(response.data);
                    if(response.data!=2){
                            _this.$message({
                        showClose: true,
                        message: '账号或密码错误！',
                        type: 'warning'
                        });
                    }else{
                        _this.$message({
                        showClose: true,
                        message: '管理员你好！',
                        type: 'success'
                        });
                           setTimeout (() => {
                      _this.$router.replace({
                         path: '/administrator'
                      })
                    }, 1500)
                    }
                })
                .catch(function (error) {
                    console.log(error);
                });
            }
  }
}
}
</script>
<style scoped>
.el-input {
        width:300px;
        
}
.el-button{
    margin-top: 20px;
     width:200px;
}
.el-form{
    margin-top: 100px;

}  
  body{
    margin: 0;
    padding:0;
    background: #dfe7e948;

  }
  header {
    background: #418cd3;
  }
  header .title {
    height: 58rpx;
    line-height: 58px;
    text-align: center;
    font-size: 20px;
    color: #fff;
  } 
  .login_fal{
	color: red;
}
</style>