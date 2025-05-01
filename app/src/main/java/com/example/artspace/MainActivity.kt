package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
fun ArtSpaceApp(
    modifier: Modifier = Modifier
) {
    var index by remember { mutableStateOf(1) }
    var image by remember { mutableStateOf(R.drawable._1_girl_with_a_pearl_earring__restored_version_1994____johannes_vermeer) }
    val title: Int
    val artist: Int
    val year: Int

    when (index) {
        1 -> {
            image = R.drawable._1_girl_with_a_pearl_earring__restored_version_1994____johannes_vermeer
            title = R.string.title_1
            artist = R.string.artist_1
            year = R.string.year_1
        }
        2 -> {
            image = R.drawable._2_avenue_in_giverny_or_garden_path_at_giverny___claude_monet
            title = R.string.title_2
            artist = R.string.artist_2
            year = R.string.year_2
        }
        3 -> {
            image = R.drawable._3_the_bookworm_from_carl_spitzweg
            title = R.string.title_3
            artist = R.string.artist_3
            year = R.string.year_3
        }
        4 -> {
            image = R.drawable._4_cafe_terrace_at_night_from_vincent_van_gogh
            title = R.string.title_4
            artist = R.string.artist_4
            year = R.string.year_4
        }
        5 -> {
            image = R.drawable._5_almond_blossoms_from_vincent_van_gogh
            title = R.string.title_5
            artist = R.string.artist_5
            year = R.string.year_5
        }
        6 -> {
            image = R.drawable._6_the_kiss_from_gustav_klimt
            title = R.string.title_6
            artist = R.string.artist_6
            year = R.string.year_6
        }
        7 -> {
            image = R.drawable._7_the_starry_night_from_vincent_van_gogh
            title = R.string.title_7
            artist = R.string.artist_7
            year = R.string.year_7
        }
        8 -> {
            image = R.drawable._8_the_starry_night_from_vincent_van_gogh
            title = R.string.title_8
            artist = R.string.artist_8
            year = R.string.year_8
        }
        9 -> {
            image = R.drawable._9_the_great_wave_of_kanagawa_from__katsushika_hokusai
            title = R.string.title_9
            artist = R.string.artist_9
            year = R.string.year_9
        }
        10 -> {
            image = R.drawable._10_path_in_the_wheat_at_pourville_from_claude_monet
            title = R.string.title_10
            artist = R.string.artist_10
            year = R.string.year_10
        }
        11 -> {
            image = R.drawable._11_impression_rising_sun_from_claude_monet
            title = R.string.title_11
            artist = R.string.artist_11
            year = R.string.year_11
        }
        12 -> {
            image = R.drawable._12_wanderer_above_the_sea_of_fog_by_caspar_david_friedrich
            title = R.string.title_12
            artist = R.string.artist_12
            year = R.string.year_12
        }
        else -> {
            image = R.drawable._1_girl_with_a_pearl_earring__restored_version_1994____johannes_vermeer
            title = R.string.title_1
            artist = R.string.artist_1
            year = R.string.year_1
        }
    }

    val onPreviousClick: () -> Unit = {
        if (index == 1) {
            index = 12
        } else {
            index -= 1
        }
    }

    val onNextClick: () -> Unit = {
        if (index == 12) {
            index = 1
        } else {
            index += 1
        }
    }

    val screenWidth = LocalConfiguration.current.screenWidthDp
    val fillHeightOrWidth: Modifier
    val contentScale: ContentScale

    // Need to refactor
    if (screenWidth < 600) {
        contentScale = ContentScale.FillWidth
        fillHeightOrWidth = modifier.fillMaxWidth()
    } else {
        contentScale = ContentScale.FillHeight
        fillHeightOrWidth = modifier.fillMaxHeight()
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box (
            modifier = Modifier
                .weight(1F)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            ArtworkWall(image, contentScale, modifier = fillHeightOrWidth)
        }
        Column(
        ) {
            Spacer(modifier = Modifier.height(24.dp))
            ArtworkDescriptor(title, artist, year, modifier = Modifier.fillMaxWidth())
            Spacer(modifier = Modifier.height(36.dp))
            DisplayController(onPreviousClick, onNextClick)
        }
    }
}

@Composable
fun ArtworkWall(
    @DrawableRes image: Int,
    contentScale: ContentScale,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RectangleShape,
        color = Color.White,
        shadowElevation = 8.dp,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = image), contentDescription = null,
            contentScale = contentScale,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun ArtworkDescriptor(
    @StringRes artworkTitle: Int,
    @StringRes artworkArtist: Int,
    @StringRes artWorkYear: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = artworkTitle),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "${stringResource(id = artworkArtist)} (${stringResource(id = artWorkYear)})",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun DisplayController(clickedPreviousButton: () -> Unit, clickedNextButton: () -> Unit, modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.padding(bottom = 16.dp)
    ) {
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