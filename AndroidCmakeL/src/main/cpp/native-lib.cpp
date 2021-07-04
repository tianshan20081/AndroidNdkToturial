#include <jni.h>
#include <string>
#include <android/log.h>

#include <x264.h>


extern "C" JNIEXPORT jstring JNICALL
Java_com_gooker_ndk_toturial_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {

//    System *system;
//    System_Create(&system);
//    unsigned int version;
//    system->getVersion(&version);
//    __android_log_print(ANDROID_LOG_ERROR, "AndroidCmake", "Fmod Version is: %08x", version);

    std::string version = X264_VERSION;

    std::string hello = "Hello from C++";

    __android_log_print(ANDROID_LOG_ERROR, "AndroidCmake", "x264 version is %s", version.c_str());
    return env->NewStringUTF(hello.c_str());
}