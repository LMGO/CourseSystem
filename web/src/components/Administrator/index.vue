<template>
<div id="app">
    <header>
      <el-row>
        <el-col :span="8" class='title'>
          <i class="el-icon-view"></i> &nbsp;&nbsp;管理系统
        </el-col>
         <el-col :span="15">
           <div class="exit" @click="exit()">退出</div>
        </el-col>
      </el-row>
    </header>
    <div class="container">
      <!---左边三个显示栏--->
      <div class="left">
          <div class="student" @click="Shows()">管理学生</div>
          <div class="student" @click="Showc()">管理课程</div>
          <div class="student" @click="Showt()">管理老师</div>
      </div>
       <!---右边功能主体--->
      <div class="right">
        <!---管理学生界面--->
        <div class="change" v-if="shows" >
          <!---新增输入框--->
      　  <el-button type="primary" size="medium" @click="addstudialogFormVisible = true">新增</el-button>
           <el-dialog  :visible.sync="addstudialogFormVisible" >
          <el-form :model="sform">
              <span>请输入需要新增的学生信息</span>
              <el-form-item label="学号" >
              <el-input v-model="sform.loginsid" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="姓名" >
                  <el-input v-model="sform.sname" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="密码">
                  <el-input v-model="sform.password" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="性别">
                  <el-input v-model="sform.gender" auto-complete="off"></el-input>
              </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="addstu()">确 定</el-button>
              </div>
          </el-dialog>
          <!---修改输入框--->
          <el-button type="primary" size="medium" @click="updatestudialogFormVisible = true">修改</el-button>
           <el-dialog :visible.sync="updatestudialogFormVisible" >
          <el-form :model="sform">
              <span>请输入需要修改的学生信息</span>
              <el-form-item label="学号" >
              <el-input v-model="sform.loginsid" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="姓名" >
                  <el-input v-model="sform.sname" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="密码">
                  <el-input v-model="sform.password" auto-complete="off"></el-input>
              </el-form-item>
              <el-form-item label="性别">
                  <el-input v-model="sform.gender" auto-complete="off"></el-input>
              </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="updatestu()">确 定</el-button>
              </div>
          </el-dialog>
            <!---删除输入框--->
          <el-button type="danger" size="medium" @click="delstudialogFormVisible=true">删除</el-button>       
          <el-dialog :visible.sync="delstudialogFormVisible" >
            <el-form :model="sform">
              <span>请输入需要删除学生学号</span>
              <el-form-item label="学号" >
              <el-input v-model="sform.loginsid" auto-complete="off"></el-input>
              </el-form-item>             
             </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="delstu()">确 定</el-button>
              </div>
          </el-dialog> 
        <!---学生信息主体--->
         <template>
            <el-table :header-cell-style="{
                              'background-color': '#fafafa',
                              'color': 'black',
                              'font-size': '20px',
                              'border-bottom': '1px black solid'  ,'background':'#6ab0f1'            
                              }"
              :data="stableData" style="width: 100%" max-height="500">
              <el-table-column fit="true" align="center"  prop="loginsid" label="学号">
                <template slot-scope="scope">
                  <span>{{scope.row.loginsid}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="sname" label="姓名">
                <template slot-scope="scope">
                  <span>{{scope.row.sname}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="password" label="密码">
                <template slot-scope="scope">
                  <span>{{scope.row.password}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="gender" label="性别">
                <template slot-scope="scope">
                  <span>{{scope.row.gender}}</span>
                </template>
              </el-table-column>
              </el-table>
            </template>
        </div>  
        <!-- -课程管理界面- -->
        <div class="change" v-if="showc" >
          <!---新增课程信息弹窗--->
            <el-button type="primary" size="medium" @click="addcoudialogFormVisible = true">新增</el-button>
            <el-dialog  :visible.sync="addcoudialogFormVisible" >
              <el-form :model="cform">
                  <span>请输入新增课程信息</span>
                <!-- <el-form-item label="课程号" >
                <el-input v-model="cform.cid" auto-complete="off"></el-input>
                </el-form-item> -->
                <el-form-item label="课程名" >
                    <el-input v-model="cform.cname" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="上课地址">
                    <el-input v-model="cform.address" auto-complete="off"></el-input>
                </el-form-item>
               </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="addcou()">确 定</el-button>
              </div>
            </el-dialog>
            <!---修改课程信息弹窗--->
            <el-button type="primary" size="medium" @click="updatecoudialogFormVisible = true">修改</el-button>
            <el-dialog  :visible.sync="updatecoudialogFormVisible" >
              <el-form :model="cform">
                  <span>请输入需要修改的课程信息</span>
                <el-form-item label="课程号" >
                <el-input v-model="cform.cid" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="课程名" >
                    <el-input v-model="cform.cname" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="上课地址">
                    <el-input v-model="cform.address" auto-complete="off"></el-input>
                </el-form-item>
               </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="updatecou()">确 定</el-button>
              </div>
            </el-dialog>
             <!---删除课程信息弹窗--->
            <el-button type="danger" size="medium" @click="delcoudialogFormVisible = true">删除</el-button>
            <el-dialog  :visible.sync="delcoudialogFormVisible" >
              <el-form :model="cform">
                <span>请输入需要删除的课程名</span>
                <el-form-item label="课程名" >
                <el-input v-model="cform.cname" auto-complete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="delcou()">确 定</el-button>
              </div>
            </el-dialog>
            

        <!---课程信息主体--->
         <template>
            <el-table :header-cell-style="{
                              'background-color': '#fafafa',
                              'color': 'black',
                              'font-size': '20px',
                              'border-bottom': '1px black solid','background':'#6ab0f1'              
                              }"
              :data="ctableData" style="width: 100%" max-height="500">
              <el-table-column fit="true" align="center"  prop="cid" label="课程号" >
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
         <!---教师界面--->
        <div class="change" v-if="showt" > 
          <!---新增教师信息弹窗--->
            <el-button type="primary" size="medium" @click="addteadialogFormVisible = true">新增</el-button>
            <el-dialog  :visible.sync="addteadialogFormVisible" >
              <el-form :model="tform">
                  <span>请输入新增教师信息</span>
                <el-form-item label="教师编号" >
                <el-input v-model="tform.logintid" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="教师姓名" >
                    <el-input v-model="tform.tname" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="tform.password" auto-complete="off"></el-input>
                </el-form-item>
               </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="addtea()">确 定</el-button>
              </div>
            </el-dialog>
            <!---修改教师信息弹窗--->
            <el-button type="primary" size="medium" @click="updateteadialogFormVisible = true">修改</el-button>
            <el-dialog  :visible.sync="updateteadialogFormVisible">
              <el-form :model="tform">
                  <span>请输入需要修改的教师信息</span>
                <el-form-item label="教师编号" >
                <el-input v-model="tform.logintid" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="教师姓名" >
                    <el-input v-model="tform.tname" auto-complete="off"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="tform.password" auto-complete="off"></el-input>
                </el-form-item>
               </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="updatetea()">确 定</el-button>
              </div>
            </el-dialog>
             <!---删除教师信息弹窗--->
            <el-button type="danger" size="medium" @click="delteadialogFormVisible = true">删除</el-button>
            <el-dialog  :visible.sync="delteadialogFormVisible" >
              <el-form :model="cform">
                <span>请输入需要删除的教师编号</span>
                <el-form-item label="教师编号" >
                <el-input v-model="tform.logintid" auto-complete="off"></el-input>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                  <el-button @click="quxiao()">取 消</el-button>
                  <el-button type="primary" @click="delcou()">确 定</el-button>
              </div>
            </el-dialog>
        <!---教师信息主体--->
         <template>
            <el-table :header-cell-style="{
                              'background-color': '#fafafa',
                              'color': 'black',
                              'font-size': '20px',
                              'border-bottom': '1px black solid' ,'background':'#6ab0f1'             
                              }"
              :data="ttableData" style="width: 100%" max-height="500">
              <el-table-column fit="true" align="center"  prop="logintid" label="教师编号">
                <template slot-scope="scope">
                  <span>{{scope.row.logintid}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="tname" label="教师姓名">
                <template slot-scope="scope">
                  <span>{{scope.row.tname}}</span>
                </template>
              </el-table-column>
              <el-table-column fit="true" align="center"  prop="password" label="密码">
                <template slot-scope="scope">
                  <span>{{scope.row.password}}</span>
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
            //控制学生三个弹框
            addstudialogFormVisible:false,
            updatestudialogFormVisible:false,
            delstudialogFormVisible:false,
            //控制课程三个弹框
            addcoudialogFormVisible:false,
            updatecoudialogFormVisible:false,
            delcoudialogFormVisible:false,
            //控制教师三个弹框
            addteadialogFormVisible:false,
            updateteadialogFormVisible:false,
            delteadialogFormVisible:false,
          sform:{
              loginsid:'',
              sname:'',
              password:'',
              gender:''
                },
          stableData: [{
            //用于保存后台返回的学生信息
            loginsid:'',
            sname:'',
            password:'',
            gender:''
          }],
          
          cform:{
              cid:'',
              cname:'',
              address:''
          },
          ctableData: [{
            //用于保存后台返回的课程信息
               cid:'',
              cname:'',
              address:''
          }],
           tform:{
              logintid:'',
              tname:'',
              password:''
          },
          ttableData: [{
           //用于保存后台返回的老师信息
              logintid:'',
              tname:'',
              password:''
          }],
          shows:true,
          showc:false,
          showt:false
      }
    },
    beforeMount(){
      let _this=this;
        _this.getstuInfo();
        _this.getcouInfo();
        _this.getteaInfo();
    },
    methods: {
      //退出表单
      quxiao(){
         //控制学生三个弹框
         let _this=this;
            _this.addstudialogFormVisible=false;
            _this.updatestudialogFormVisible=false;
            _this.delstudialogFormVisible=false;
            //控制课程三个弹框
             _this.addcoudialogFormVisible=false;
             _this.updatecoudialogFormVisible=false;
             _this.delcoudialogFormVisible=false;
            //控制教师三个弹框
            _this.addteadialogFormVisible=false;
            _this.updateteadialogFormVisible=false;
            _this.delteadialogFormVisible=false;

            _this.sform.loginsid='';
            _this.sform.sname='';
            _this.sform.password='';
            _this.sform.gender='';

            _this.cform.cid='';
            _this.cform.cname='';
            _this.cform.address='';

            _this.tform.logintid='';
            _this.tform.tname='';
            _this.tform.password='';
      },
      getstuInfo(){
        let _this=this 
         _this.$axios.get ('http://10.100.253.11:8080/student/getAll')
              .then(function (response) {
                console.log(response);
                _this.stableData=response.data//返回的数组赋值给本地stabledata
            })
              .catch(function (error) {
                console.log(error);
              });
      },
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
      getteaInfo(){
        let _this=this; 
         _this.$axios.get ('http://10.100.253.11:8080/teacher/getall')
              .then(function (response) {
                console.log(response);
                _this.ttableData=response.data//返回的数组赋值给本地ttabledata
            })
              .catch(function (error) {
                console.log(error);
              });
      },
      addstu(){
        let _this=this;
          _this.$axios.post ('http://10.100.253.11:8080/student/add', _this.$qs.stringify({
                 loginsid: _this.sform.loginsid,
                    sname: _this.sform.sname,
                password: _this.sform.password,
                  gender: _this.sform.gender
            }))
              .then(function (response) {
                  console.log(response);
                  if(response.data==123){
                    //提示该学生已经存在
                   _this.$message({
                    message: '该学生已经存在',
                      type: 'error'
                    });
                  }else if(response){
                      //修改成功
                      _this.$message({
                    message: '添加学生成功',
                      type: 'success'
                    });
                    _this.quxiao();
                    _this.addstudialogFormVisible=false;
                     _this.getstuInfo();
                  }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      updatestu(){
        let _this=this;
          _this.$axios.put('http://10.100.253.11:8080/student/update', _this.$qs.stringify({
                loginsid: _this.sform.loginsid,
                   sname: _this.sform.sname,
                password: _this.sform.password,
                gender: _this.sform.gender
            }))
              .then(function (response) {
                  console.log(response);
                  if(response.data==1){
                    //提示该学生不存在
                   _this.$message({
                    message: '该学生不存在',
                      type: 'error'
                    });
                  }else if(response){
                      //修改成功
                      _this.$message({
                    message: '修改学生信息成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.updatestudialogFormVisible=false;
                     _this.getstuInfo();
                  }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      delstu(){
          let _this=this;
          _this.$axios.delete ('http://10.100.253.11:8080/student/delete/'+_this.sform.loginsid)
              .then(function (response) {
                  console.log(response.data);
                  if(response.data==1){
                    //提示该学生不存在
                   _this.$message({
                    message: '该学生不存在',
                      type: 'error'
                    });
                  }else{
                      //修改成功
                      _this.$message({
                    message: '删除学生成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.delstudialogFormVisible=false;
                     _this.getstuInfo();
                  }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      //增加课程
      addcou(){
          let _this=this;
          _this.$axios.post ('http://10.100.253.11:8080/course/add', _this.$qs.stringify({
                  // cid: _this.cform.cid,
                  cname: _this.cform.cname,
                  address: _this.cform.address,
                
            }))
              .then(function (response) {
                  console.log(response.data);
                  // if(response){
                  //   //提示该课程已经存在
                  //  _this.$message({
                  //   message: '该课程已经存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '添加课程成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.addcoudialogFormVisible=false;
                     _this.getcouInfo();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      updatecou(){
              let _this=this;
          _this.$axios.put('http://10.100.253.11:8080/course/update', _this.$qs.stringify({
                       cid: _this.cform.cid,
                     cname: _this.cform.cname,
                  address: _this.cform.address,
            }))
              .then(function (response){
                  console.log(response.data);
                  // if(response){
                  //   //提示该课程不存在
                  //  _this.$message({
                  //   message: '该课程不存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '修改课程信息成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.updatecoudialogFormVisible=false;
                     _this.getcouInfo();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      delcou(){
             let _this=this;
              console.log(_this.cform.cname);
              console.log(typeof(_this.cform.cid));
              _this.cform.cid=parseInt(_this.cform.cid);
               console.log(typeof(_this.cform.cname));
           _this.$axios.delete ('http://10.100.253.11:8080/course/delete/'+_this.cform.cname)
          // _this.$axios.delete ('http://10.100.253.11:8080/course/delete', _this.$qs.stringify({
          //       // cid: _this.cform.cid,
          //       cname: _this.cform.cname,
          //   }))
              .then(function (response) {
                  console.log(response.data);
                  // if(response){
                  //   //提示该课程不存在
                  //  _this.$message({
                  //   message: '该课程不存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '删除课程成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.delcoudialogFormVisible=false;
                     _this.getcouInfo();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
        //增加教师
      addtea(){
          let _this=this;
          _this.$axios.post ('http://10.100.253.11:8080/teacher/add', _this.$qs.stringify({
                  logintid: _this.tform.logintid,
                  tname: _this.tform.tname,
                  password: _this.tform.password   
            }))
              .then(function (response) {
                  console.log(response);
                  // if(response){
                  //   //提示该老师已经存在
                  //  _this.$message({
                  //   message: '该老师信息已经存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '添加老师信息成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.addteadialogFormVisible=false;
                     _this.getteaInfo();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      updatetea(){
              let _this=this;
          _this.$axios.post ('', _this.$qs.stringify({
                  logintid: _this.tform.logintid,
                  tname: _this.tform.tname, 
            }))
              .then(function (response){
                  console.log(response);
                  // if(response){
                  //   //提示该老师不存在
                  //  _this.$message({
                  //   message: '该老师信息不存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '修改老师信息成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.updateteadialogFormVisible=false;
                     _this.getteaInfo();
                  // }
                })
                .catch(function (error) {
                    console.log(error);
                });
      },
      deltea(){
             let _this=this;
            //_this.$axios.delete ('http://10.100.253.11:8080/course/delete/'+_this.cform.cname)
              _this.$axios.delete ('http://10.100.253.11:8080/teacher/delete/'+_this.tform.logintid)
          // _this.$axios.post ('http://10.100.253.11:8080/login/studentLogin', _this.$qs.stringify({
          //        logintid: _this.tform.logintid,
          //   }))
              .then(function (response) {
                  // console.log(response);
                  // if(response){
                  //   //提示该课程不存在
                  //  _this.$message({
                  //   message: '该老师不存在',
                  //     type: 'error'
                  //   });
                  // }else if(response){
                      //修改成功
                      _this.$message({
                    message: '删除老师成功',
                      type: 'success'
                    });
                     _this.quxiao();
                    _this.delteadialogFormVisible=false;
                     _this.getteaInfo();
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
        _this.showt=false
      },
      Showc(){
        let _this=this;
        _this.showc=true;
        _this.shows=false;
        _this.showt=false
      },
       Showt(){
        let _this=this;
        _this.showt=true;
        _this.shows=false;
        _this.showc=false
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