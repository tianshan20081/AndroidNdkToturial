# 最小支持版本
cmake_minimum_required(VERSION 3.10.2)


include_directories(${CMAKE_SOURCE_DIR}/x264/include)


project("tutuorial")
# 添加一个库，根据 native-lib.cpp 文件编译一个 native-lib 的动态链接库
add_library(
        native-lib
        SHARED
        native-lib.cpp)

# 同时有 SO 和 .a 文件的时候会优先加载 SO 文件
set(DEPS_A true)
#set(DEPS_A false)
if (${DEPS_A})
    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/../../../jniALibs/${CMAKE_ANDROID_ARCH_ABI}")
    # 设置依赖的库（第一个参数为目标文件，顺序不能变）
    target_link_libraries(native-lib x264 log)
ELSE ()
    # 1. 加载 SO 不需要依赖
    # 2. 需要将 X264.so 拷贝到 jniLibs/${CMAKE_ANDROID_ARCH_ABI}/
    # 2. 需要执行 System.loadLibray("x264")
    #    set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -L${CMAKE_SOURCE_DIR}/x264/jniLibs/${CMAKE_ANDROID_ARCH_ABI}")

    # 设置依赖的库（第一个参数为目标文件，顺序不能变）
    target_link_libraries(native-lib log)
ENDIF ()