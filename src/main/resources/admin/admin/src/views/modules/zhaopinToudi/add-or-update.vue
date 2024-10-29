<template>
    <div class="addEdit-block">
        <el-form
                class="detail-form-content"
                ref="ruleForm"
                :model="ruleForm"
                :rules="rules"
                label-width="auto"
                >
            <el-row>
                <el-col :span="12"  v-if="sessionTable !='jianli'">
                    <el-form-item class="select" v-if="type!='info'"  label="简历" prop="jianliId">
                        <el-select v-model="ruleForm.jianliId" :disabled="ro.jianliId" filterable placeholder="请选择简历" @change="jianliChange">
                            <el-option
                                    v-for="(item,index) in jianliOptions"
                                    v-bind:key="item.id"
                                    :label="item.jianliName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="简历唯一编号" prop="jianliUuidNumber">
                        <el-input v-model="jianliForm.jianliUuidNumber"
                                  placeholder="简历唯一编号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="简历唯一编号" prop="jianliUuidNumber">
                            <el-input v-model="ruleForm.jianliUuidNumber"
                                      placeholder="简历唯一编号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="简历标题" prop="jianliName">
                        <el-input v-model="jianliForm.jianliName"
                                  placeholder="简历标题" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="简历标题" prop="jianliName">
                            <el-input v-model="ruleForm.jianliName"
                                      placeholder="简历标题" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="姓名" prop="jianliXingming">
                        <el-input v-model="jianliForm.jianliXingming"
                                  placeholder="姓名" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="姓名" prop="jianliXingming">
                            <el-input v-model="ruleForm.jianliXingming"
                                      placeholder="姓名" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="求职意向" prop="jianliValue">
                        <el-input v-model="jianliForm.jianliValue"
                                  placeholder="求职意向" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="求职意向" prop="jianliValue">
                            <el-input v-model="ruleForm.jianliValue"
                                      placeholder="求职意向" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="期望工资" prop="jianliXinzi">
                        <el-input v-model="jianliForm.jianliXinzi"
                                  placeholder="期望工资" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="期望工资" prop="jianliXinzi">
                            <el-input v-model="ruleForm.jianliXinzi"
                                      placeholder="期望工资" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="学历" prop="jianliXueli">
                        <el-input v-model="jianliForm.jianliXueli"
                                  placeholder="学历" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="学历" prop="jianliXueli">
                            <el-input v-model="ruleForm.jianliXueli"
                                      placeholder="学历" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="工作经历" prop="jianliJingli">
                        <el-input v-model="jianliForm.jianliJingli"
                                  placeholder="工作经历" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="工作经历" prop="jianliJingli">
                            <el-input v-model="ruleForm.jianliJingli"
                                      placeholder="工作经历" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="性别" prop="sexValue">
                        <el-input v-model="jianliForm.sexValue"
                                  placeholder="性别" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="性别" prop="sexValue">
                            <el-input v-model="ruleForm.sexValue"
                                      placeholder="性别" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="手机号" prop="jianliPhone">
                        <el-input v-model="jianliForm.jianliPhone"
                                  placeholder="手机号" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="手机号" prop="jianliPhone">
                            <el-input v-model="ruleForm.jianliPhone"
                                      placeholder="手机号" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='jianli' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.jianliPhoto" label="照片" prop="jianliPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (jianliForm.jianliPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.jianliPhoto" label="照片" prop="jianliPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.jianliPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="现在位置" prop="jianliAddress">
                        <el-input v-model="jianliForm.jianliAddress"
                                  placeholder="现在位置" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="现在位置" prop="jianliAddress">
                            <el-input v-model="ruleForm.jianliAddress"
                                      placeholder="现在位置" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="教育经历" prop="jiaoyuText">
                        <el-input v-model="jianliForm.jiaoyuText"
                                  placeholder="教育经历" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="教育经历" prop="jiaoyuText">
                            <el-input v-model="ruleForm.jiaoyuText"
                                      placeholder="教育经历" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="实习或工作经历" prop="shixiText">
                        <el-input v-model="jianliForm.shixiText"
                                  placeholder="实习或工作经历" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="实习或工作经历" prop="shixiText">
                            <el-input v-model="ruleForm.shixiText"
                                      placeholder="实习或工作经历" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='jianli' ">
                    <el-form-item class="input" v-if="type!='info'"  label="个人介绍" prop="gerenText">
                        <el-input v-model="jianliForm.gerenText"
                                  placeholder="个人介绍" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="个人介绍" prop="gerenText">
                            <el-input v-model="ruleForm.gerenText"
                                      placeholder="个人介绍" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin'">
                    <el-form-item class="select" v-if="type!='info'"  label="职位招聘" prop="zhaopinId">
                        <el-select v-model="ruleForm.zhaopinId" :disabled="ro.zhaopinId" filterable placeholder="请选择职位招聘" @change="zhaopinChange">
                            <el-option
                                    v-for="(item,index) in zhaopinOptions"
                                    v-bind:key="item.id"
                                    :label="item.zhaopinName"
                                    :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>

                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="招聘信息名称" prop="zhaopinName">
                        <el-input v-model="zhaopinForm.zhaopinName"
                                  placeholder="招聘信息名称" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="招聘信息名称" prop="zhaopinName">
                            <el-input v-model="ruleForm.zhaopinName"
                                      placeholder="招聘信息名称" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12" v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="upload" v-if="type!='info' && !ro.zhaopinPhoto" label="招聘信息照片" prop="zhaopinPhoto">
                        <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (zhaopinForm.zhaopinPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item v-if="ruleForm.zhaopinPhoto" label="招聘信息照片" prop="zhaopinPhoto">
                            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in (ruleForm.zhaopinPhoto || '').split(',')" :src="$base.url+item" width="100" height="100">
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="薪资待遇" prop="zhaopinDaiyu">
                        <el-input v-model="zhaopinForm.zhaopinDaiyu"
                                  placeholder="薪资待遇" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="薪资待遇" prop="zhaopinDaiyu">
                            <el-input v-model="ruleForm.zhaopinDaiyu"
                                      placeholder="薪资待遇" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="上班地点" prop="zhaopinAddress">
                        <el-input v-model="zhaopinForm.zhaopinAddress"
                                  placeholder="上班地点" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="上班地点" prop="zhaopinAddress">
                            <el-input v-model="ruleForm.zhaopinAddress"
                                      placeholder="上班地点" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="联系人" prop="lianxirenName">
                        <el-input v-model="zhaopinForm.lianxirenName"
                                  placeholder="联系人" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="联系人" prop="lianxirenName">
                            <el-input v-model="ruleForm.lianxirenName"
                                      placeholder="联系人" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="招聘电话" prop="zhaopinPhone">
                        <el-input v-model="zhaopinForm.zhaopinPhone"
                                  placeholder="招聘电话" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="招聘电话" prop="zhaopinPhone">
                            <el-input v-model="ruleForm.zhaopinPhone"
                                      placeholder="招聘电话" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="招聘岗位" prop="zhaopinValue">
                        <el-input v-model="zhaopinForm.zhaopinValue"
                                  placeholder="招聘岗位" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="招聘岗位" prop="zhaopinValue">
                            <el-input v-model="ruleForm.zhaopinValue"
                                      placeholder="招聘岗位" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="招聘类型" prop="leixingValue">
                        <el-input v-model="zhaopinForm.leixingValue"
                                  placeholder="招聘类型" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="招聘类型" prop="leixingValue">
                            <el-input v-model="ruleForm.leixingValue"
                                      placeholder="招聘类型" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="赞" prop="zanNumber">
                        <el-input v-model="zhaopinForm.zanNumber"
                                  placeholder="赞" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="赞" prop="zanNumber">
                            <el-input v-model="ruleForm.zanNumber"
                                      placeholder="赞" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="踩" prop="caiNumber">
                        <el-input v-model="zhaopinForm.caiNumber"
                                  placeholder="踩" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="踩" prop="caiNumber">
                            <el-input v-model="ruleForm.caiNumber"
                                      placeholder="踩" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <el-col :span="12"  v-if="sessionTable !='zhaopin' ">
                    <el-form-item class="input" v-if="type!='info'"  label="招聘人数" prop="zhaopinRenshuNumber">
                        <el-input v-model="zhaopinForm.zhaopinRenshuNumber"
                                  placeholder="招聘人数" clearable readonly></el-input>
                    </el-form-item>
                    <div v-else-if="type=='info'">
                        <el-form-item class="input" label="招聘人数" prop="zhaopinRenshuNumber">
                            <el-input v-model="ruleForm.zhaopinRenshuNumber"
                                      placeholder="招聘人数" readonly></el-input>
                        </el-form-item>
                    </div>
                </el-col>
                <input id="updateId" name="id" type="hidden">
            <input id="jianliId" name="jianliId" type="hidden">
            <input id="zhaopinId" name="zhaopinId" type="hidden">
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.zhaopinToudiYesnoTypes" label="审核状态" prop="zhaopinToudiYesnoTypes">
                        <el-input v-model="ruleForm.zhaopinToudiYesnoValue" placeholder="审核状态" readonly></el-input>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.zhaopinToudiYesnoText" label="投递回复" prop="zhaopinToudiYesnoText">
                        <span v-html="ruleForm.zhaopinToudiYesnoText"></span>
                    </el-form-item>
                </div>
            </el-col>
            <el-col :span="12" v-if="type=='info'">
                <div>
                    <el-form-item v-if="ruleForm.zhaopinToudiShenheTime" label="回复时间" prop="zhaopinToudiShenheTime">
                        <span v-html="ruleForm.zhaopinToudiShenheTime"></span>
                    </el-form-item>
                </div>
            </el-col>
            </el-row>
            <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
                <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
                <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    import styleJs from "../../../utils/style.js";
    // 数字，邮件，手机，url，身份证校验
    import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
    import utilsJs, {getYearFormat,getMonthFormat,getDateFormat,getDatetimeFormat} from "../../../utils/utils.js";
    export default {
        data() {
            return {
                addEditForm:null,
                id: '',
                type: '',
                sessionTable : "",//登录账户所在表名
                role : "",//权限
                userId:"",//当前登录人的id
                jianliForm: {},
                zhaopinForm: {},
                ro:{
                    jianliId: false,
                    zhaopinId: false,
                    insertTime: false,
                    zhaopinToudiYesnoTypes: false,
                    zhaopinToudiYesnoText: false,
                    zhaopinToudiShenheTime: false,
                },
                ruleForm: {
                    jianliId: '',
                    zhaopinId: '',
                    insertTime: '',
                    zhaopinToudiYesnoTypes: '',
                    zhaopinToudiYesnoText: '',
                    zhaopinToudiShenheTime: '',
                },
                zhaopinToudiYesnoTypesOptions : [],
                jianliOptions : [],
                zhaopinOptions : [],
                rules: {
                   jianliId: [
                              { required: true, message: '简历不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhaopinId: [
                              { required: true, message: '招聘不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   insertTime: [
                              { required: true, message: '投递时间不能为空', trigger: 'blur' },
                          ],
                   zhaopinToudiYesnoTypes: [
                              { required: true, message: '审核状态不能为空', trigger: 'blur' },
                              {  pattern: /^[0-9]*$/,
                                  message: '只允许输入整数',
                                  trigger: 'blur'
                              }
                          ],
                   zhaopinToudiYesnoText: [
                              { required: true, message: '投递回复不能为空', trigger: 'blur' },
                          ],
                   zhaopinToudiShenheTime: [
                              { required: true, message: '回复时间不能为空', trigger: 'blur' },
                          ],
                }
            };
        },
        props: ["parent"],
        computed: {
        },
        created() {
            //获取当前登录用户的信息
            this.sessionTable = this.$storage.get("sessionTable");
            this.role = this.$storage.get("role");
            this.userId = this.$storage.get("userId");


            if (this.role != "管理员"){
            }else{
            }
            this.addEditForm = styleJs.addStyle();
            this.addEditStyleChange()
            this.addEditUploadStyleChange()
            //获取下拉框信息
                this.$http({
                    url:`dictionary/page?page=1&limit=100&sort=&order=&dicCode=zhaopin_toudi_yesno_types`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhaopinToudiYesnoTypesOptions = data.data.list;
                    }
                });

         this.$http({
             url: `jianli/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.jianliOptions = data.data.list;
            }
         });
         this.$http({
             url: `zhaopin/page?page=1&limit=100`,
             method: "get"
         }).then(({ data }) => {
             if (data && data.code === 0) {
                this.zhaopinOptions = data.data.list;
            }
         });

        },
        mounted() {
        },
        methods: {
            // 下载
            download(file){
                window.open(`${file}`)
            },
            // 初始化
            init(id,type) {
                if (id) {
                    this.id = id;
                    this.type = type;
                }
                if(this.type=='info'||this.type=='else'){
                    this.info(id);
                }
                // 获取用户信息
                this.$http({
                    url:`${this.$storage.get("sessionTable")}/session`,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        var json = data.data;
                    } else {
                        this.$message.error(data.msg);
                    }
                });
            },
            jianliChange(id){
                this.$http({
                    url: `jianli/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.jianliForm = data.data;
                    }
                });
            },
            zhaopinChange(id){
                this.$http({
                    url: `zhaopin/info/`+id,
                    method: "get"
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        this.zhaopinForm = data.data;
                    }
                });
            },
            // 多级联动参数
            info(id) {
                let _this =this;
                _this.$http({
                    url: `zhaopinToudi/info/${id}`,
                    method: 'get'
                }).then(({ data }) => {
                    if (data && data.code === 0) {
                        _this.ruleForm = data.data;
                        _this.jianliChange(data.data.jianliId)
                        _this.zhaopinChange(data.data.zhaopinId)
                    } else {
                        _this.$message.error(data.msg);
                    }
                });
            },
            // 提交
            onSubmit() {
                this.$refs["ruleForm"].validate(valid => {
                    if (valid) {
                        this.$http({
                            url:`zhaopinToudi/${!this.ruleForm.id ? "save" : "update"}`,
                            method: "post",
                            data: this.ruleForm
                        }).then(({ data }) => {
                            if (data && data.code === 0) {
                                this.$message({
                                    message: "操作成功",
                                    type: "success",
                                    duration: 1500,
                                    onClose: () => {
                                        this.parent.showFlag = true;
                                        this.parent.addOrUpdateFlag = false;
                                        this.parent.zhaopinToudiCrossAddOrUpdateFlag = false;
                                        this.parent.search();
                                        this.parent.contentStyleChange();
                                    }
                                });
                            } else {
                                this.$message.error(data.msg);
                            }
                        });
                    }
                });
            },
            // 获取uuid
            getUUID () {
                return new Date().getTime();
            },
            // 返回
            back() {
                this.parent.showFlag = true;
                this.parent.addOrUpdateFlag = false;
                this.parent.zhaopinToudiCrossAddOrUpdateFlag = false;
                this.parent.contentStyleChange();
            },
            //图片

            addEditStyleChange() {
                this.$nextTick(()=>{
                    // input
                    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputFontColor
                        el.style.fontSize = this.addEditForm.inputFontSize
                        el.style.borderWidth = this.addEditForm.inputBorderWidth
                        el.style.borderStyle = this.addEditForm.inputBorderStyle
                        el.style.borderColor = this.addEditForm.inputBorderColor
                        el.style.borderRadius = this.addEditForm.inputBorderRadius
                        el.style.backgroundColor = this.addEditForm.inputBgColor
                    })
                    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.inputHeight
                        el.style.color = this.addEditForm.inputLableColor
                        el.style.fontSize = this.addEditForm.inputLableFontSize
                    })
                    // select
                    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectFontColor
                        el.style.fontSize = this.addEditForm.selectFontSize
                        el.style.borderWidth = this.addEditForm.selectBorderWidth
                        el.style.borderStyle = this.addEditForm.selectBorderStyle
                        el.style.borderColor = this.addEditForm.selectBorderColor
                        el.style.borderRadius = this.addEditForm.selectBorderRadius
                        el.style.backgroundColor = this.addEditForm.selectBgColor
                    })
                    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.selectHeight
                        el.style.color = this.addEditForm.selectLableColor
                        el.style.fontSize = this.addEditForm.selectLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
                        el.style.color = this.addEditForm.selectIconFontColor
                        el.style.fontSize = this.addEditForm.selectIconFontSize
                    })
                    // date
                    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
                        el.style.height = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateFontColor
                        el.style.fontSize = this.addEditForm.dateFontSize
                        el.style.borderWidth = this.addEditForm.dateBorderWidth
                        el.style.borderStyle = this.addEditForm.dateBorderStyle
                        el.style.borderColor = this.addEditForm.dateBorderColor
                        el.style.borderRadius = this.addEditForm.dateBorderRadius
                        el.style.backgroundColor = this.addEditForm.dateBgColor
                    })
                    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.dateHeight
                        el.style.color = this.addEditForm.dateLableColor
                        el.style.fontSize = this.addEditForm.dateLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
                        el.style.color = this.addEditForm.dateIconFontColor
                        el.style.fontSize = this.addEditForm.dateIconFontSize
                        el.style.lineHeight = this.addEditForm.dateHeight
                    })
                    // upload
                    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
                    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
                        el.style.lineHeight = this.addEditForm.uploadHeight
                        el.style.color = this.addEditForm.uploadLableColor
                        el.style.fontSize = this.addEditForm.uploadLableFontSize
                    })
                    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
                        el.style.color = this.addEditForm.uploadIconFontColor
                        el.style.fontSize = this.addEditForm.uploadIconFontSize
                        el.style.lineHeight = iconLineHeight
                        el.style.display = 'block'
                    })
                    // 多文本输入框
                    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
                        el.style.height = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaFontColor
                        el.style.fontSize = this.addEditForm.textareaFontSize
                        el.style.borderWidth = this.addEditForm.textareaBorderWidth
                        el.style.borderStyle = this.addEditForm.textareaBorderStyle
                        el.style.borderColor = this.addEditForm.textareaBorderColor
                        el.style.borderRadius = this.addEditForm.textareaBorderRadius
                        el.style.backgroundColor = this.addEditForm.textareaBgColor
                    })
                    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
                        // el.style.lineHeight = this.addEditForm.textareaHeight
                        el.style.color = this.addEditForm.textareaLableColor
                        el.style.fontSize = this.addEditForm.textareaLableFontSize
                    })
                    // 保存
                    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
                        el.style.width = this.addEditForm.btnSaveWidth
                        el.style.height = this.addEditForm.btnSaveHeight
                        el.style.color = this.addEditForm.btnSaveFontColor
                        el.style.fontSize = this.addEditForm.btnSaveFontSize
                        el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
                        el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
                        el.style.borderColor = this.addEditForm.btnSaveBorderColor
                        el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnSaveBgColor
                    })
                    // 返回
                    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
                        el.style.width = this.addEditForm.btnCancelWidth
                        el.style.height = this.addEditForm.btnCancelHeight
                        el.style.color = this.addEditForm.btnCancelFontColor
                        el.style.fontSize = this.addEditForm.btnCancelFontSize
                        el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
                        el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
                        el.style.borderColor = this.addEditForm.btnCancelBorderColor
                        el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
                        el.style.backgroundColor = this.addEditForm.btnCancelBgColor
                    })
                })
            },
            addEditUploadStyleChange() {
                this.$nextTick(()=>{
                    document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
                        el.style.width = this.addEditForm.uploadHeight
                        el.style.height = this.addEditForm.uploadHeight
                        el.style.borderWidth = this.addEditForm.uploadBorderWidth
                        el.style.borderStyle = this.addEditForm.uploadBorderStyle
                        el.style.borderColor = this.addEditForm.uploadBorderColor
                        el.style.borderRadius = this.addEditForm.uploadBorderRadius
                        el.style.backgroundColor = this.addEditForm.uploadBgColor
                    })
                })
            },
        }
    };
</script>
<style lang="scss">
.editor{
  height: 500px;

  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
	background-color: transparent;
}
.btn .el-button {
  padding: 0;
}</style>

