package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp(modifier: Modifier = Modifier) {
    val art1 = R.drawable.istanbul_bosphorus
    val art2 = R.drawable.tram
    val art3 = R.drawable.galata_tower
    val art4 = R.drawable.sultan_ahmet_mosque

    var title by remember { mutableStateOf(R.string.istanbul_bosphorus) }
    var art by remember { mutableStateOf(art1) }
    var artist by remember { mutableStateOf(R.string.artist_istanbul_bosphorus) }
    var year by remember { mutableStateOf(R.string.istanbul_bosphorus_year) }

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        ArtDisplay(currentArt = art, contentArt = art)
        Spacer(modifier = modifier.size(16.dp))
        ArtTitle(title = title, artist = artist, year = year)
        Spacer(modifier = modifier.size(25.dp))
        Row(
            modifier = modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            OutlinedButton(
                onClick = {
                when(art){
                    art1 -> {
                        art = art4
                        title = R.string.sultan_ahmet
                        artist = R.string.artist_sultan_ahmet
                        year = R.string.sultan_ahmet_year
                    }
                    art2 -> {
                        art = art1
                        title = R.string.istanbul_bosphorus
                        artist = R.string.artist_istanbul_bosphorus
                        year = R.string.istanbul_bosphorus_year
                    }
                    art3 -> {
                        art = art2
                        title = R.string.istiklal
                        artist = R.string.artist_istiklal
                        year = R.string.istiklal_year
                    }
                    art4 -> {
                        art = art3
                        title = R.string.galata
                        artist = R.string.artist_galata
                        year = R.string.galata_year
                    }
                }
            },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffEFF3F3),
                    contentColor = Color(0xff000000)
                ),
                modifier = modifier.width(110.dp)
            ) {
                Text(text = "Previous")
            }
            OutlinedButton(
                onClick = {
                    when(art){
                        art1 -> {
                            art = art2
                            title = R.string.istiklal
                            artist = R.string.artist_istiklal
                            year = R.string.istiklal_year
                        }
                        art2 -> {
                            art = art3
                            title = R.string.galata
                            artist = R.string.artist_galata
                            year = R.string.galata_year
                        }
                        art3 -> {
                            art = art4
                            title = R.string.sultan_ahmet
                            artist = R.string.artist_sultan_ahmet
                            year = R.string.sultan_ahmet_year
                        }
                        art4 -> {
                            art = art1
                            title = R.string.istanbul_bosphorus
                            artist = R.string.artist_istanbul_bosphorus
                            year = R.string.istanbul_bosphorus_year
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffEFF3F3),
                    contentColor = Color(0xff000000)
                ),
                modifier = modifier.width(110.dp)
            ) {
                Text(text = "Next")
            }
        }

    }

}

@Composable
fun ArtDisplay(
    modifier: Modifier = Modifier,
    @DrawableRes currentArt: Int,
    @StringRes contentArt: Int
) {
   Image(
       painter = painterResource(id = currentArt),
       contentDescription = stringResource(id = contentArt),
       modifier = modifier.clip(RoundedCornerShape(25.dp)),
       contentScale = ContentScale.Fit
   )
}

@Composable
fun ArtTitle(
    modifier: Modifier = Modifier,
    @StringRes title: Int,
    @StringRes artist: Int,
    @StringRes year: Int
) {
    Text(
        text = stringResource(id = title),
        fontWeight = FontWeight.Medium,
        fontSize = 23.sp,
        modifier = modifier.padding(bottom = 3.dp)
    )
    Text(
        text = stringResource(id = artist),
        fontWeight = FontWeight.Bold,
        fontStyle = FontStyle.Italic
    )
    Text(
        text = stringResource(id = year),
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Normal
    )
}

@Composable
@Preview
fun ArtSpacePreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}