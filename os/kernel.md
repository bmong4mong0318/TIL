# 커널이란?

## 커널의 기능

1. 메모리 관리: 메모리가 어디에서 무엇을 저장하는 데 얼마나 사용되는지를 추적합니다.
2. 프로세스 관리: 어느 프로세스가 중앙 처리 장치(CPU)를 언제 얼마나 오랫동안 사용할지를 결정합니다.
3. 장치 드라이버: 하드웨어와 프로세스 사이에서 중재자/인터프리터의 역할을 수행합니다.
4. 시스템 호출 및 보안: 프로세스의 서비스 요청을 수신합니다.

올바르게 구현된 커널은 사용자가 볼 수 없으며 커널 공간이라는 자신만의 작은 작업 공간에서 메모리를 할당하고 저장되는 모든 항목을 추적합니다.

웹 브라우저 및 [파일](https://www.redhat.com/ko/topics/data-storage/file-block-object-storage)과 같이 사용자가 볼 수 있는 것을 사용자 공간이라고 합니다. 이러한 애플리케이션은 시스템 호출 인터페이스(SCI)를 통해 커널과 통신합니다.

*설명하자면 다음과 같습니다.* 커널은 강력한 경영진(하드웨어)을 위해 일하는 바쁜 비서입니다. 비서의 할 일은 직원 및 대중(사용자)으로부터 수신되는 메시지 및 요청(프로세스)을 경영진에게 전달하고, 어디에 무엇이 저장되어 있는지 기억(메모리)하고, 특정한 시간에 누가 경영진을 얼마 동안 만날 수 있는지 결정하는 것입니다.

## OS 내에서 커널의 위치

1. 하드웨어: 시스템의 토대가 되는 물리적 머신으로, 메모리(RAM)와 프로세서 또는 중앙 처리 장치(CPU) 그리고 입출력(I/O) 장치(예: [스토리지](https://www.redhat.com/ko/topics/data-storage), [네트워킹](https://www.redhat.com/ko/topics/hyperconverged-infrastructure/what-is-software-defined-networking) 및 그래픽)로 구성됩니다. CPU는 계산을 수행하고 메모리를 읽고 씁니다.


2. Linux 커널: OS의 핵심입니다. (보시다시피 한가운데에 있습니다.) 메모리에 상주하며 CPU에 명령을 내리는 소프트웨어입니다.


3. 사용자 프로세스: 실행 중인 프로그램으로, 커널이 [관리](https://www.redhat.com/ko/topics/management)합니다. 사용자 프로세스가 모여 사용자 공간을 구성합니다. 사용자 프로세스를 단순히 *프로세스*라고도 합니다. 또한, 커널은 이러한 프로세스 및 서버가 서로 통신(프로세스 간 통신 또는 IPC라고 함)할 수 있도록 해줍니다.

시스템에서 실행되는 코드는 커널 모드 또는 사용자 모드라는 두 가지 모드 중 하나로 CPU에서 실행됩니다. 커널 모드에서 실행 중인 코드는 하드웨어에 무제한 액세스가 가능한 반면, 사용자 모드에서는 CPU 및 메모리가 SCI를 통해 액세스하는 것을 제한합니다. 메모리도 이와 유사하게 구분됩니다(커널 공간 및 사용자 공간). 이러한 두 가지 작은 세부 사항이 [보안](https://www.redhat.com/ko/topics/security), [컨테이너 구축](https://www.redhat.com/ko/topics/containers) 및 [가상 머신](https://www.redhat.com/ko/topics/virtualization/what-is-a-virtual-machine)을 위한 권한 구분과 같은 복잡한 작업의 토대가 됩니다.

또한, 이는 프로세스가 사용자 모드에서 실패할 경우 손상이 제한적이며 커널에 의해 복구될 수 있음을 의미합니다. 그러나 커널 프로세스는 메모리와 프로세서에 액세스할 수 있기 때문에 충돌이 발생하면 시스템 전체가 중지될 수 있습니다. 안전 장치가 마련되어 있고 경계를 넘기 위해서는 권한이 필요하기 때문에, 사용자 프로세스 충돌은 일반적으로 커다란 문제를 유발하지는 않습니다.

