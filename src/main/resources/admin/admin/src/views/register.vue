<template>
    <div>
        <div class="container">
            <div class="login-form">
                <h1 class="h1" style="color:#000;fontSize:28px;">高校就业招聘系统注册</h1>
                <el-form class="rgs-form">
                    <el-form-item label="账号" class="input">
                        <el-input v-model="ruleForm.username" autocomplete="off" placeholder="账号"  />
                    </el-form-item>
                    <el-form-item label="密码" class="input">
                        <el-input type="password" v-model="ruleForm.password" autocomplete="off" show-password/>
                    </el-form-item>
                    <el-form-item label="重复密码" class="input">
                        <el-input type="passwo   rd" v-model="ruleForm.repetitionPassword" autocomplete="off" show-password/>
                    </el-form-item>
                        <el-form-item label="辅导员姓名" class="input" v-if="tableName=='fudaoyuan'">
                            <el-input v-model="ruleForm.fudaoyuanName" autocomplete="off" placeholder="辅导员姓名"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="fudaoyuanPhotoFlag">
                            </el-form-item>
                            <el-form-item label="照片" class="input" v-if="tableName=='fudaoyuan'">
                                    <file-upload
                                        tip="点击上传照片"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.fudaoyuanPhoto?$base.url+ruleForm.fudaoyuanPhoto:''"
                                        @change="fudaoyuanPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="辅导员手机号" class="input" v-if="tableName=='fudaoyuan'">
                            <el-input v-model="ruleForm.fudaoyuanPhone" autocomplete="off" placeholder="辅导员手机号"  />
                        </el-form-item>
                        <el-form-item label="辅导员身份证号" class="input" v-if="tableName=='fudaoyuan'">
                            <el-input v-model="ruleForm.fudaoyuanIdNumber" autocomplete="off" placeholder="辅导员身份证号"  />
                        </el-form-item>
                        <el-form-item label="邮箱" class="input" v-if="tableName=='fudaoyuan'">
                            <el-input v-model="ruleForm.fudaoyuanEmail" autocomplete="off" placeholder="邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="假删" class="input" v-if="tableName=='fudaoyuan'">
                                <el-input v-model="ruleForm.fudaoyuanDelete" autocomplete="off" placeholder="假删"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='fudaoyuan'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                        <el-form-item label="企业名称" class="input" v-if="tableName=='qiye'">
                            <el-input v-model="ruleForm.qiyeName" autocomplete="off" placeholder="企业名称"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="企业类型" class="input" v-if="tableName=='qiye'">
                                <el-input v-model="ruleForm.qiyeTypes" autocomplete="off" placeholder="企业类型"  />
                           </el-form-item>
                        -->
                        <el-form-item label="联系方式" class="input" v-if="tableName=='qiye'">
                            <el-input v-model="ruleForm.qiyePhone" autocomplete="off" placeholder="联系方式"  />
                        </el-form-item>
                        <el-form-item label="邮箱" class="input" v-if="tableName=='qiye'">
                            <el-input v-model="ruleForm.qiyeEmail" autocomplete="off" placeholder="邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="qiyePhotoFlag">
                            </el-form-item>
                            <el-form-item label="企业logo" class="input" v-if="tableName=='qiye'">
                                    <file-upload
                                        tip="点击上传企业logo"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.qiyePhoto?$base.url+ruleForm.qiyePhoto:''"
                                        @change="qiyePhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="企业成立时间" class="input" v-if="tableName=='qiye'">
                                <el-input v-model="ruleForm.qiyeChenglishijianTime" autocomplete="off" placeholder="企业成立时间"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="企业介绍" class="input" v-if="tableName=='qiye'">
                                <el-input type="textarea" v-model="ruleForm.qiyeContent" placeholder="企业介绍"></el-input>
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="逻辑删除" class="input" v-if="tableName=='qiye'">
                                <el-input v-model="ruleForm.qiyeDelete" autocomplete="off" placeholder="逻辑删除"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间 show1 show2 photoShow" class="input" v-if="tableName=='qiye'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间 show1 show2 photoShow"  />
                           </el-form-item>
                        -->
                        <el-form-item label="用户姓名" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuName" autocomplete="off" placeholder="用户姓名"  />
                        </el-form-item>
                        <!--
                            <el-form-item v-if="yonghuPhotoFlag">
                            </el-form-item>
                            <el-form-item label="头像" class="input" v-if="tableName=='yonghu'">
                                    <file-upload
                                        tip="点击上传头像"
                                        action="file/upload"
                                        :limit="1"
                                        :multiple="true"
                                        :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                                        @change="yonghuPhotoUploadChange"
                                    ></file-upload>
                           </el-form-item>
                        -->
                        <el-form-item label="用户手机号" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuPhone" autocomplete="off" placeholder="用户手机号"  />
                        </el-form-item>
                        <el-form-item label="用户身份证号" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuIdNumber" autocomplete="off" placeholder="用户身份证号"  />
                        </el-form-item>
                        <el-form-item label="邮箱" class="input" v-if="tableName=='yonghu'">
                            <el-input v-model="ruleForm.yonghuEmail" autocomplete="off" placeholder="邮箱"  />
                        </el-form-item>
                        <!--
                            <el-form-item label="假删" class="input" v-if="tableName=='yonghu'">
                                <el-input v-model="ruleForm.yonghuDelete" autocomplete="off" placeholder="假删"  />
                           </el-form-item>
                        -->
                        <!--
                            <el-form-item label="创建时间" class="input" v-if="tableName=='yonghu'">
                                <el-input v-model="ruleForm.createTime" autocomplete="off" placeholder="创建时间"  />
                           </el-form-item>
                        -->
                    <div style="display: flex;flex-wrap: wrap;width: 100%;justify-content: center;">
                        <el-button class="btn" type="primary" @click="login()">注册</el-button>
                        <el-button class="btn close" type="primary" @click="close()">取消</el-button>
                    </div>
                </el-form>
            </div>
        </div>
    </div>
