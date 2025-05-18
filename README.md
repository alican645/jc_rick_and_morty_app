

---

# Rick and Morty Jetpack Compose Projesi

> Bu projede, Rick and Morty API’sini kullanarak karakterler, bölümler ve lokasyonlar hakkında bilgileri görünteleyebileceğimiz bir uygulama geliştirilmeye çalışılmıştır. Jetpack Compose öğrenmek amacıyla geliştirilmiş bir projedir.

---

##  Dosya Yapısı

```
.
├── 📁 ui/
│   └── 📁 theme/
│       ├── 📄 Color.kt        - Uygulama renk paleti
│       ├── 📄 Theme.kt         - Uygulama temaları
│       └── 📄 Type.kt          - Yazı tipleri tanımları
│
├── 📄 NavBarActivity.kt        - Navigasyon çubuğu
├── 📄 MainActivity.kt         - Ana aktivite
├── 📄 RetrofitClient.kt        - API istekleri için Retrofit ayarları
├── 📄 ApiUtils.kt              - API yardımcı fonksiyonları
│
├── 📁 components/              - UI bileşenleri
│   ├── 📄 LocationCardWidget.kt
│   ├── 📄 CharacterPropertCardWidget.kt
│   ├── 📄 LazyColumnForCharatersPage.kt
│   ├── 📄 CharacterCardWidget.kt
│   ├── 📄 CustomTextField.kt
│   └── 📄 EpisodeCardWidget.kt
│
├── 📁 data/
│   ├── 📁 viewmodels/
│   │   ├── 📄 EpisodeViewModel.kt
│   │   └── 📄 CharacterViewModel.kt
│   │
│   ├── 📁 model/
│   │   ├── 📄 CharacterResponseModel.kt
│   │   ├── 📄 EpisodeModel.kt
│   │   ├── 📄 InfoModel.kt
│   │   ├── 📄 LocationModel.kt
│   │   ├── 📄 OriginModel.kt
│   │   ├── 📄 CharacterModel.kt
│   │   └── 📄 EpisodeResponseModel.kt
│   │
│   └── 📁 interfaces/
│       ├── 📄 CharacterDaoInterface.kt
│       ├── 📄 EpisodesDaoInterface.kt
│       └── 📄 LocationsDaoInterface.kt
│
└── 📁 pages/
    ├── 📁 characters_description_page/
    │   └── 📄 CharacterDescritionPageActivity.kt
    ├── 📁 favs_page/
    │   └── 📄 FavsPage.kt
    ├── 📁 episodes_page/
    │   └── 📄 EpisodesPage.kt
    ├── 📁 characters_page/
    │   └── 📄 CharactersPageActivity.kt
    └── 📁 location_page/
        └── 📄 LocationPage.kt
```

---

##  Kullanılan Paketler

### 1. `implementation("com.squareup.retrofit2:retrofit:2.9.0")`
- ** Açıklama:** RESTful API'ye istek göndermemizi sağlayan kütüphane.
- ** Kullanımı:** Rick and Morty API’sine istek atmak için kullanıldı. Karakter listesi, karakter detayları gibi veriler buradan alındı.

---

### 2. `implementation("com.google.code.gson:gson:2.10")`
- ** Açıklama:** JSON verisini Kotlin nesnelerine çevirir (ve tam tersi).
- ** Kullanımı:** API'den gelen JSON yanıtlarını `CharacterModel`, `LocationModel` gibi sınıflara dönüştürmek için kullanıldı.

---

### 3. `implementation("com.squareup.retrofit2:converter-gson:2.9.0")`
- ** Açıklama:** Retrofit ile Gson entegrasyonunu sağlar.
- ** Kullanımı:** Retrofit ile gelen/giden verilerin otomatik olarak JSON-Kotlin dönüşümünü yapar. `.addConverterFactory(GsonConverterFactory.create())` şeklinde eklendi.

---

### 4. `implementation("io.coil-kt:coil-compose:2.4.0")`
- ** Açıklama:** Jetpack Compose ile uyumlu resim yükleme kütüphanesi.
- ** Kullanımı:** Karakterlerin resimlerini API'den asenkron olarak yüklemek ve `Image` bileşeninde göstermek için kullanıldı. (`rememberAsyncImagePainter()`)

---

### 5. `implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")`
- ** Açıklama:** ViewModel ile Jetpack Compose entegrasyonunu sağlar.
- ** Kullanımı:** `CharactersPageActivity` gibi sayfalarda `CharacterViewModel` üzerinden veri almak ve yaşam döngüsüne bağlamak için kullanıldı. (`val viewModel: CharacterViewModel = viewModel()`)

---

##  Kazanımlar

-  Jetpack Compose ile arayüz tasarımında layout mantığını kavrama  
-  API entegrasyonu deneyimi  
-  MVVM mimarisi ile çalışma deneyimi  
-  Coil paketi ile web üzerinden dinamik olarak resim yükleme  
-  Retrofit + Gson ile API çağrıları ve veri işleme  
-  Sayfalar arası veri aktarımı  
-  Bileşenleri parçalama ve yeniden kullanılabilir yapı oluşturma mantığı  

---

## 📱 Ekran Görüntüleri 

<p align="center">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747582043.png" width="300" alt="Karakterler Sayfası ">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747582079.png" width="300" alt="Karakter Sayfası 2">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747582056.png" width="300" alt="Favoriler Sayfası">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747582066.png" width="300" alt="Karakter Detay Sayfası">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747583637.png" width="300" alt="Konumlar Sayfası">
  <img src="https://github.com/alican645/jc_rick_and_morty_app/blob/main/app/images/Screenshot_1747583708.png" width="300" alt="Bölümler Sayfası">
</p>



---

## 🔗 Bağlantılar

| Platform     | Link                                                                 |
|--------------|----------------------------------------------------------------------|
| GitHub       | [Proje Sayfası](https://github.com/alican645/jc_rick_and_morty_app)      |
| Rick & Morty API | [API Dokümantasyonu](https://rickandmortyapi.com/)                |

---

## 📬 İletişim

📧 E-posta: [alican.aydin010@gmail.com](mailto:alican.aydin010@gmail.com)  
🔗 LinkedIn: [linkedin.com/in/ali-can-aydın-420815253](https://www.linkedin.com/in/ali-can-aydin-420815253)  

---

