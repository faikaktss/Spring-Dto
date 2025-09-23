# 🎓 Spring Student Advanced API

Bu proje, Spring Boot ve Spring Data JPA kullanılarak geliştirilmiş, öğrenci (student) verilerini profesyonel bir yaklaşımla yöneten, modern ve katmanlı bir RESTful API'dir. Gelişmiş hata yönetimi, DTO kullanımı, validation ve temiz mimari prensipleriyle kurumsal seviyede bir örnek sunar.

---

## 🚀 Özellikler

- 📝 Öğrenci ekleme, listeleme, güncelleme ve silme (CRUD)
- 📦 DTO (Data Transfer Object) ile güvenli ve sade veri transferi
- 💾 Spring Data JPA ile veritabanı işlemleri (Repository, Entity)
- ✅ Alan validasyonu ve kullanıcı dostu hata yönetimi
- 🧩 Katmanlı, sürdürülebilir ve profesyonel mimari
- 🛡️ Global Exception Handler ile merkezi hata yönetimi
- 🪄 Bean ve dependency injection (IoC)

---

## 🏗️ Proje Mimarisi

```
src/main/java/com/faik/
├── Controller/
│   ├── Impl/
│   │   └── StudentControllerImpl.java   # API endpoint implementasyonu
│   └── IStudentController.java          # API uç noktaları arayüzü
│
├── dto/
│   ├── DtoStudent.java                  # Cevap DTO'su (dış veri)
│   └── DtoStudentIU.java                # Input/Update DTO (giriş/güncelleme)
│
├── Entites/
│   └── Student.java                     # JPA Entity (veritabanı modeli)
│
├── exception/
│   ├── ApiError.java                    # Hata detaylarını saran model
│   └── GlobalExceptionHandler.java      # Global hata yakalayıcı
│
├── Repository/
│   └── StudentRepository.java           # JPA interface
│
├── Services/
│   ├── Impl/
│   │   └── StudentServiceImpl.java      # Servis katmanı implementasyonu
│   └── IStudentService.java             # Servis arayüzü
│
└── Starter/
    └── Application.java                 # Spring Boot uygulama başlatıcı
```

---

## 🧑‍💻 Katmanların Görevleri

- **Controller:**  
  API endpointlerini tanımlar, gelen istekleri karşılar ve validasyon ile DTO dönüşü sağlar.

- **DTO (Data Transfer Object):**  
  Dışarıya (veya API'ye) sade, güvenli ve ihtiyaç kadar veri taşır.  
  - DtoStudentIU: Kayıt/güncelleme için giriş veri modeli, validasyon anotasyonları ile korunur.
  - DtoStudent: Cevaplarda dönen sade öğrenci veri modeli.

- **Entity:**  
  Veritabanı tablosunu temsil eden, JPA ile ilişkili model.

- **Repository:**  
  Spring Data JPA ile temel CRUD işlemlerini otomatik olarak yönetir.

- **Service:**  
  İş mantığını kapsar, controller ile repository arasında köprü görevi görür.

- **Exception:**  
  - GlobalExceptionHandler: Spring validasyon hatalarını yakalar ve özelleştirilmiş hata mesajları döner.
  - ApiError: Tüm hata detaylarının standart formatta dönüşünü sağlar.

- **Starter:**  
  Application.java uygulamanın başlangıç noktasıdır.

---

## 📚 API Uç Noktaları

| Metot | Endpoint                       | Açıklama                        |
|-------|--------------------------------|---------------------------------|
| POST  | `/rest/api/student/save`       | Yeni öğrenci kaydı              |
| GET   | `/rest/api/student/list`       | Tüm öğrencileri getirir         |
| GET   | `/rest/api/student/list/{id}`  | ID ile öğrenci getirir          |
| PUT   | `/rest/api/student/update/{id}`| Öğrenciyi günceller             |
| GET   | `/rest/api/student/delete/{id}`| Öğrenciyi siler                 |

---

## 🛡️ Hata Yönetimi ve Validasyon

- 🛑 Alan validasyonları (ör: boş alan, minimum/maximum karakter, email formatı) doğrudan DtoStudentIU üzerinde tanımlanır.
- 💬 Herhangi bir validasyon hatasında, GlobalExceptionHandler ile kullanıcıya özel, anlaşılır ve standart formatta hata mesajı döner.

---

## ⚙️ Projenin Çalıştırılması

1. Repoyu klonla:
   ```bash
   git clone https://github.com/faikaktss/spring-student-advanced-api.git
   ```
2. Veritabanı bağlantı ayarlarını `application.properties` dosyasından güncelle.
3. Projeyi çalıştır:
   ```bash
   ./mvnw spring-boot:run
   ```
4. API endpointlerini test etmek için Postman veya benzeri bir araç kullanabilirsin.

---

## 💡 Notlar

- Kodlarımda açıklamalar ve sade örnekler yeni başlayanlar ve ileri seviye geliştiriciler içindir.
- Proje, kurumsal Java/Spring projelerinde uygulanabilecek en iyi pratikleri yansıtır.
- Katkı veya öneri için iletişime geçebilirsin!

---

## 👨‍💻 Geliştirici

Faik Aktaş  
[GitHub Profilim](https://github.com/faikaktss)

---
