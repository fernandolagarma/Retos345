package com.example.retos345.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.retos345.entities.Admin;
import com.example.retos345.services.AdminService;

@Service
@RestController
@RequestMapping("api/Admin")
public class AdminController {    

    @Autowired
    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Admin>> getAdmins(){
        return new ResponseEntity<List<Admin>>(this.adminService.getListAdmins(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Admin> getAdmin(@PathVariable("id") int id){
        return new ResponseEntity<Admin>(this.adminService.getAdmin(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearAdmin(@RequestBody Admin admin){
        this.adminService.crearAdmin(admin);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAdmin(@PathVariable("id") int id){
        this.adminService.eliminarAdmin(id);
        return new ResponseEntity<Void>( HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> actualizarAdmin(@RequestBody Admin admin){
        this.adminService.actualizarAdmin(admin.getIdAdmin(), admin);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }
    

}
