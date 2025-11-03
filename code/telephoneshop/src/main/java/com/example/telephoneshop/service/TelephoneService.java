package com.example.telephoneshop.service;

import com.example.telephoneshop.entity.Telephone;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface TelephoneService {

    public Telephone CreateTelephone(Telephone telephone, MultipartFile file1, MultipartFile file2);

    public List<Telephone> GetAllTelephones();

    public Telephone GetTelephoneById(long id);
}
