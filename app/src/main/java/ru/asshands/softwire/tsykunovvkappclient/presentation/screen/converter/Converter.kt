package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter

interface Converter<T, K> {

    fun convert(t: T): K

}