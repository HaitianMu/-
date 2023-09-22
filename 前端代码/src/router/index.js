import { createRouter, createWebHistory } from 'vue-router'
// import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/searchresult',
      name: 'searchresult',
      component: () => import('../views/search/SearchResultView.vue')
    },
    {
      path: '/user/login',
      name: 'userlogin',
      component: () => import('../views/user/UserLogin.vue')
    },
    {
      path: '/user/register',
      name: 'userregister',
      component: () => import('../views/user/UserRegister.vue')
    },
    {
      path: '/companydetails',
      name: 'companydatails',
      component: () => import('../views/search/InfoDetailsView.vue')
    },
    {
      path: '/',
      name: 'mainpage',
      component: () => import('../views/mainpage.vue')
    },
    {
      path: '/overview/national',
      name: 'nationaloverview',
      component: () => import('../views/overview/NationalOverview.vue')
    },

    {
      path: "/overview/region",
      name: "regionoverview",
      component: () => import('../views/overview/RegionOverview.vue')
    }
  ]
})

export default router
