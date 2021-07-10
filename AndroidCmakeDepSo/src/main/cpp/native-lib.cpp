#include <jni.h>
#include <string>
#include <android/log.h>
#include <rtmp.h>
#include <rtmp_sys.h>

#include <x264.h>

//#include


extern "C" JNIEXPORT jstring JNICALL
Java_com_gooker_ndk_rtmp_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {

    RTMP rtmp;
    RTMP_Init(&rtmp);
    int version = RTMP_LibVersion();

    __android_log_print(ANDROID_LOG_ERROR, "main_rtmp", "rtmp version:%d", version);
    RTMP_Close(&rtmp);

//    X264
//    rtmp

    std::string x264_version = X264_VERSION;
    __android_log_print(ANDROID_LOG_ERROR, "AndroidCmake", "x264 version is %s",
                        x264_version.c_str());

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}