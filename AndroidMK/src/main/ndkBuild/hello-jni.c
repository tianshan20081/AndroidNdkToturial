#include <jni.h>

int test() {
    return 123;
}


jint Java_com_gooker_ndk_mk_jni_NdkHelper_test(JNIEnv *env, jclass clazz) {
    return test();
}