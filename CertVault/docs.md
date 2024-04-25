List certs
    Method : GET 
    Endpoint : /api/employee/certs 
    Query params : ?sort=desc
    Payload : 
    Response Json : [{"CertId": "CertId", "CertName": "CertName", "Issuer": "IssuingOrganization", "IssuedDate": "IssuedDate", "ExpiredDate": "ExpirationDate", "CredentialId": "CredentialId", "CredentialUrl": "CredentialUrl"}]  
    Response Code : 200(OK), 404(Employee Not Found)

Add cert
    Method : POST
    Endpoint : /api/employee/addCert
    Query params : 
    Payload : [{"CertId": "CertId", "CertName": "CertName", "Issuer": "IssuingOrganization", "IssuedDate": "IssuedDate", "ExpiredDate": "ExpirationDate", "CredentialId": "CredentialId", "CredentialUrl": "CredentialUrl"}]  
    Response Json : [{"CertId": "CertId", "Status": "InsertStatus"}]
    Response Code : 200(OK), 404(Unable To Insert)