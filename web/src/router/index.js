import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/Login'
import sindex from '@/components/Student/index'
import tindex from '@/components/Teacher/index'
import aindex from '@/components/Administrator/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component:Login
    },
    {
      path: '/student',
      name: 'sindex',
      component:sindex,
    },
    {
      path: '/teacher',
      name: 'tindex',
      component:tindex
    },
    {
      path: '/administrator',
      name: 'aindex',
      component:aindex
    },
    {
      path: '*',
      redirect: '/'
    }
  ]
})
