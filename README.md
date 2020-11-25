# Kütüphane Uygulaması

Java, Spring Boot, Thymeleaf ve Spring Data JPA ile yapılmış bir kütüphane uygulaması.

Uygulamada MVC tasarım deseni kullanılmıştır. Bu tasarım desenini kullanmamdaki amaç uygulamadaki iş kodları ve kullanıcı arayüzünün birbirinden ayrılarak çok katmanlı bir mimari oluşturmak ve uygulamanın sürdürülebilirliğini sağlamaktı.

Uygulamanın lokalde çalıştırılabilmesi için öncelikle Java 11 bilgisayarınıza yüklenmesi gerekmektedir.

Uygulama çalıştırıldığında eğer bir IDE kullanılıyorsa pom.xml içerisindeki dependencyler otomatik olarak yüklenecektir.

Veritabanı olarak h2 veritabanı kullanılmıştır bu yüzden herhangi bir veritabanı konfigurasyonu yapmanıza gerek yoktur.

Veritabanına uygulama bir ide ile çalıştırıldıktan sonra localhost:8080/h2-console endpointi ile veritabanına ulaşılabilir.

## Veritabanı bilgileri

- **URL:** jdbc:h2:file:./data/library-database
- **Kullanıcı Adı:** merve
- **Şifre:** 1234
