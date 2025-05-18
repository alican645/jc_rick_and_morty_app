📁 ui/
  📁 theme/
    📄 Color.kt
    📄 Theme.kt
    📄 Type.kt
📄 NavBarActivity.kt
📄 MainActivity.kt
📄 RetrofitClient.kt
📄 ApiUtils.kt
📁 components/
  📄 LocationCardWidget.kt
  📄 CharacterPropertCardWidget.kt
  📄 LazyColumnForCharatersPage.kt
  📄 CharacterCardWidget.kt
  📄 CustomTextField.kt
  📄 EpisodeCardWidget.kt
📁 data/
  📁 viewmodels/
    📄 EpisodeViewModel.kt
    📄 CharacterViewModel.kt
  📁 model/
    📄 CharacterResponseModel.kt
    📄 EpisodeModel.kt
    📄 InfoModel.kt
    📄 LocationModel.kt
    📄 OriginModel.kt
    📄 CharacterModel.kt
    📄 EpisodeResponseModel.kt
  📁 interfaces/
    📄 CharacterDaoInterface.kt
    📄 EpisodesDaoInterface.kt
    📄 LocationsDaoInterface.kt
📁 pages/
  📁 characters_description_page/
    📄 CharacterDescritionPageActivity.kt
  📁 favs_page/
    📄 FavsPage.kt
  📁 episodes_page/
    📄 EpisodesPage.kt
  📁 characters_page/
    📄 CharactersPageActivity.kt
  📁 location_page/
    📄 LocationPage.kt










1.implementation("com.squareup.retrofit2:retrofit:2.9.0")
•Ne İşe Yarar: Bu, Retrofit adlı popüler bir ağ kütüphanesinin ana modülüdür. Temel görevi, Android uygulamanızın uzak sunucularla (API'ler) HTTP üzerinden iletişim kurmasını kolaylaştırmaktır.
•Projenizdeki Kullanımı: Rick and Morty API'sine istekler göndermek (örneğin, karakter listesini almak, belirli bir karakterin detaylarını çekmek) için kullanılır. API endpoint'lerinizi (uç noktalarınızı) Kotlin arayüzleri (CharacterDaoInterface gibi) üzerinden tanımlamanızı ve bu arayüzleri kullanarak ağ çağrıları yapmanızı sağlar.
2.implementation("com.google.code.gson:gson:2.10")
•Ne İşe Yarar: Bu, Gson adlı bir Java (ve dolayısıyla Kotlin ile uyumlu) kütüphanesidir. JSON (JavaScript Object Notation) verilerini Java/Kotlin nesnelerine dönüştürme (deserialization) ve Java/Kotlin nesnelerini JSON formatına çevirme (serialization) işlemlerini yapar.
•Projenizdeki Kullanımı: Rick and Morty API'sinden gelen JSON formatındaki yanıtları, projenizde tanımladığınız veri sınıflarına (CharacterModel, Location, CharacterResponseModel gibi) otomatik olarak dönüştürmek için kullanılır. Bu sayede API'den gelen karmaşık verilerle Kotlin kodunuzda daha kolay çalışabilirsiniz.
3.implementation("com.squareup.retrofit2:converter-gson:2.9.0")
•Ne İşe Yarar: Bu, Retrofit için bir dönüştürücü (converter) modülüdür. Retrofit'in Gson kütüphanesini kullanarak JSON verilerini otomatik olarak işlemesini sağlar.
•Projenizdeki Kullanımı: Retrofit, API'den bir yanıt aldığında veya API'ye bir istek gövdesi gönderdiğinde, bu dönüştürücü sayesinde gelen JSON verisini doğrudan CharacterModel gibi Kotlin nesnelerine çevirir veya göndereceğiniz Kotlin nesnesini JSON formatına dönüştürür. Bu, Retrofit.Builder() içinde .addConverterFactory(GsonConverterFactory.create()) şeklinde eklenerek kullanılır.
4.implementation("io.coil-kt:coil-compose:2.4.0")
•Ne İşe Yarar: Bu, Coil (Coroutine Image Loader) adlı bir resim yükleme kütüphanesinin Jetpack Compose için özel olarak tasarlanmış sürümüdür. İnternetten veya yerel kaynaklardan resimleri asenkron olarak yüklemek, önbelleğe almak ve Jetpack Compose Image bileşenlerinde görüntülemek için kullanılır.
•Projenizdeki Kullanımı: Rick and Morty karakterlerinin resimlerini API'den gelen URL'ler aracılığıyla yükleyip CharacterCard gibi Compose bileşenlerinde göstermek için kullanılır. Örneğin, rememberAsyncImagePainter(model = character.image) şeklinde kullanılır.

5.implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.0")
•Ne İşe Yarar: Bu, Android Jetpack Lifecycle kütüphanesinin bir parçasıdır ve Jetpack Compose ile ViewModel entegrasyonunu sağlar. viewModel() gibi Compose fonksiyonlarını kullanarak ViewModel örneklerine kolayca erişmenizi ve bunları Composable fonksiyonlarınızın yaşam döngüsüne bağlamanızı mümkün kılar.•Projenizdeki Kullanımı: CharactersPageActivity gibi Composable ekranlarınızda CharacterViewModel gibi ViewModel sınıflarınızdan veri almak ve ViewModel fonksiyonlarını çağırmak için kullanılır. Örneğin, val viewModel: CharacterViewModel = viewModel() şeklinde ViewModel'a erişilir. Bu, ekran döndürme gibi konfigürasyon değişikliklerinde UI ile ilgili verilerin korunmasına yardımcı olur.6.implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.9.0")•Ne İşe Yarar: Bu da Android Jetpack Lifecycle kütüphanesinin bir parçasıdır ve yaşam döngüsüne duyarlı bileşenler oluşturmak için temel çalışma zamanı bileşenlerini ve Kotlin eklentilerini (KTX) içerir. Özellikle ViewModelScope gibi Coroutine scope'larını ViewModel'ların yaşam döngüsüne bağlamak için önemlidir.•Projenizdeki Kullanımı: CharacterViewModel gibi ViewModel sınıflarınızda asenkron işlemler (örneğin, ağ istekleri) yapmak için kullanılan viewModelScope.launch { ... } gibi Coroutine scope'larının doğru şekilde çalışmasını ve ViewModel yok edildiğinde bu işlemlerin otomatik olarak iptal edilmesini sağlar. Ayrıca collectAsStateWithLifecycle() gibi yaşam döngüsüne duyarlı StateFlow ve SharedFlow toplama işlemlerinde de rol oynar.
