package com.example.telephoneshop.service.impl;

import com.example.telephoneshop.entity.Image;
import com.example.telephoneshop.entity.Telephone;
import com.example.telephoneshop.mappers.ImageMapper;
import com.example.telephoneshop.repository.ImageRepository;
import com.example.telephoneshop.repository.TelephoneRepository;
import com.example.telephoneshop.service.TelephoneService;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.util.List;

@Service
@AllArgsConstructor
public class TelephoneServiceImpl implements TelephoneService {

    final TelephoneRepository telephoneRepository;
    final ImageMapper imageMapper;

    @SneakyThrows
    @Override
    @Transactional
    public Telephone CreateTelephone(Telephone telephone, MultipartFile file1,MultipartFile file2){
        Image image1;
        Image image2;

        if(file1.getSize() != 0){
            image1 = imageMapper.fileToImages(file1);
            image1.setPreviewImage(true);
            image1.setTelephone(telephone); // <-- ДОБАВИТЬ ЭТУ СТРОКУ
            telephone.getImages().add(image1);
        }
        if(file2.getSize() != 0){ // <-- Также исправлена ошибка копипаста
            image2 = imageMapper.fileToImages(file2);
            image2.setPreviewImage(false);
            image2.setTelephone(telephone); // <-- ДОБАВИТЬ ЭТУ СТРОКУ
            telephone.getImages().add(image2);
        }
        telephoneRepository.save(telephone);
        return telephone;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Telephone> GetAllTelephones() {
        return telephoneRepository.findAll();
    }

    public Telephone GetTelephoneById(long id) {
        return telephoneRepository.findById(id).get();
    }
}
