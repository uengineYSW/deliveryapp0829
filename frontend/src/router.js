
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import 고객CustomerManager from "./components/listers/고객CustomerCards"
import 고객CustomerDetail from "./components/listers/고객CustomerDetail"

import 주문OrderManager from "./components/listers/주문OrderCards"
import 주문OrderDetail from "./components/listers/주문OrderDetail"
import 주문StoreManager from "./components/listers/주문StoreCards"
import 주문StoreDetail from "./components/listers/주문StoreDetail"
import 주문PaymentManager from "./components/listers/주문PaymentCards"
import 주문PaymentDetail from "./components/listers/주문PaymentDetail"

import 배달DeliveryManager from "./components/listers/배달DeliveryCards"
import 배달DeliveryDetail from "./components/listers/배달DeliveryDetail"
import 배달RiderManager from "./components/listers/배달RiderCards"
import 배달RiderDetail from "./components/listers/배달RiderDetail"

import 알림NotificationManager from "./components/listers/알림NotificationCards"
import 알림NotificationDetail from "./components/listers/알림NotificationDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/고객/customers',
                name: '고객CustomerManager',
                component: 고객CustomerManager
            },
            {
                path: '/고객/customers/:id',
                name: '고객CustomerDetail',
                component: 고객CustomerDetail
            },

            {
                path: '/주문/orders',
                name: '주문OrderManager',
                component: 주문OrderManager
            },
            {
                path: '/주문/orders/:id',
                name: '주문OrderDetail',
                component: 주문OrderDetail
            },
            {
                path: '/주문/stores',
                name: '주문StoreManager',
                component: 주문StoreManager
            },
            {
                path: '/주문/stores/:id',
                name: '주문StoreDetail',
                component: 주문StoreDetail
            },
            {
                path: '/주문/payments',
                name: '주문PaymentManager',
                component: 주문PaymentManager
            },
            {
                path: '/주문/payments/:id',
                name: '주문PaymentDetail',
                component: 주문PaymentDetail
            },

            {
                path: '/배달/deliveries',
                name: '배달DeliveryManager',
                component: 배달DeliveryManager
            },
            {
                path: '/배달/deliveries/:id',
                name: '배달DeliveryDetail',
                component: 배달DeliveryDetail
            },
            {
                path: '/배달/riders',
                name: '배달RiderManager',
                component: 배달RiderManager
            },
            {
                path: '/배달/riders/:id',
                name: '배달RiderDetail',
                component: 배달RiderDetail
            },

            {
                path: '/알림/notifications',
                name: '알림NotificationManager',
                component: 알림NotificationManager
            },
            {
                path: '/알림/notifications/:id',
                name: '알림NotificationDetail',
                component: 알림NotificationDetail
            },



    ]
})
