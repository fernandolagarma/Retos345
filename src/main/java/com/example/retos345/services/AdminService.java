package com.example.retos345.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.retos345.entities.Admin;
import com.example.retos345.repositories.AdminRepository;


@Service
public class AdminService {
    
        @Autowired
        private AdminRepository adminRepository;

        public AdminService(AdminRepository adminRepository) {
            this.adminRepository = adminRepository;
        }

        // METODOS CRUD
        public List<Admin> getListAdmins(){
            return this.adminRepository.findAll();
        }

        public Admin getAdmin(int id){
            if(!this.adminRepository.findById(id).isEmpty()){
                return this.adminRepository.findById(id).get();
            }else{
                return null;
            }
        }

        public Admin crearAdmin(Admin admin){
            return this.adminRepository.save(admin);
        }

        public void eliminarAdmin(int id){
            if(!this.adminRepository.findById(id).isEmpty()){
                this.adminRepository.deleteById(id);
            }
        }

        public void actualizarAdmin(int id, Admin admin){
            if(!this.adminRepository.findById(id).isEmpty()){
                Admin adminDB = this.adminRepository.findById(id).get();
                
                if(admin.getName() != null){
                    adminDB.setName(admin.getName());
                }
                if(admin.getEmail() != null){
                    adminDB.setEmail(admin.getEmail());
                }
                if(admin.getPassword() != null){
                    adminDB.setPassword(admin.getPassword());
                }
                this.adminRepository.save(adminDB);
            }
        }
}
