package com.jxy.studycloud.repository;
import com.jxy.studycloud.model.License;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends CrudRepository<License,Long> {
//    public List<License> findByOrganizationId(String organizationId);
//    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
