package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter

interface PresentationConverter<T, K> {

    fun convert(t: T): K

}