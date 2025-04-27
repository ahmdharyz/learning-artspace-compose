package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box (
            modifier = Modifier
                .weight(1F),
            contentAlignment = Alignment.Center
        ) {
            ArtworkWall()
        }
        Column(
            modifier = Modifier,
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            ArtworkDescriptor("Girl with a pearl earring", "Johannes Vermeer", "1994", modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(36.dp))
            DisplayController()
        }
    }
}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier) {
    Surface(
        shape = RectangleShape,
        color = Color.White,
        shadowElevation = 8.dp,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.girl_with_a_pearl_earring_from_johannes_vermeer), contentDescription = null,
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .padding(16.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(artworkTitle: String, artworkArtist: String, artWorkYear: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            artworkTitle,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            artworkArtist + " (" + artWorkYear + ")",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(16.dp)
    ) {
        val clickedPreviousButton = { /*TODO*/ }
        val clickedNextButton = { /*TODO*/ }

        FilledTonalButton(
            onClick = clickedPreviousButton,
            modifier = Modifier.weight(2f)
        ) {
            Text(text = "Previous")
        }
        Spacer(modifier = Modifier.weight(1f))
        FilledTonalButton(
            onClick = clickedNextButton,
            modifier = Modifier.weight(2f)
            ) {
            Text(text = "Next")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}