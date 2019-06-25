<template>
<div id="app">
    <header>
      <el-row>
        <el-col :span="8" class='title'>
          <i class="el-icon-view"></i> &nbsp;&nbsp;学生选课系统
        </el-col>
         <el-col :span="15">
           <div class="exit" @click="exit()">退出</div>
        </el-col>
      </el-row>
    </header>
    <div class="container">
      <!---左边三个显示栏--->
      <div class="left">
          <div class="student" @click="Shows()">管理个人课程</div>
          <div class="student" @click="Showc()">课程信息展示</div>
          <!-- <div class="student" @click="Showt()">学生成绩管理</div> -->
      </div>
       <!---右边功能主体--->
      <div class="right">
        <!---退选课程--->
        <div class="change" v-if="shows" >
          <!---新增课程--->
      　   <el-button type="primary" size="medium" @click="adddialogFormVisible = true">新增</el-button>
            <el-dialog  :visible.sync="adddialogFormVisible" >
              <el-form :model="mycouform">
                  <span>请输入课程号和您的学号</span>
                <el-form-item label="课程号" >
                <el-input v-model="mycouform.cid" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="学号" >
                <el-input v-model="mycouform.loginsid" auto-complete="off"></el-input>
                </el-form-item>
               </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="add()">确 定</el-button>
              </div>
            </el-dialog>
            <!---删除输入框--->
          <el-button type="danger" size="medium" @click="deltcoudialogFormVisible=true">退选</el-button>       
          <el-dialog :visible.sync="deltcoudialogFormVisible" >
            <el-form :model="mycouform">
              <span>请输入退选的课程号和您的学号</span>
              <el-form-item label="课程号" >
              <el-input v-model="mycouform.cid" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="学号" >
                <el-input v-model="mycouform.loginsid" auto-complete="off"></el-input>
                </el-form-item>             
             </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="del()">确 定</el-button>
              </div>
          </el-dialog> 
        <!---所有我的课程信息主体--->
         <template>
            <el-table :header-cell-style="{
                              'background-color': '#fafafa',
                              'color': 'black',
                              'font-size': '20px',
                              'border-bottom': '1px black solid','background':'#6ab0f1'              
                              }"
              :data="mycoutableData" style="width: 100%" max-height="500">
              <el-table-column fit="true" align="center"  prop="cid" label="课程编号">
                <template slot-scope="scope">
                  <span>{{scope.row.cid}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="cname" label="课程名">
                <template slot-scope="scope">
                  <span>{{scope.row.cname}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="address" label="上课地址">
                <template slot-scope="scope">
                  <span>{{scope.row.address}}</span>
                </template>
              </el-table-column>
               <el-table-column fit="true" align="center"  prop="loginsid" label="学号">
                <template slot-scope="scope">
                  <span>{{scope.row.loginsid}}</span>
                </template>
              </el-table-column>
               </el-table>
            </template>
        </div>  
        <!-- -所有课程信息界面- -->
        <div class="change" v-if="showc" >
        <!---课程信息主体--->
         <template>
            <el-table :header-cell-style="{
                              'background-color': '#fafafa',
                              'color': 'black',
                              'font-size': '20px',
                              'border-bottom': '1px black solid','background':'#6ab0f1'            
                              }"
              :data="ctableData" style="width: 100%; margin-top:36px;" max-height="500">
              <el-table-column fit="true" align="center"  prop="cid" label="课程编号">
                <template slot-scope="scope">
                  <span>{{scope.row.cid}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="cname" label="课程名">
                <template slot-scope="scope">
                  <span>{{scope.row.cname}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="address" label="上课地址">
                <template slot-scope="scope">
                  <span>{{scope.row.address}}</span>
                </template>
              </el-table-column>
               </el-table>
            </template>
        </div>  
      </div>
    </div>
</div>
</template>
<script>
  export default {
 data() {
      return {
            //控制授课弹框
            adddialogFormVisible:false,
            deltcoudialogFormVisible:false,
            //控制评分弹框
          // sform:{
          //     loginsid:'',
          //     sname:'',
          //     password:'',
          //     gender:''
          //       },
          mycouform:{
              cid:'',
              cname:'',
              address:'',
              loginsid:''
          },
          mycoutableData:[{
              cid:'',
              cname:'',
              address:'',
              loginsid:''
          }],
          ctableData: [{
            //用于保存后台返回的课程信息
               cid:'',
              cname:'',
              address:''
          }],
          shows:true,
          showc:false,
      }
    },
    beforeMount(){
      let _this=this;
        _this.getmycou();
        _this.getcouInfo()
    },
    methods: {
      //获取课程信息
      getcouInfo(){
        let _this=this 
         _this.$axios.get ('http://10.100.253.11:8080/course/getall')
              .then(function (response) {
                console.log(response);
                _this.ctableData=response.data//返回的数组赋值给本地ctabledata
            })
              .catch(function (error) {
                console.log(error);
              });
      },
      //退出表单
      quxiao(){
         //控制授课弹框
         let _this=this;
            _this.adddialogFormVisible=false;
            _this.deltcoudialogFormVisible=false;

              _this.mycouform.cid='';
              _this.mycouform.cname='';
              _this.mycouform.address='';
              _this.mycouform.loginsid='';

      },
      //获取授课信息
     getmycou(){
        let _this=this 
         _this.$axios.get ('http://10.100.253.11:8080/')
              .then(function (response) {
                console.log(response);
                _this.mycoutableData=response.data//返回的数组赋值给本地mycoutableData
            })
              .catch(function (error) {
                console.log(error);
              });
      },
    //选择课程
      add(){
          let _this=this;
          _this.$axios.post ('', _this.$qs.stringify({
                  cid: _this.mycouform.cid,
                  loginsid:_this.mycouform.loginsid
            }))
              .then(function (response) {
                  // console.log(response);
                  // if(response){
                  //   //提示该课程已经存在
                  //  _this.$message({
                  //   message: '该课程已经存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                  //     //修改成功
                      _this.$message({
                    message: '选课成功',
                      type: 'success'
                    });
                    _this.adddialogFormVisible=false;
                     _this.getmycou();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      //删除课
      del(){
          let _this=this;
          _this.$axios.delete ('http://10.100.253.11:8080/', _this.$qs.stringify({
                 cid: _this.mycouform.cid,
            loginsid:_this.mycouform.loginsid
            }))
              .then(function (response) {
                  console.log(response);
                  // if(response){
                  //   //提示该学生不存在
                  //  _this.$message({
                  //   message: '该学生不存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '删除课程成功',
                      type: 'success'
                    });
                    _this.deltcoudialogFormVisible=false;
                     _this.getmycou();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      //控制点击后显示不同板块
      Shows(){
        let _this=this;
        _this.shows=true;
        _this.showc=false;
      },
      Showc(){
        let _this=this;
        _this.showc=true;
        _this.shows=false;
      },
   
      exit(){
         setTimeout (() => {
                this.$router.replace({
                 path: '*'
                  })
            }, 1000)
      }
    }
}

</script>
<style scoped>  
  body{
    margin: 0;
    padding:0;
    background: #dfe7e948;

  }
  header {
    position:fixed; left:0; top:0;
    background: #418cd3;
    width: 100vw;
    text-align: center;
  }
  header .title {
    float: left;
    /* height: 60px; */
    line-height:60px;
    text-align: center;
    font-size: 20px;
    color: #fff;
  } 
header .exit{
  margin-top: 20px;
  float:right;
  font-size: 20px;
  margin-right: 50px;
  border-radius: 20%;
  background: #ffffff;
  color:rgb(22, 6, 248);
}
.container{
  width: 100vw;
  background: #02191f48;
}
.left{
  position:fixed; 
  left:0;
  top:60px;
  float:left;
  width: 10vw;
  height: 100vh;
  background: #6ab0f1;
 }
 
.left .student{
  margin:20% auto; 
  font-size:20px;
  color: ivory;
}
.left .student:hover{ 
  margin:20% auto; 
  font-size:20px;
  color: ivory;
}
.right{
  top:60px;
  width: 90vw;
  height: 100vh;
  float: right;
  text-align: center;
  background: #cccdd148;
}
.change{
  position:fixed; 
  width: 70vw;
  margin-top: 65px;
  margin-left: 10vw;
}
.student:hover{
      background-color: rgb(60, 8, 247);
}
.student:active{
      background-color: rgb(60, 8, 247);
}
 .el-table .warning-row {
    background: oldlace;
  }
  .el-table .success-row {
    background: #f0f9eb;
  }
 .cell-edit-color{
         color:#2db7f5;
         font-weight: bold;
     }
   .cell-edit-input .el-input, .el-input__inner {
    width:100px;
   }
   .cell-icon{
    cursor:pointer;
    color:#fff;
     }


</style>