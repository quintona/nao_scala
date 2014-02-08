
:power
vals.isettings.maxPrintString = 100

import io.github.quintona.nao._

val speech = ProxyFactory.speechProxy
val sonar = ProxyFactory.sonarProxy
val memory = ProxyFactory.memory


sonar.subscribe("scala")
memory.getData("Device/SubDeviceList/US/Left/Sensor/Value")
