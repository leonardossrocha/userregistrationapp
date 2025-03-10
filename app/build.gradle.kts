plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.rocha.userregistrationapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rocha.userregistrationapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    // Biblioteca principal do Room
    implementation ("androidx.room:room-runtime:2.6.1")

    // Processador de anotações do Room (necessário para gerar código automaticamente)
    annotationProcessor ("androidx.room:room-compiler:2.6.1")

    // Opcional: Suporte para corrotinas (caso queira usar Room com Kotlin)
    implementation ("androidx.room:room-ktx:2.6.1")
}