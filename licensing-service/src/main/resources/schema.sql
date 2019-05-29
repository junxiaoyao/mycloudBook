DROP TABLE IF EXISTS licensx;

CREATE TABLE licensx (
  id integer PRIMARY KEY,
  license_id        VARCHAR(100)  NOT NULL,
  organization_id   TEXT NOT NULL,
  license_type      TEXT NOT NULL,
  product_name      TEXT NOT NULL,
  license_max       INT   NOT NULL,
  license_allocated INT,
  comment           VARCHAR(100));


INSERT INTO licensx (id,license_id,  organization_id, license_type, product_name, license_max, license_allocated)
VALUES (1,'f3831f8c-c338-4ebe-a82a-e2fc1d1ff78a', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user','customer-crm-co', 100,5);
INSERT INTO licensx (id,license_id,  organization_id, license_type, product_name, license_max, license_allocated)
VALUES (2,'t9876f8c-c338-4abc-zf6a-ttt1', 'e254f8c-c442-4ebe-a82a-e2fc1d1ff78a', 'user','suitability-plus', 200,189);
INSERT INTO licensx (id,license_id,  organization_id, license_type, product_name, license_max, license_allocated)
VALUES (3,'38777179-7094-4200-9d61-edb101c6ea84', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'user','HR-PowerSuite', 100,4);
INSERT INTO licensx (id,license_id,  organization_id, license_type, product_name, license_max, license_allocated)
VALUES (4,'08dbe05-606e-4dad-9d33-90ef10e334f9', '442adb6e-fa58-47f3-9ca2-ed1fecdfe86c', 'core-prod','WildCat Application Gateway', 16,16);