import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import biyequxiang from '@/views/modules/biyequxiang/list'
    import chat from '@/views/modules/chat/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fudaoyuan from '@/views/modules/fudaoyuan/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jianli from '@/views/modules/jianli/list'
    import jiuyezhishi from '@/views/modules/jiuyezhishi/list'
    import jiuyezhishiCollection from '@/views/modules/jiuyezhishiCollection/list'
    import jiuyezhishiLiuyan from '@/views/modules/jiuyezhishiLiuyan/list'
    import qiye from '@/views/modules/qiye/list'
    import yonghu from '@/views/modules/yonghu/list'
    import zhaopin from '@/views/modules/zhaopin/list'
    import zhaopinCollection from '@/views/modules/zhaopinCollection/list'
    import zhaopinLiuyan from '@/views/modules/zhaopinLiuyan/list'
    import zhaopinToudi from '@/views/modules/zhaopinToudi/list'
    import config from '@/views/modules/config/list'
    import dictionaryBiyequxiang from '@/views/modules/dictionaryBiyequxiang/list'
    import dictionaryChat from '@/views/modules/dictionaryChat/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJianli from '@/views/modules/dictionaryJianli/list'
    import dictionaryJiuyezhishi from '@/views/modules/dictionaryJiuyezhishi/list'
    import dictionaryJiuyezhishiCollection from '@/views/modules/dictionaryJiuyezhishiCollection/list'
    import dictionaryLeixing from '@/views/modules/dictionaryLeixing/list'
    import dictionaryQiye from '@/views/modules/dictionaryQiye/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryZhaopin from '@/views/modules/dictionaryZhaopin/list'
    import dictionaryZhaopinCollection from '@/views/modules/dictionaryZhaopinCollection/list'
    import dictionaryZhaopinToudiYesno from '@/views/modules/dictionaryZhaopinToudiYesno/list'
    import dictionaryZhuangtai from '@/views/modules/dictionaryZhuangtai/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryBiyequxiang',
        name: '毕业去向类型',
        component: dictionaryBiyequxiang
    }
    ,{
        path: '/dictionaryChat',
        name: '数据类型',
        component: dictionaryChat
    }
    ,{
        path: '/dictionaryGonggao',
        name: '招聘公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJianli',
        name: '求职意向',
        component: dictionaryJianli
    }
    ,{
        path: '/dictionaryJiuyezhishi',
        name: '就业知识类型',
        component: dictionaryJiuyezhishi
    }
    ,{
        path: '/dictionaryJiuyezhishiCollection',
        name: '收藏表类型',
        component: dictionaryJiuyezhishiCollection
    }
    ,{
        path: '/dictionaryLeixing',
        name: '招聘类型',
        component: dictionaryLeixing
    }
    ,{
        path: '/dictionaryQiye',
        name: '企业类型',
        component: dictionaryQiye
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '是否上架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryZhaopin',
        name: '招聘岗位',
        component: dictionaryZhaopin
    }
    ,{
        path: '/dictionaryZhaopinCollection',
        name: '收藏表类型',
        component: dictionaryZhaopinCollection
    }
    ,{
        path: '/dictionaryZhaopinToudiYesno',
        name: '审核状态',
        component: dictionaryZhaopinToudiYesno
    }
    ,{
        path: '/dictionaryZhuangtai',
        name: '状态',
        component: dictionaryZhuangtai
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/biyequxiang',
        name: '毕业去向',
        component: biyequxiang
      }
    ,{
        path: '/chat',
        name: '就业咨询',
        component: chat
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/fudaoyuan',
        name: '辅导员',
        component: fudaoyuan
      }
    ,{
        path: '/gonggao',
        name: '招聘公告',
        component: gonggao
      }
    ,{
        path: '/jianli',
        name: '简历',
        component: jianli
      }
    ,{
        path: '/jiuyezhishi',
        name: '就业知识',
        component: jiuyezhishi
      }
    ,{
        path: '/jiuyezhishiCollection',
        name: '就业知识收藏',
        component: jiuyezhishiCollection
      }
    ,{
        path: '/jiuyezhishiLiuyan',
        name: '就业知识留言',
        component: jiuyezhishiLiuyan
      }
    ,{
        path: '/qiye',
        name: '企业',
        component: qiye
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/zhaopin',
        name: '职位招聘',
        component: zhaopin
      }
    ,{
        path: '/zhaopinCollection',
        name: '职位收藏',
        component: zhaopinCollection
      }
    ,{
        path: '/zhaopinLiuyan',
        name: '职位留言',
        component: zhaopinLiuyan
      }
    ,{
        path: '/zhaopinToudi',
        name: '简历投递',
        component: zhaopinToudi
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
