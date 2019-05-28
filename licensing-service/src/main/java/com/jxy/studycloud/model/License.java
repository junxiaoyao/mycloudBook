//package com.jxy.studycloud.model;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import lombok.Data;
//
//@Entity
//@Table(name = "licenses")
//@Data
//public class License  {
//  private static final long serialVersionUID = 1L;
//  @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  private Long id;
//  @Column(name = "licenseid", nullable = false)
//  private String licenseid;
//
//  @Column(name = "organizationid", nullable = false)
//  private String organizationid;
//
//  @Column(name = "productname", nullable = false)
//  private String productname;
//
//  @Column(name = "licensetype", nullable = false)
//  private String licensetype;
//
//  @Column(name = "licensemax", nullable = false)
//  private Integer licensemax;
//
//  @Column(name = "licenseallocated", nullable = false)
//  private Integer licenseallocated;
//
//  @Column(name="comment")
//  private String comment;
//
//
//  public License withId(String id){
//    this.setLicenseid(id);
//    return this;
//  }
//
//  public License withOrganizationId(String organizationId){
//    this.setOrganizationid(organizationId);
//    return this;
//  }
//
//  public License withProductName(String productName){
//    this.setProductname(productName);
//    return this;
//  }
//
//  public License withLicenseType(String licenseType){
//    this.setLicensetype(licenseType);
//    return this;
//  }
//
//  public License withLicenseMax(Integer licenseMax){
//    this.setLicensemax(licenseMax);
//    return this;
//  }
//
//  public License withLicenseAllocated(Integer licenseAllocated){
//    this.setLicenseallocated(licenseAllocated);
//    return this;
//  }
//
//  public License withComment(String comment){
//    this.setComment(comment);
//    return this;
//  }
//
//
//
//}
