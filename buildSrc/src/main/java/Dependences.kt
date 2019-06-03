object App {
    val targetSdk = 28
    val minApi = 21
}

object Versions {
    val gradle = "3.4.1"
    val kotlin = "1.3.31"
    val appCompat = "1.0.2" // same versions appCompat = coreKtx?
    val coreKtx = "1.0.2"   // same versions appCompat = coreKtx?
    val constraintLayout = "1.1.3"
    val recyclerView = "1.0.0"
    val cicerone = "5.0.0"
    val material = "1.0.0"
    val glide = "4.9.0"
    val moxy = "1.5.5"
    val anko = "0.10.8"
    val dagger = "2.22.1"
    val timber = "4.7.1"
    val okhttp3Interceptor = "3.14.2"
    val room = "2.0.0"
    val retrofit2 = "2.5.0"
    val rxAndroid = "2.1.1"
    val jUnit = "4.12"
    val testRunner = "1.1.1"
    val testEspressoCore = "3.1.1"
}

object Dependecies {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    val cicerone = "ru.terrakok.cicerone:cicerone:${Versions.cicerone}"
    val material = "com.google.android.material:material:${Versions.material}"
    val anko = "org.jetbrains.anko:anko:${Versions.anko}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val moxy = "com.arello-mobile:moxy:${Versions.moxy}"
    val moxyAppCompat = "com.arello-mobile:moxy-app-compat:${Versions.moxy}"
    val moxyCompiler = "com.arello-mobile:moxy-compiler:${Versions.moxy}"

    val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.dagger}"
    val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    val daggerAndroidProcessor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    val okhttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3Interceptor}"

    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomRx = "androidx.room:room-rxjava2:${Versions.room}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit2}"
    val retrofit2ConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit2}"
    val retrofit2AdapterRxJava = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit2}"

    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val jUnit = "unit:junit:${Versions.jUnit}"
    val testRunner = "androidx.test:runner:${Versions.testRunner}"
    val testEspressoCore = "androidx.test.espresso:espresso-core:${Versions.testEspressoCore}"
    }

object Classpaths {
    val gradle = "com.android.tools.build:gradle:${Versions.gradle}"
    val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}