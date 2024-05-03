package ali.hrhera.module.newtwok.service

import ali.hrhera.module.network.BuildConfig


object NetworkConstants {
    const val CACHE_SIZE: Long = (10 * 1024 * 1024).toLong()// 10 MB

    const val timeOut = 3000L


    const val BASE_URL = BuildConfig.BASE_URL



}