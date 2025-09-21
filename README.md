# 🎓 Spring Student Directory

Merhaba!  
Bu proje, **Spring Boot**, **Spring Data JPA** ve katmanlı mimari kullanılarak geliştirilmiş modern bir öğrenci yönetim REST API'sidir.  
Amaç; temiz kod, DTO, servis, repository ve controller yapılarının gerçek bir projede nasıl kullanılacağını göstermek ve öğrenmektir.

---

## 🚀 Özellikler

- 📝 Öğrenci ekle, listele, güncelle, sil (CRUD)
- 💾 Spring Data JPA ile veritabanı işlemleri (Entity, Repository)
- 🪄 DTO yapısı ile veri transferi
- 🧩 Katmanlı mimari (Controller, Service, Repository, Entity, DTO)
- 🔄 Bean ve dependency injection ile gevşek bağlılık
- 🛡️ Temiz ve anlaşılır kod

---

## 🏗️ Proje Mimarisi

```
src/main/java/com/faik/
├── Controller/
│   ├── Impl/
│   │   └── StudentControllerImpl.java   # REST API controller implementasyonu
│   └── IStudentController.java          # Controller arayüzü (interface)
│
├── dto/
│   ├── DtoStudent.java                  # Öğrenci DTO'su (dışarıya dönen veri)
│   └── DtoStudentIU.java                # Öğrenci input/update DTO'su (kayıt/güncelleme için)
│
├── Entites/
│   └── Student.java                     # JPA Entity (veritabanı modeli)
│
├── Repository/
│   └── StudentRepository.java           # JPA repository interface'i
│
├── Services/
│   ├── Impl/
│   │   └── StudentServiceImpl.java      # Servis katmanı implementasyonu
│   └── IStudentService.java             # Servis arayüzü
│
└── Starter/
    └── Application.java                 # Uygulama başlatıcı (SpringBootApplication)
```

---

## 🧑‍💻 Katmanlar ve Görevleri

- **Controller:**  
  API uç noktalarını tanımlar, gelen istekleri karşılar ve DTO ile veri dönüşü yapar.

- **DTO (Data Transfer Object):**  
  Veri transferini sadeleştirir ve dışarıya sadece gerekli verileri açar.

- **Entity:**  
  Veritabanı tablosunu temsil eder, JPA ile ilişkilidir.

- **Repository:**  
  JPA ile CRUD işlemlerini sağlar.

- **Service:**  
  İş mantığını ve veri işlemlerini yönetir, controller ile repository arasında köprü görevi görür.

---

## 🛣️ API Endpointleri

| Metot | Endpoint                        | Açıklama                      |
|-------|---------------------------------|-------------------------------|
| POST  | `/rest/api/student/save`        | Yeni öğrenci kaydı            |
| GET   | `/rest/api/student/list`        | Tüm öğrencileri listeler      |
| GET   | `/rest/api/student/list/{id}`   | ID’ye göre öğrenci getirir    |
| PUT   | `/rest/api/student/update/{id}` | Öğrenci güncelleme            |
| GET   | `/rest/api/student/delete/{id}` | Öğrenci silme                 |

---

## ⚙️ Çalıştırmak İçin

1. Repoyu klonla:
   ```bash
   git clone https://github.com/faikaktss/spring-student-directory.git
   ```
2. Gerekli veritabanı ve `application.properties` ayarlarını yap.
3. Projeyi başlat:
   ```bash
   ./mvnw spring-boot:run
   ```
   veya
   ```bash
   mvn spring-boot:run
   ```
4. API endpointlerini Postman veya benzeri bir araç ile test edebilirsin.

---

## 🔗 Katkı ve Geri Bildirim

- Kodlarımda bol bol açıklama ve sadeleşme vardır, öğrenen herkesin faydalanması için hazırlanmıştır.
- Her türlü katkı, öneri ve sorular için iletişime geçebilirsin!



