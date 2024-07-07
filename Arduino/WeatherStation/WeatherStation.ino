//#include <BLEDevice.h>
//#include <BLE2902.h>
//#include <BLEServer.h>

#include "BluetoothManager.h"

/*class BluetoothManager : public BLEServerCallbacks {
  public:
    BluetoothManager();

    void start();
    void stop();

    void startAdvertising();

    void onConnect(BLEServer *pServer) override;
    void onDisconnect(BLEServer *pServer) override;

    void sendValue(String data);

    bool isConnected();
  
  private:
    BLEServer *server;
    BLEService *service;
    BLECharacteristic *txCharacteristic;
    bool connected;
    
};*/

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

/*void println(String message, String tag = "") {
  if (tag.isEmpty()) {
    Serial.println(message);
  } else {
    Serial.println(tag + " " + message);
  }

  //Serial.println(tag + tag.isEmpty() ? "" : " " + message);
}

// TODO export in its own file
/***** BLUETOOTH MANAGEMENT *****/
/*#define DEVICE_NAME "ESP32 BLE"

#define SERVICE_UUID           "6E400001-B5A3-F393-E0A9-E50E24DCCA9E"
#define CHARACTERISTIC_UUID_RX "6E400002-B5A3-F393-E0A9-E50E24DCCA9E"
#define CHARACTERISTIC_UUID_TX "6E400003-B5A3-F393-E0A9-E50E24DCCA9E"

BluetoothManager::BluetoothManager() {
  connected = false;
  BLEDevice::init(DEVICE_NAME);

  // Initiate the BLE server
  server = BLEDevice::createServer();
  server->setCallbacks(this);

  // Initiate the BLE service
  service = server->createService(SERVICE_UUID);

  // Initiate the send characteristic
  txCharacteristic = service->createCharacteristic(CHARACTERISTIC_UUID_TX, BLECharacteristic::PROPERTY_NOTIFY);
  BLE2902 *ble2902 = new BLE2902();
  ble2902->setNotifications(true);
  txCharacteristic->addDescriptor(ble2902);
}

void BluetoothManager::start() {
  println("Start service", "[BluetoothManager]");
  service->start();
}

void BluetoothManager::stop() {
  println("Stop service", "[BluetoothManager]");
  service->stop();
}

void BluetoothManager::startAdvertising() {
  println("Advertising", "[BluetoothManager]");
  server->startAdvertising();
}

void BluetoothManager::onConnect(BLEServer *pServer) {
  println("Device connected!", "[BluetoothManager]");
  connected = true;
}

void BluetoothManager::onDisconnect(BLEServer *pServer) {
  println("Device disconnected!", "[BluetoothManager]");
  connected = false;
}

void BluetoothManager::sendValue(String data) {
  println("Send value -> " + data, "[BluetoothManager]");
  txCharacteristic->setValue(data);
  txCharacteristic->notify();
}

bool BluetoothManager::isConnected() {
  return connected;
}*/