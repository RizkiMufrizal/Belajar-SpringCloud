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

* silahkan jalankan perintah `vault token-create` untuk membuat token key, berikut adalah hasilnya

```bash
Key            	Value
---            	-----
token          	af4e4a5d-0186-8a84-6f5b-53acf0934152
token_accessor 	f082842d-5c5a-51d3-4f4b-ef9bc41fcb0f
token_duration 	0s
token_renewable	false
token_policies 	[root]
```

token yang digunakan adalah `af4e4a5d-0186-8a84-6f5b-53acf0934152`

## Export Json ke Vault

Silahkan akses folder `config` dengan terminal, disana terdapat file [vault.json](https://github.com/RizkiMufrizal/Belajar-SpringCloud/blob/master/config/vault.json). Lalu jalankan perintah 

```bash
vault write secret/bookcatalog @vault.json
```

maka secara otomatis vault akan melakukan import property yang ada didalam json ke database vault pada path `secret/bookcatalog`. `bookcatalog` berasal dari property `spring.application.name`, sesuaikan dengan nama aplikasi anda.
