#ifndef BLUETOOTH_MANAGER
#define BLUETOOTH_MANAGER

#include <BLEDevice.h>
#include <BLE2902.h>

class BluetoothManager : public BLEServerCallbacks {
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
    bool connected = false;
};

#endif