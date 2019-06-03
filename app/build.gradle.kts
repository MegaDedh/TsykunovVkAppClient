plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("android.extensions")
}

android {
    compileSdkVersion (App.targetSdk)

    defaultConfig {
        applicationId = "ru.asshands.softwire.tsykunovvkappclient"
        minSdkVersion(App.minApi)
        targetSdkVersion(App.targetSdk)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName ("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation (Dependecies.kotlin)
    implementation (Dependecies.appCompat)
    implementation (Dependecies.coreKtx)
    implementation (Dependecies.constraintLayout)
    implementation (Dependecies.recyclerView)
    implementation (Dependecies.cicerone)
    implementation (Dependecies.material)
    implementation (Dependecies.anko)

    implementation (Dependecies.glide)
    kapt           (Dependecies.glideCompiler)

    implementation (Dependecies.moxy)
    implementation (Dependecies.moxyAppCompat)
    kapt           (Dependecies.moxyCompiler)

    implementation (Dependecies.dagger)
    implementation (Dependecies.daggerAndroidSupport)
    kapt           (Dependecies.daggerCompiler)
    kapt           (Dependecies.daggerAndroidProcessor)

    implementation (Dependecies.timber)
    implementation (Dependecies.okhttp3Interceptor)

    implementation (Dependecies.roomRuntime)
    implementation (Dependecies.roomRx)
    kapt           (Dependecies.roomCompiler)

    implementation (Dependecies.retrofit2)
    implementation (Dependecies.retrofit2ConverterGson)
    implementation (Dependecies.retrofit2AdapterRxJava)

    implementation (Dependecies.rxAndroid)
    testImplementation (Dependecies.jUnit)
    androidTestImplementation (Dependecies.testRunner)
    androidTestImplementation (Dependecies.testEspressoCore)
}
