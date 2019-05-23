package ru.asshands.softwire.tsykunovvkappclient.data.converter

interface Converter<T, K> {

    fun convertTo(t: T): K

    fun convertFrom(k: K): T

}