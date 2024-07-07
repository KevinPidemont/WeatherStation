#include "BluetoothManager.h"

BluetoothManager *bluetoothManager = NULL;

void setup() {
    Serial.begin(115200);
    bluetoothManager = new BluetoothManager();
    bluetoothManager->start();
}

void loop() {
  if (bluetoothManager->isConnected()) {
    bluetoothManager->sendValue("Sample data test");
    delay(500);
  } else {
    bluetoothManager->startAdvertising();
    delay(500);
  }
}
