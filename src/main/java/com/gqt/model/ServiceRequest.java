package com.gqt.model;

public class ServiceRequest {
    private String username;
    private String carType;
    private String carModel;
    private String carRegNo;
    private String serviceType;
    private String serviceStatus;

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getCarType() { return carType; }
    public void setCarType(String carType) { this.carType = carType; }
    public String getCarModel() { return carModel; }
    public void setCarModel(String carModel) { this.carModel = carModel; }
    public String getCarRegNo() { return carRegNo; }
    public void setCarRegNo(String carRegNo) { this.carRegNo = carRegNo; }
    public String getServiceType() { return serviceType; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public String getServiceStatus() { return serviceStatus; }
    public void setServiceStatus(String serviceStatus) { this.serviceStatus = serviceStatus; }
}
