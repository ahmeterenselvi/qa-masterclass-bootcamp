<<<<<<< HEAD
# qa-masterclass-bootcamp
=======
# QA Masterclass Bootcamp - Final Teslimatı

Bu proje, **QA Masterclass: Test Engineering Bootcamp** eğitimi kapsamında oluşturulmuş olup; manuel test, test otomasyonu ve API testlerinden oluşan üç ana bölüm içermektedir.

## 📁 Klasör Yapısı

qa-masterclass-bootcamp/
│
├── manual-test/
│ └── kitapYurdu_ManualTestCases.xlsx
│
├── automation-test/
│ ├── src/
│ ├── pom.xml
│ └── allure-results/
│
├── api-test/
│ ├── Petstore_AhmetEren.postman_collection.json
│ └── README.md
│
└── README.md

markdown
Kopyala
Düzenle

## 🔎 Bölümler

### 1. Manual Test

- Web uygulaması üzerinden belirlenen senaryolara göre **11 adet test case** yazılmıştır.
- Test senaryoları `Excel` formatındadır.
- Her bir test için: *Test Case ID, Test Adı, Açıklama, Durum, Öncelik, İlgili Modül, Notlar* belirtilmiştir.
- Login işlemleri, sepet fonksiyonları ve en çok satanlar sayfası gibi bölümler test edilmiştir.

### 2. Test Otomasyonu

- Kitapyurdu sitesine ait belirli fonksiyonlar **Selenium + Java** ile otomasyona geçirilmiştir.
- Framework Maven yapısında hazırlanmış, `TestNG` ile testler koordine edilmiştir.
- `XPath`, `PageObject`, `Random Data`, `Date Helper` gibi yapılar kullanılmıştır.
- Allure raporları `allure-results/` klasöründe bulunmaktadır.

### 3. API Testleri

- `Petstore Swagger` API'si üzerinden toplam **8 test** yapılmıştır:
  - 2 adet GET
  - 2 adet POST
  - 2 adet PUT
  - 2 adet DELETE
- Tüm testler `Postman` ile gerçekleştirilmiştir.
- Test açıklamaları ve örnek JSON payload'lar `api-test/README.md` dosyasında mevcuttur.

## ⚙️ Kullanılan Teknolojiler

| Alan               | Teknoloji              |
|--------------------|------------------------|
| Otomasyon          | Selenium, TestNG, Java |
| Raporlama          | Allure                 |
| Build Tool         | Maven                  |
| API Testi          | Postman                |
| Test Dokümantasyonu| Excel, Markdown        |
| Kaynak Kontrol     | Git, GitHub            |

## 👤 Geliştirici

**Ahmet Eren Selvi**  
LinkedIn: [linkedin.com/in/ahmeterenselvi](https://www.linkedin.com/in/ahmeterenselvi)  
GitHub: [github.com/ahmeterenselvi](https://github.com/ahmeterenselvi)
>>>>>>> master
