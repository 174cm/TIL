(Solved) YOLOv3 Make error
==

오늘은 이전에 opencv 4.0.1을 설치하고 난 뒤, yolov3를 설치하던 중에 일어난 이슈를 정리해보려 합니다. 

- error 1   
: Yolo를 설치하고 난 뒤 GPU=1, OPENCV=1로 설정하고 make를 진행했지만 실패하였다.

- error code 1  
: `fatal error: opencv2/opencv.hpp` 

- how to solve error 1?  
: `sudo apt install libopencv-dev`를 통해 해결하였으나, 또 다른 문제가 발생하였습니다. 

- error code 2  
: `obj/convolutional_kernels.o' failed`

- how to solve error 2?  
: export PATH=/usr/local/cuda-10.2/bin${PATH:+:${PATH}} 
export LD_LIBRARY_PATH=/usr/local/cuda10.2/lib64${LD_LIBRARY_PATH:+:${LD_LIBRARY_PATH}} 

저는 cuda를 10.2 version을 설치하였기에 10.2로 설정해주었으며, `nvcc -V`를 통해 본인에 맞는 cuda version으로 맞추시면 될 것입니다. 

이후에 다시 make를 진행하시면 무리없이 잘 진행되는 것을 확인할 수 있습니다! 

Reference
--

- error 1 (https://github.com/pjreddie/darknet/issues/1886) 
- error 2 (https://github.com/pjreddie/darknet/issues/230) 