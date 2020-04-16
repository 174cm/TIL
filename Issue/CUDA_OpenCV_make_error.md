(Solved) CUDA OpenCV make error
==

2020년 2월 11일, YOLO 학습을 하던 도중 심각하게 속도가 안나오는 것을 발견하였습니다.   

그 이유는 바로 CUDA가 동작하지 않았기 때문인데요.

문제는 CUDA가 제 역할을 하지 않고있습니다.   

현재 이틀째 여전히 삽질중입니다. 

그럼, 알아낸 문제점들을 한번 살펴보겠습니다.

## 1. (Solved) CUDA와 NVIDIA DRIVER의 version이 호환이 되어야 한다.

무슨 소리이냐 하면, CUDA도 version이 존재하고 이를 호환하는 NVIDIA DRIVER의 version도 존재합니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/677117853916332052/unknown.png)

다음과 같이 CUDA Toolkit과 상호 호환이 되는 Driver Version이 존재합니다. 

조금 더 자세한 정보는 [여기](https://docs.nvidia.com/deploy/cuda-compatibility/index.html)에서 참고하실 수 있습니다. 

## 2. (Solved) CUDA version에 맞는 GCC버전이 필요하다. 

CUDA 9에는 __gcc6 version__ 이 필요하며,   
CUDA 8에는 __gcc5 version__ 이 필요합니다. 

하지만 문제가 발생하였는데, gcc6버전을 설치하여도 인식을 할 수 없었습니다. 
그래서 cmake를 다시 진행하려 합니다. 

## 3. (Solved) Opencv make error

``` java
...
Scanning dependencies of target pch_Generate_opencv_stitching
[ 24%] Generating precomp.hpp
[ 24%] Generating precomp.hpp.gch/opencv_stitching_RELEASE.gch
[ 24%] Built target pch_Generate_opencv_bgsegm
[ 24%] Processing OpenCL kernels (core)
[ 24%] Building NVCC (Device) object modules/core/CMakeFiles/cuda_compile.dir/src/cuda/cuda_compile_generated_gpu_mat.cu.o
In file included from /usr/local/cuda-9.0/include/host_config.h:50:0,
                 from /usr/local/cuda-9.0/include/cuda_runtime.h:78,
                 from <command-line>:0:
/usr/local/cuda-9.0/include/crt/host_config.h:119:2: error: #error -- unsupported GNU version! gcc versions later than 6 are not supported!
 #error -- unsupported GNU version! gcc versions later than 6 are not supported!
  ^~~~~
CMake Error at cuda_compile_generated_gpu_mat.cu.o.cmake:208 (message):
  Error generating
  /home/eungbean/opencv/opencv-3.4.0/build/modules/core/CMakeFiles/cuda_compile.dir/src/cuda/./cuda_compile_generated_gpu_mat.cu.o


modules/core/CMakeFiles/opencv_core.dir/build.make:63: recipe for target 'modules/core/CMakeFiles/cuda_compile.dir/src/cuda/cuda_compile_generated_gpu_mat.cu.o' failed
make[2]: *** [modules/core/CMakeFiles/cuda_compile.dir/src/cuda/cuda_compile_generated_gpu_mat.cu.o] Error 1
CMakeFiles/Makefile2:2299: recipe for target 'modules/core/CMakeFiles/opencv_core.dir/all' failed
make[1]: *** [modules/core/CMakeFiles/opencv_core.dir/all] Error 2
make[1]: *** Waiting for unfinished jobs....
In file included from /home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy.hpp:50:0,
                 from /home/eungbean/opencv/opencv-3.4.0/build/modules/stitching/precomp.hpp:87:
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp: In member function ‘NCVStatus HaarFeature64::setRect(Ncv32u, Ncv32u, Ncv32u, Ncv32u, Ncv32u, Ncv32u)’:
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:87:38: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
         ((NcvRect8u*)&(this->_ui2.x))->x = (Ncv8u)rectX;
                                      ^~
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:88:38: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
         ((NcvRect8u*)&(this->_ui2.x))->y = (Ncv8u)rectY;
                                      ^~
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:89:38: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
         ((NcvRect8u*)&(this->_ui2.x))->width = (Ncv8u)rectWidth;
                                      ^~
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:90:38: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
         ((NcvRect8u*)&(this->_ui2.x))->height = (Ncv8u)rectHeight;
                                      ^~
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp: In member function ‘void HaarFeature64::getRect(Ncv32u*, Ncv32u*, Ncv32u*, Ncv32u*)’:
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:102:56: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
         NcvRect8u tmpRect = *(NcvRect8u*)(&this->_ui2.x);
                                                        ^
/home/eungbean/opencv/opencv-3.4.0/modules/cudalegacy/include/opencv2/cudalegacy/NCVHaarObjectDetection.hpp:102:56: warning: dereferencing type-punned pointer will break strict-aliasing rules [-Wstrict-aliasing]
[ 24%] Built target pch_Generate_opencv_face
[ 24%] Built target pch_Generate_opencv_optflow
[ 24%] Built target pch_Generate_opencv_stitching
Makefile:162: recipe for target 'all' failed
make: *** [all] Error 2
```

다음과 같이 `make -j4`를 하여 opencv를 make할 때 생기는 에러로 이 문제는 __protobuf__ 를 통해 해결이 되었습니다. 

[여기](https://eungbean.github.io/2018/10/22/eod-opencv-protobuf/)에서 참고하시어 해결하시면 됩니다.

## 4. (Solved) CMAKE_BUILD Error

- CMAKE
```java
cmake -DCMAKE_BUILD_TYPE=Release \
-D CMAKE_INSTALL_PREFIX=/user/local \
-D OPENCV_EXTRA_MODULES_PATH=../../opencv_contrib-4.0.1/modules/ \
-D OPENCV_GENERATE_PKGCONFIG=ON \
# GUI and NVIDIA CUDA cache
-D WITH_OPENGL=ON \
-D WITH_CUDA=ON \
-D WITH_CUFFT=ON \
-D WITH_CUBLAS=ON \
-D BUILD_opencv_cudacodec=OFF \
# Hardware acceleration and data transfer cache
-D WITH_TBB=ON \
# Install verification cache
-D BUILD_JAVA=OFF \
-D BUILD_EXAMPLES=OFF \
-D INSTALL_C_EXAMPLEs=ON \
-D INSTALL_PYTHON_EXAMPLES=ON \
# OpenCV-Python cache
-D PYTHON_DEFAULT_EXECUTABLE=usr/bin/python3 \
..
```
이전에 위와 같이 BUILD를 진행하였고 오류코드는 다음과 같습니다. 

- ERROR CODE
```java
[ 23%] Generate files for Python bindings and documentation
/bin/sh: 1: usr/bin/python3: not found
modules/python_bindings_generator/CMakeFiles/gen_opencv_python_source.dir/build.make:324: recipe for target 'modules/python_bindings_generator/pyopencv_generated_include.h' failed
make[2]: *** [modules/python_bindings_generator/pyopencv_generated_include.h] Error 127
CMakeFiles/Makefile2:15917: recipe for target 'modules/python_bindings_generator/CMakeFiles/gen_opencv_python_source.dir/all' failed
make[1]: *** [modules/python_bindings_generator/CMakeFiles/gen_opencv_python_source.dir/all] Error 2
make[1]: *** Waiting for unfinished jobs....
[ 23%] Linking CXX static library ../../lib/libopencv_test_stitching_pch_dephelp.a
[ 23%] Built target opencv_test_stitching_pch_dephelp
[ 23%] Linking CXX static library ../../lib/libopencv_perf_stitching_pch_dephelp.a
[ 23%] Built target opencv_perf_stitching_pch_dephelp
[ 23%] Linking CXX static library ../../lib/libopencv_test_superres_pch_dephelp.a
[ 23%] Built target opencv_test_superres_pch_dephelp
[ 23%] Linking CXX static library ../../lib/libopencv_tracking_pch_dephelp.a
[ 23%] Built target opencv_tracking_pch_dephelp
[ 23%] Linking CXX static library ../../lib/libopencv_test_tracking_pch_dephelp.a
[ 23%] Built target opencv_test_tracking_pch_dephelp
[ 23%] Linking CXX static library ../../lib/libopencv_perf_tracking_pch_dephelp.a
[ 23%] Built target opencv_perf_tracking_pch_dephelp
Makefile:162: recipe for target 'all' failed
make: *** [all] Error 2
```

우선 여기서 실수를 한 부분은 두 가지 입니다. 
1. 오류코드 두번째 줄인 `/bin/sh: 1: usr/bin/python3: not found` 를 참고했어야 했습니다. 
2. 빌드 코드 두번째 줄인 `-D CMAKE_INSTALL_PREFIX=/user/local \`의 `/user/local`의 오타가 발견되었습니다. 

### - How to fix? 
1. cmake build의 __PYTHON DEFAULT EXECUTABLE__ 설정에 보면 `usr/bin/python` 인데 앞에 `/` 를 하나 빼먹어 python경로를 찾지 못한 이유에서 오류가 발생했습니다. 수정하자면 다음과 같이 `/usr/bin/python`으로 수정하여야 합니다.  

2. cmake build의 `-D CMAKE_INSTALL_PREFIX=/user/local \` 부분의 `/user/local`부분을 `usr/local`로 수정하여야 합니다. 

수정된 cmake build는 다음과 같습니다.

```java
cmake -DCMAKE_BUILD_TYPE=Release \
-D CMAKE_INSTALL_PREFIX=/usr/local \
-D OPENCV_EXTRA_MODULES_PATH=../../opencv_contrib-4.0.1/modules/ \
-D OPENCV_GENERATE_PKGCONFIG=ON \
-D WITH_OPENGL=ON \
-D WITH_CUDA=ON \
-D WITH_CUFFT=ON \
-D WITH_CUBLAS=ON \
-D BUILD_opencv_cudacodec=OFF \
-D WITH_TBB=ON \
-D BUILD_JAVA=OFF \
-D BUILD_EXAMPLES=OFF \
-D INSTALL_C_EXAMPLEs=ON \
-D INSTALL_PYTHON_EXAMPLES=ON \
-D WITH_GSTREAMER=False \
-D WITH_LAPACK=False \
-D WITH_VTK=False \
-D PYTHON_DEFAULT_EXECUTABLE=/usr/bin/python3 \
..
```

이로서 2월 11일에 시작한 문제를 2월 13일에 마무리 하였습니다. (해당 문제를 해결하고 업로드 하는 것을 깜빡하여 4월에 다시 수정하였습니다.)

## 5. TIP

저는 OpenCV를 직접 설치하였지만, OpenCV자체가 의존 패키지가 많아 미리 잘 설치를 하여야 합니다. 이러한 수고를 덜기위하여 많은 사람들이 [Anaconda](https://www.anaconda.com/distribution/)의 사용을 권장한다고 합니다. 드라이버까지만 설치하면 나머지는 가상환경 설정할 때 필요한 것(cuDNN을 포함하여)을 맞는 버전으로 자동으로 설치해준다고 하니 꼭 `Anaconda`를 사용하시길 권장합니다. 

- Anaconda 설치 시, 필요한 설정 참고: https://javaxer.blogspot.com/2019/01/tensorflow-gpu.html?fbclid=IwAR3-z0D26bC89pyFiec36N9p9YbSjZKxVhXcneQO3vQkkafruzP7hq_DDrs

