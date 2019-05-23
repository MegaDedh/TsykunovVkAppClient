package ru.asshands.softwire.tsykunovvkappclient.dagger

import javax.inject.Scope

//@Scope – предоставляют возможность создания глобальных и “локальных синглтонов”
//@Qualifier – если необходимы разные объекты одного типа
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope
