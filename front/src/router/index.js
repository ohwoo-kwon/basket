import Vue from 'vue'
import VueRouter from 'vue-router'
import PickUp from '../views/PickUp.vue'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'PickUp',
    component: PickUp
  },
  {
    path: '/login',
    name: 'Login',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    // component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
    component: Login
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router