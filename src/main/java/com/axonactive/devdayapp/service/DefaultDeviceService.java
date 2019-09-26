package com.axonactive.devdayapp.service;

import com.axonactive.devdayapp.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultDeviceService implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepo;
}

