(Working) CUDA OpenCV make error
==

이틀 전, YOLO 학습을 하던 도중 심각하게 속도가 안나오는 것을 발견하였습니다.   
그 이유는 바로 CUDA가 동작하지 않았기 때문인데요.

문제는 CUDA가 제 역할을 하지 않고있습니다.   
현재 이틀째 여전히 삽질중입니다. 

그럼, 알아낸 문제점들을 한번 살펴보겠습니다.

## 1. CUDA와 NVIDIA DRIVER의 version이 호환이 되어야 한다.

무슨 소리이냐 하면, CUDA도 version이 존재하고 이를 호환하는 NVIDIA DRIVER의 version도 존재합니다. 

![image](https://media.discordapp.net/attachments/633251365434687491/677117853916332052/unknown.png)

다음과 같이 CUDA Toolkit과 상호 호환이 되는 Driver Version이 존재합니다. 

조금 더 자세한 정보는 [여기](https://docs.nvidia.com/deploy/cuda-compatibility/index.html)에서 참고하실 수 있습니다. 

## 2. CUDA version에 맞는 GCC버전이 필요하다. 

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

현재까지 알아낸 점은 이정도로 상당히 머리가 아픕니다.. 
계속해서 업데이트하여 문제가 해결될 때까지 힘쓰겠습니다.