</template>
<script>
    export default {
        data() {
            return {
                ruleForm: {
                },
                tableName:"",
                rules: {},
                sexTypesOptions : [],
                fudaoyuanPhotoFlag:false,//用于刷新文件上传
                qiyePhotoFlag:false,//用于刷新文件上传
                yonghuPhotoFlag:false,//用于刷新文件上传
            };
        },
        mounted(){
            let table = this.$storage.get("loginTable");
            this.tableName = table;

            //级联表的下拉框查询

        },
        methods: {
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            fudaoyuanPhotoUploadChange(fileUrls) {
               this.ruleForm.fudaoyuanPhoto = fileUrls;
                if(this.fudaoyuanPhotoFlag){
                    this.fudaoyuanPhotoFlag=false;
                }else{
                    this.fudaoyuanPhotoFlag=true;
                }
            },
            qiyePhotoUploadChange(fileUrls) {
               this.ruleForm.qiyePhoto = fileUrls;
                if(this.qiyePhotoFlag){
                    this.qiyePhotoFlag=false;
                }else{
                    this.qiyePhotoFlag=true;
                }
            },
            yonghuPhotoUploadChange(fileUrls) {
               this.ruleForm.yonghuPhoto = fileUrls;
                if(this.yonghuPhotoFlag){
                    this.yonghuPhotoFlag=false;
                }else{
                    this.yonghuPhotoFlag=true;
                }
            },
            close(){
                this.$router.push({ path: "/login" });
            },
            // 注册
            login() {

                            if((!this.ruleForm.username)){
                                this.$message.error('账号不能为空');
                                return
                            }
                            if((!this.ruleForm.password)){
                                this.$message.error('密码不能为空');
                                return
                            }
                            if((!this.ruleForm.repetitionPassword)){
                                this.$message.error('重复密码不能为空');
                                return
                            }
                            if(this.ruleForm.repetitionPassword != this.ruleForm.password){
                                this.$message.error('密码和重复密码不一致');
                                return
                            }
                            if((!this.ruleForm.fudaoyuanName)&& 'fudaoyuan'==this.tableName){
                                this.$message.error('辅导员姓名不能为空');
                                return
                            }
                            // fudaoyuan 中的 照片 判空处理
                            // if('fudaoyuan' == this.tableName && (this.ruleForm.fudaoyuanPhoto== null ||this.ruleForm.fudaoyuanPhoto== "")){
                            //     this.$message.error("照片不能为空");
                            //     return
                            // }
                             if('fudaoyuan' == this.tableName && this.ruleForm.fudaoyuanPhone&&(!this.$validate.isMobile(this.ruleForm.fudaoyuanPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.fudaoyuanIdNumber)&& 'fudaoyuan'==this.tableName){
                                this.$message.error('辅导员身份证号不能为空');
                                return
                            }
                            if('fudaoyuan' == this.tableName && this.ruleForm.fudaoyuanEmail&&(!this.$validate.isEmail(this.ruleForm.fudaoyuanEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // fudaoyuan 中的 假删 判空处理
                            // if('fudaoyuan' == this.tableName && (this.ruleForm.fudaoyuanDelete== null ||this.ruleForm.fudaoyuanDelete== "")){
                            //     this.$message.error("假删不能为空");
                            //     return
                            // }
                            // fudaoyuan 中的 创建时间 判空处理
                            // if('fudaoyuan' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.qiyeName)&& 'qiye'==this.tableName){
                                this.$message.error('企业名称不能为空');
                                return
                            }
                            // qiye 中的 企业类型 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.qiyeTypes== null ||this.ruleForm.qiyeTypes== "")){
                            //     this.$message.error("企业类型不能为空");
                            //     return
                            // }
                             if('qiye' == this.tableName && this.ruleForm.qiyePhone&&(!this.$validate.isMobile(this.ruleForm.qiyePhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if('qiye' == this.tableName && this.ruleForm.qiyeEmail&&(!this.$validate.isEmail(this.ruleForm.qiyeEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // qiye 中的 企业logo 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.qiyePhoto== null ||this.ruleForm.qiyePhoto== "")){
                            //     this.$message.error("企业logo不能为空");
                            //     return
                            // }
                            // qiye 中的 企业成立时间 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.qiyeChenglishijianTime== null ||this.ruleForm.qiyeChenglishijianTime== "")){
                            //     this.$message.error("企业成立时间不能为空");
                            //     return
                            // }
                            // qiye 中的 企业介绍 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.qiyeContent== null ||this.ruleForm.qiyeContent== "")){
                            //     this.$message.error("企业介绍不能为空");
                            //     return
                            // }
                            // qiye 中的 逻辑删除 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.qiyeDelete== null ||this.ruleForm.qiyeDelete== "")){
                            //     this.$message.error("逻辑删除不能为空");
                            //     return
                            // }
                            // qiye 中的 创建时间 show1 show2 photoShow 判空处理
                            // if('qiye' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间 show1 show2 photoShow不能为空");
                            //     return
                            // }
                            if((!this.ruleForm.yonghuName)&& 'yonghu'==this.tableName){
                                this.$message.error('用户姓名不能为空');
                                return
                            }
                            // yonghu 中的 头像 判空处理
                            // if('yonghu' == this.tableName && (this.ruleForm.yonghuPhoto== null ||this.ruleForm.yonghuPhoto== "")){
                            //     this.$message.error("头像不能为空");
                            //     return
                            // }
                             if('yonghu' == this.tableName && this.ruleForm.yonghuPhone&&(!this.$validate.isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error('手机应输入手机格式');
                                 return
                             }
                            if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.tableName){
                                this.$message.error('用户身份证号不能为空');
                                return
                            }
                            if('yonghu' == this.tableName && this.ruleForm.yonghuEmail&&(!this.$validate.isEmail(this.ruleForm.yonghuEmail))){
                                this.$message.error("邮箱应输入邮件格式");
                                return
                            }
                            // yonghu 中的 假删 判空处理
                            // if('yonghu' == this.tableName && (this.ruleForm.yonghuDelete== null ||this.ruleForm.yonghuDelete== "")){
                            //     this.$message.error("假删不能为空");
                            //     return
                            // }
                            // yonghu 中的 创建时间 判空处理
                            // if('yonghu' == this.tableName && (this.ruleForm.createTime== null ||this.ruleForm.createTime== "")){
                            //     this.$message.error("创建时间不能为空");
                            //     return
                            // }
                this.$http({
                    url: `${this.tableName}/register`,
                    method: "post",
                    data:this.ruleForm
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                    this.$message({
                        message: "注册成功,请登录后在个人中心页面补充个人数据",
                        type: "success",
                        duration: 1500,
                        onClose: () => {
                        this.$router.replace({ path: "/login" });
                }
                });
                } else {
                    this.$message.error(data.msg);
                }
            });
            }
        }
    };
</script>
<style lang="scss" scoped>
	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked .el-radio__inner {
		border-color: #00c292;
		background: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.el-radio__input.is-checked+.el-radio__label {
		color: #00c292;
	}

	.h1 {
		margin-top: 10px;
	}

	body {
		padding: 0;
		margin: 0;
	}

	.nk-navigation {
		margin-top: 15px;

		a {
			display: inline-block;
			color: #fff;
			background: rgba(255, 255, 255, .2);
			width: 100px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;
		}

		.icon {
			margin-left: 10px;
			width: 30px;
			height: 30px;
		}
	}

	.register-container {
		margin-top: 10px;

		a {
			display: inline-block;
			color: #fff;
			max-width: 500px;
			height: 50px;
			border-radius: 30px;
			text-align: center;
			display: flex;
			align-items: center;
			margin: 0 auto;
			justify-content: center;
			padding: 0 20px;

			div {
				margin-left: 10px;
			}
		}
	}

	.container {
		height: 100vh;
		background-position: center center;
		background-size: cover;
		background-repeat: no-repeat;
		background-image: url(/wanggongkaozhengzhidao/img/back-img-bg.jpg);


		.login-form {
			right: 50%;
			top: 50%;
			transform: translate3d(50%, -50%, 0);
			border-radius: 10px;
			background-color: rgba(255,255,255,.5);
			font-size: 14px;
			font-weight: 500;
      box-sizing: border-box;

			width: 420px;
			height: auto;
			padding: 15px;
			margin: 0 auto;
			border-radius: 15px;
			border-width: 0;
			border-style: solid;
			border-color: rgba(255,0,0,0);
			background-color: rgba(255, 255, 255, 0.82);
			box-shadow: 0 0 6px rgba(255,0,0,.1);

			.h1 {
				width: 100%;
				height: auto;
				line-height:auto;
				color: #000;
				font-size: 28px;
				padding: 0;
				margin: 20 auto;
				border-radius: 0;
				border-width: 0;
				border-style: solid;
				border-color: rgba(255,0,0,0);
				background-color: rgba(255,0,0,0);
				box-shadow: 0 0 6px rgba(255,0,0,0);
				text-align: center;
			}

			.rgs-form {
				display: flex;
				flex-direction: column;
				justify-content: center;
				align-items: center;

        .el-form-item {
          width: 100%;
          display: flex;

          & /deep/ .el-form-item__content {
            flex: 1;
            display: flex;
          }
        }

				.input {
          width: 90%;
          height:auto;
          padding: 0;
          margin: 0 0 10px 0;
          border-radius: 0;
          border-width: 0;
          border-style: solid;
          border-color: rgba(255,0,0,0);
          background-color: rgba(255,0,0,0);
          box-shadow: 0 0 6px rgba(255,0,0,0);

					& /deep/ .el-form-item__label {
            width: 20%;
            line-height:40px;
            color: rgba(0, 0, 0, 1);
            font-size: 14px;
            padding: 0 10px 0 0;
            margin: 0;
            border-radius: 0;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            background-color: rgba(255,0,0,0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
					}

					& /deep/ .el-input__inner {
            width: 100%;
            height: 40px;
            line-height:40px;
            color: rgba(0, 0, 0, 1);
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 4px;
            border-width: 1px;
            border-style: solid;
            border-color: rgba(0, 0, 0, 1);
            background-color: rgba(255, 255, 255, 0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
					}
				}

        .send-code {
          & /deep/ .el-input__inner {
            width: 195px;
            height: 40px;
            line-height:40px;
            color: rgba(0, 0, 0, 1);
            font-size: 14px;
            padding: 0 12px;
            margin: 0;
            border-radius: 5px 0 0 5px;
            border-width: 1;
            border-style: solid;
            border-color: #606266;
            background-color: rgba(255, 255, 255, 0);
            box-shadow: 0 0 6px rgba(255,0,0,0);
            text-align: left;
          }

          .register-code {
            margin: 0;
            padding: 0;
            width: 86px;
            height: 40px;
            line-height:40px;
            color: #fff;
            font-size: 14px;
            border-width: 0;
            border-style: solid;
            border-color: rgba(255,0,0,0);
            border-radius: 0 5px 5px 0;
            background-color: var(--publicMainColor);
            box-shadow: 0 0 6px rgba(255,0,0,0);
          }
        }

				.btn {
					margin: 10px 0;
          padding: 0 100px 0 75px;
					width: 88px;
					height: 40px;
          line-height:40px;
					color: #fff;
					font-size: 14px;
					border-width: 2px 0 2px 2px;
					border-style: dashed ;
					border-color: rgba(217, 229, 238, 1);
					border-radius: 5px 0 0 5px;
					background-color: var(--publicMainColor);
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

				.close {
          margin: 10px 0;
          padding: 0 100px 0 75px;
          width: 88px;
          height: 40px;
          line-height:40px;
          color: var(--publicMainColor);
          font-size: 14px;
          border-width: 2px 2px 2px 0;
          border-style: dashed ;
          border-color: rgba(220, 232, 240, 1);
          border-radius: 0 5px 5px 0;
          background-color: #FFF;
          box-shadow: 0 0 6px rgba(255,0,0,0);
				}

			}
		}
	}
</style>


