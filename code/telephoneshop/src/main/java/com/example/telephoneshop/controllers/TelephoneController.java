package com.example.telephoneshop.controllers;


import com.example.telephoneshop.entity.Telephone;
import com.example.telephoneshop.repository.TelephoneRepository;
import com.example.telephoneshop.service.TelephoneService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("telshop/")
public class TelephoneController {


    public TelephoneService telephoneService;


    @GetMapping("all")
    public List<Telephone> GetAllTelephones(){
        return telephoneService.GetAllTelephones();
    }

    @PostMapping(value = "create", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Telephone CreateTelephone(@RequestPart("file1") MultipartFile file1,
                                     @RequestPart("file2") MultipartFile file2,@RequestPart("telephone") Telephone telephone){
       return telephoneService.CreateTelephone(telephone,file1,file2);
    }



}
