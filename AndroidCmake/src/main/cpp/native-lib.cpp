#include <jni.h>
#include <string>
#include <android/log.h>

#include <fmod.hpp>


using namespace FMOD;

extern "C" JNIEXPORT jstring JNICALL
Java_com_gooker_ndk_toturial_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {

    System *system;
    System_Create(&system);
    unsigned int version;
    system->getVersion(&version);
    __android_log_print(ANDROID_LOG_ERROR, "AndroidCmake", "Fmod Version is: %08x", version);

    std::string hello = "Hello from C++";

    __android_log_print(ANDROID_LOG_ERROR, "AndroidCmake", "log info is %s", hello.c_str());
    return env->NewStringUTF(hello.c_str());
}