cmake_minimum_required(VERSION 3.19.5)

project(CMakeTest)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -Wall")
set(EXECUTABLE_OUTPUT_PATH ${CMAKE_BINARY_DIR}/bin)
set(LIBRARY_OUTPUT_PATH ${CMAKE_BINARY_DIR}/lib)

message(${CMAKE_BINARY_DIR})

add_library(sample SHARED libsrc/add.c libsrc/sub.c)
add_executable(sample_app appsrc/sample_app.c appsrc/sample_app.h) 
target_link_libraries(sample_app sample)