package com.jxy.studycloud.services;//package com.jxy.studycloud.services;
//
//import com.jxy.studycloud.config.ServiceConfig;
//import java.util.List;
//import java.util.UUID;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import com.jxy.studycloud.model.License;
//import com.jxy.studycloud.repository.LicenseRepository;
//@Service
//public class LicenseService {
//
//    @Autowired
//    private LicenseRepository licenseRepository;
//
//    @Autowired
//    ServiceConfig config;
//
//    public License getLicense(String organizationId,String licenseId) {
//        License license = licenseRepository.findByOrganizationidAndLicenseid(organizationId, licenseId);
//        return license.withComment(config.getExampleProperty());
//    }
//
//    public List<License> getLicensesByOrg(String organizationId){
//        return licenseRepository.findByOrganizationid( organizationId );
//    }
//
//    public void saveLicense(License license){
//        license.withId( UUID.randomUUID().toString());
//
//        licenseRepository.save(license);
//
//    }
//
//    public void updateLicense(License license){
//      licenseRepository.save(license);
//    }
//
//    public void deleteLicense(License license){
//        licenseRepository.delete( license.getId());
//    }
//
//}
