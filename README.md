<h1 style="font-size:48px; color:#61dafb;">🧠 Rick and Morty Jetpack Compose Projesi</h1>

<p><em>Bu proje, Rick and Morty API’sini kullanarak karakterler, bölümler ve lokasyonlar hakkında bilgi görüntüleyebileceğiniz. Jetpack Compose öğrenme amacıyla geliştirilmiş bir projedir</em></p>


<h2 style="font-size:36px; color:#ffd166;">🗂️ Dosya Yapısı</h2>
``

```
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

<h2 style="font-size:36px; color:#77dd77;">📦 Kullanılan Paketler</h2>

<h3 style="font-size:28px; color:#ff6ec7;">1. Retrofit2</h3>
<h3 style="font-size:28px; color:#ff6ec7;">1. Retrofit2</h3>
*Açıklama:*
RESTful API'ye istek göndermemizi sağlayan kütüphane.
**Kullanımı:**
Rick and Morty API’sine istek atmak için kullanıldı. Karakter listesi, karakter detayları gibi veriler buradan alındı.

<h3 style="font-size:28px; color:#ff6ec7;">2. Gson</h3>
- **Açıklama:**
JSON verisini Kotlin nesnelerine çevirir (ve tam tersi).
- **🛠️ Kullanımı:** 
API'den gelen JSON yanıtlarını `CharacterModel`, `LocationModel` gibi sınıflara dönüştürmek için kullanıldı.

<h3 style="font-size:28px; color:#ff6ec7;">3. Retrofit Gson Converter</h3>
- **Açıklama:**
Retrofit ile Gson entegrasyonu sağlar.
- **🛠️ Kullanımı:** 
Retrofit ile gelen/giden verilerin otomatik olarak JSON-Kotlin dönüşümünü yapar. `.addConverterFactory(GsonConverterFactory.create())` şeklinde eklendi.

<h3 style="font-size:28px; color:#ff6ec7;">4. Coil Compose</h3>
- **Açıklama:**
Jetpack Compose ile uyumlu resim yükleme kütüphanesi.
- **🛠️ Kullanımı:**
Karakterlerin resimlerini API'den asenkron olarak yüklemek ve `Image` bileşeninde göstermek için kullanıldı. (`rememberAsyncImagePainter()`)

<h3 style="font-size:28px; color:#ff6ec7;">5. ViewModel Compose</h3>
- **Açıklama:**
ViewModel ile Jetpack Compose entegrasyonunu sağlar.
- **🛠️ Kullanımı:** 
`CharactersPageActivity` gibi sayfalarda `CharacterViewModel` üzerinden veri almak ve yaşam döngüsüne bağlamak için kullanıldı. (`val viewModel: CharacterViewModel = viewModel()`)

<h3 style="font-size:28px; color:#ff6ec7;">6. Lifecycle Runtime KTX</h3>
- **Açıklama:**
Yaşam döngüsüne duyarlı işlemler için gerekli kütüphane.
- **🛠️ Kullanımı:** 
Asenkron işlemleri (`viewModelScope.launch { }`) ViewModel yaşam döngüsüyle senkronize etmek için kullanılır. Ayrıca `collectAsStateWithLifecycle()` gibi fonksiyonlarda destek sağlar.


<h2 style="font-size:36px; color:#ffd700;">🎨 Özellikler</h2>

- ✅ Jetpack Compose ile modern arayüz tasarımı  
- ✅ Rick and Morty API entegrasyonu  
- ✅ MVVM mimarisi ile yapılandırılmış  
- ✅ Coil ile karakter resimlerinin dinamik yüklenmesi  
- ✅ Retrofit + Gson ile API çağrıları ve veri işleme  
- ✅ Favoriler sayfası ile kullanıcı etkileşimi  

---

<h2 style="font-size:36px; color:#dda0dd;">📱 Ekran Görüntüleri (Opsiyonel)</h2>

> Projeye ait ekran görüntülerini buraya ekleyebilirsin!

---

<h2 style="font-size:36px; color:#87ceeb;">🔗 Bağlantılar</h2>

| Platform     | Link                                                                 |
|--------------|----------------------------------------------------------------------|
| GitHub       | [Proje Sayfası](https://github.com/KULLANICI_ADI/rickmortyapp )      |
| Rick & Morty API | [API Dokümantasyonu](https://rickandmortyapi.com/ )                |

---

<h2 style="font-size:36px; color:#ffb6c1;">📬 İletişim</h2>

E-posta: [isimsoyisim@email.com](mailto:isimsoyisim@email.com)  
LinkedIn: [linkedin.com/in/kullaniciadi](https://www.linkedin.com/in/kullaniciadi )  
Twitter: [@kullaniciadi](https://twitter.com/kullaniciadi )
