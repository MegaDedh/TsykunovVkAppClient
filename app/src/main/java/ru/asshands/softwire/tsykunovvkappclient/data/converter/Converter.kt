package ru.asshands.softwire.tsykunovvkappclient.data.converter

interface Converter<T, K> {

    fun convert(t: T): K

}