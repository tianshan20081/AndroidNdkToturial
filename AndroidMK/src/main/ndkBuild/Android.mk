#定义当前模块路径
LOCAL_PATH := $(call my-dir)

#清空环境变量
include $(CLEAR_VARS)

#当前模块名称
LOCAL_MODULE := hello-jni


# 当前模块包含的源代码路径
LOCAL_SRC_FILES := hello-jni.c


#生成一个动态库
include $(BUILD_SHARED_LIBRARY)