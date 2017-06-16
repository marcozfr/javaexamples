## Check https://users.dcc.uchile.cl/~pcamacho/tutorial/web/xmlsec/xmlsec.html
## To use XML Encryption & XML Dig Signature

## Check https://users.dcc.uchile.cl/~pcamacho/tutorial/crypto/openssl/openssl_intro.html
## For OpenSSL Tutorial

## Common usage of OpenSSL
## https://www.madboa.com/geek/openssl/


## Check differences between enveloping, enveloped and detached signatures
## https://msdn.microsoft.com/en-us/library/ms759193(v=vs.85).aspx


## Sign document using Reference="" (whole document) and enveloped-signature: 
## documents.xml

xmlsec --sign --output documents-signed.xml --privkey-pem key.pem documents.xml 

xmlsec --verify note-signed.xml

## If KeyInfo is not specified:

xmlsec --verify --pubkey pub-key.pem note-signed.xml

## Sign document and adding Object/SignatureProperties in an added reference: 
## note.xml

## Sign document using Manifest to reference multiple partial content
## note-manifest.xml

## Sign document and not specifying KeyInfo so specifying public key is mandatory when verifying content: 
## documents-nokeyinfo.xml

## Sign document partially by specifying URI reference by Id to a content within the xml. 
## Can be considered detached cause URI references valid Id content
## documents-partial.xml

## Sign document using X.509 Certificate with KeyInfo and Issuer detail: 
## documents-x509.xml

xmlsec --sign --output documents-x509-signed.xml --pkcs12 marcof.p12 --pwd storepwd --trusted-pem pub-key.pem documents-x509.xml

## Sign document using enveloping-signature with Object content
## payment-object-enveloping.xml

## Encrypt document using tripledes symmaetric alg & RSA asymmetric alg
## payment-encrypted.xml / encryption-template.xml
xmlsec encrypt --pubkey-pem pub-key.pem --session-key des-192 --xml-data payment.xml --output payment-encrypted.xml encryption-template.xml


   
   