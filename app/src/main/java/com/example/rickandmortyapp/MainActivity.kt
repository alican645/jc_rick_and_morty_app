package com.example.rickandmortyapp
import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortyapp.pages.characters_description_page.CharacterDetailScreen
import com.example.rickandmortyapp.ui.theme.RickAndMortyAppTheme
import java.io.File


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @ExperimentalMaterial3Api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val appContext = LocalContext.current
            LaunchedEffect(Unit) {
                val rootDir = File(appContext.filesDir, "/Users/alicanaydin/Desktop/my_compose_projects/RickAndMortyApp/app/src/main/java/com/example/rickandmortyapp")
                listDirectoryStructure(rootDir)
            }

            val navController = rememberNavController()
            RickAndMortyAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                   NavBar(navController)
                }
            }
        }
    }
}




fun listDirectoryStructure(directory: File, indent: String = "") {
    if (directory.exists() && directory.isDirectory) {
        val files = directory.listFiles()
        files?.forEach { file ->
            if (file.isDirectory) {
                println("$indent📁 ${file.name}/")
                listDirectoryStructure(file, "$indent  ")
            } else {
                println("$indent📄 ${file.name}")
            }
        }
    } else {
        println("Belirtilen yol geçerli bir klasör değil.")
    }
}
