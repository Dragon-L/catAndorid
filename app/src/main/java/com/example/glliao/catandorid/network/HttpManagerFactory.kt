package com.example.glliao.catandorid.network

class HttpManagerFactory {
    companion object {
        private val sInstance: HttpManager = HttpManagerImpl()

        fun getHttpManager(): HttpManager {
            return sInstance
        }
    }
}