# 最小支持版本
cmake_minimum_required(VERSION 3.10.2)


include_directories(${CMAKE_SOURCE_DIR}/inc)

project("tutuorial")
# 添加一个库，根据 native-lib.cpp 文件编译一个 native-lib 的动态链接库
add_library(
        native-lib
        SHARED
        native-lib.cpp)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/../jniLibs/${CMAKE_ANDROID_ARCH_ABI}")
# 查找系统库文件 ,这里查找的是系统日志库，并赋值给变量 log-lib
#/Users/sc/Dev/android-sdk-macosx/ndk/21.4.7075529/platforms/android-30/arch-x86_64/usr/lib64/liblog.so
#find_library(
#        log-lib
#        log)

# 设置依赖的库（第一个参数为目标文件，顺序不能变）
target_link_libraries(
        native-lib

        fmod
        fmodL
        log)