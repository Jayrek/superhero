package com.jrektabasa.superhero.common.extension

import java.math.BigInteger
import java.security.MessageDigest

fun String.toMD5(): String {
    val md5Bytes = MessageDigest.getInstance("MD5").digest(toByteArray())
    val bigInt = BigInteger(1, md5Bytes)
    return bigInt.toString(16).padStart(32, '0')
}