#include "BLECharacteristic.h"
#include "BluetoothManager.h"
#include <Arduino.h>

#define DEVICE_NAME "ESP32 BLE"

#define SERVICE_UUID           "6E400001-B5A3-F393-E0A9-E50E24DCCA9E"
#define CHARACTERISTIC_UUID_RX "6E400002-B5A3-F393-E0A9-E50E24DCCA9E"
#define CHARACTERISTIC_UUID_TX "6E400003-B5A3-F393-E0A9-E50E24DCCA9E"

void println(String message, String tag = "") {
  if (tag.isEmpty()) {
    Serial.println(message);
  } else {
    Serial.println(tag + " " + message);
  }
}

BluetoothManager::BluetoothManager() {
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

  // Initiate the receiver characteristic
  BLECharacteristic *rxCharacteristic = service->createCharacteristic(CHARACTERISTIC_UUID_RX, BLECharacteristic::PROPERTY_WRITE);
  rxCharacteristic->setCallbacks(this);
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
}

void BluetoothManager::onWrite(BLECharacteristic *pCharacteristic) {
  println("onWrite -> " + pCharacteristic->getValue(), "[BluetoothManager]");
}