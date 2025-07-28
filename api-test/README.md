# API Testleri - Petstore Swagger

## 🔧 Kullanılan Araç
- **Postman** (v10+)
- Koleksiyon: `Petstore_AhmetEren.postman_collection.json`
- Environment: (Kullanılmadı)

## 📌 Test Edilen Endpointler

### 1. GET: Find Pets by Status
- **Endpoint:** `GET /pet/findByStatus?status=available`
- **Açıklama:** Sistemdeki `available` durumundaki evcil hayvanları listeler.
- **Beklenen Sonuç:** Status Code `200`, response body `JSON` ve pet listesi.

### 2. GET: Find Pets by Status (Hatalı Değer)
- **Endpoint:** `GET /pet/findByStatus?status=unknown`
- **Açıklama:** Mevcut olmayan bir status değeriyle yapılan istekte sistem davranışı kontrol edilir.
- **Beklenen Sonuç:** Status Code `404` veya boş liste.

### 3. POST: Add a New Pet
- **Endpoint:** `POST /pet`
- **Body:** JSON formatında yeni bir pet nesnesi gönderilir.
```json
{
  "id": 77,
  "name": "TestDog",
  "status": "available"
}
Beklenen Sonuç: Status Code 200, dönen body id: 77 içermeli.

4. PUT: Update Pet Info
Endpoint: PUT /pet

Body: Aşağıdaki gibi güncellenmiş bir pet nesnesi gönderilir:

json
Kopyala
Düzenle
{
  "id": 77,
  "name": "UpdatedDog",
  "status": "sold"
}
Beklenen Sonuç: Status Code 200, name "UpdatedDog" olmalı.

5. DELETE: Delete Pet by ID
Endpoint: DELETE /pet/77

Açıklama: id=77 olan pet silinir.

Beklenen Sonuç: Status Code 200, başarılı silinme mesajı.

✅ Test Durumları
Tüm testler başarılı şekilde çalıştırıldı.

Yanlış parametreli GET testi 404 sonucu verdi (beklendiği gibi).