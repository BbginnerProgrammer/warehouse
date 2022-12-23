package com.example.warehouse.service.ServiceImpl;

import com.example.warehouse.entity.Providers;
import com.example.warehouse.repository.ProvidersRepository;
import com.example.warehouse.service.ProvidersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvidersServiceImpl implements ProvidersService {


    @Autowired
    private ProvidersRepository providersRepository;

    @Override
    public void addProvider(Providers provider) {
        if(!providersRepository.existsByNameEqualsIgnoreCase(provider.getName())){
            providersRepository.save(provider);
        }

    }
}
