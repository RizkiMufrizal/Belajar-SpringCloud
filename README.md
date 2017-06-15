# Belajar-SpringCloud
Project ini dibuat dalam rangka belajar microservice

## Cara Konfigurasi Vault

* Download vault dari [vault](https://www.vaultproject.io/),lalu extract ke suatu folder, lalu buka file `.bash_profile` atau `.zshrc`, lalu masukkan source berikut `export PATH=$PATH:/Users/rizkimufrizal/vault/`, sesuaikan dengan path folder anda.
* lalu jalankan perintah `source .bash_profile` atau `source .zshrc` untuk update environment pada bash atau zsh
* jalankan vault dengan perintah `vault server -dev` (jika masih tahap development)
* buka kembali file `.bash_profile` atau `.zshrc` lalu masukkan source `export VAULT_ADDR='http://127.0.0.1:8200'`, untuk konfigurasi client vault
* lalu jalankan perintah `source .bash_profile` atau `source .zshrc` untuk update environment pada bash atau zsh
* lakukan pengecekan vault dengan perintah `vault status`, jika berhasil maka akan muncul output seperti berikut :

```bash
Sealed: false
Key Shares: 1
Key Threshold: 1
Unseal Progress: 0
Unseal Nonce:
Version: 0.7.3
Cluster Name: vault-cluster-667aefc6
Cluster ID: c40e9ab0-1701-afe3-525b-3f8d89ce76b0

High-Availability Enabled: false
```
