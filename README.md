# FedorErmolinMobile

1 Local tests

Open and launch Android Studio

Create and launch a virtual device Pixel 3a API 29 - emulator-5554 - (get name via $adb devices)

Start appium server

To run native test via maven console:mvn clean test -Pnative

To run web test via maven console:mvn clean test

2 Remote tests

to run Android web test: mvn clean test -PcloudWeb

to run Android native test: mvn clean test -PcloudNative

to run iOS web test: mvn clean test -PiosCloudWeb

to run iOS native test: mvn clean test -PiosCloudNative
