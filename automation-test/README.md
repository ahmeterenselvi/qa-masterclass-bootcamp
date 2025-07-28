# Automation Tests - KitapYurdu

Bu klasör, KitapYurdu web uygulamasına yönelik yazılmış otomasyon testlerini içermektedir.

## İçerik

- `src/` → Test kodları (Java + TestNG + Appium + Selenium)
- `pom.xml` → Proje bağımlılıkları ve yapılandırmalar
- `allure-results/` → Allure raporlama çıktıları

## Koşulan Senaryolar

- Başarılı / Hatalı login testleri
- Sepete kitap ekleme
- Sepetten silme ve boş mesajı kontrolü
- Arama sonuçlarında anahtar kelime kontrolü
- Haftalık / Aylık / Yıllık top seller kitap doğrulamaları
- Sepette ürün başlığı kontrolü

## Notlar

- Login testleri CAPTCHA nedeniyle geçememiştir.
- Raporlama Allure ile yapılmıştır.
