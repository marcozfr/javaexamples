## Keytool generation documentation
## https://docs.oracle.com/javase/6/docs/technotes/tools/windows/keytool.html

## OpenSSL Tutorial
## https://users.dcc.uchile.cl/~pcamacho/tutorial/crypto/openssl/openssl_intro.html

###########################################

## Creates Key-pair & marcofJKS keystore

keytool -genkeypair -keyalg "RSA" -keysize 1024 -keypass keypwd -validity 365 -keystore marcof.jks -storepass storepwd -dname "CN=Marco Flores, OU=MTech, O=M, L=Lima, S=Lima, C=PE" -alias "marcof-server-cert"

keytool -list -keystore marcof.jks -storepass storepwd

## Export JKS to PKCS#12 (Keystore + PEM certs)

## Warning:  Different store and key passwords not supported for PKCS12 KeyStores. 
## Change Pwds to match the same for Store & Key

keytool -importkeystore -srckeystore marcof.jks -destkeystore marcof.p12 -srcstoretype jks -deststoretype pkcs12 -srcstorepass storepwd -deststorepass storepwd -srcalias "marcof-server-cert" -srckeypass keypwd -destkeypass storepwd

## Use openssl to extract PEM Certs from P12 Keystore

openssl pkcs12 -in marcof.p12 -out marcof-server-cert.pem

## Show PEM Content

openssl x509 -text -in marcof-server-cert.pem

## extract pub key from PEM

openssl x509 -in marcof-server-cert.pem -pubkey -out pub-marcof-server-cert.pem



