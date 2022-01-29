package com.example.compose_curved_scroll_library

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_curved_scroll.CurvedScrollView
import com.example.compose_curved_scroll_library.ui.theme.ComposeCurvedScrolllibraryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCurvedScrolllibraryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CurvedScroll()

                }
            }
        }
    }
}

@Composable
fun CurvedScroll() {
    //List of item add
    val items = listOf(
        "Dog1",
        "Dog2",
        "Dog3",
        "Dog4",
        "Dog5",
        "Dog6",
        "Dog7",
        "Dog8",
        "Dog9"
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Curved Scrollview",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 10.dp, end = 10.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            CurvedScrollView(items.size) { index ->
                Column(
                    modifier = Modifier.wrapContentSize()
                ) {
                    Image(
                        painter = painterResource(
                            id =
                            when (index) {
                                0 -> R.drawable.a
                                1 -> R.drawable.b
                                2 -> R.drawable.c
                                3 -> R.drawable.d
                                4 -> R.drawable.e
                                5 -> R.drawable.f
                                6 -> R.drawable.g
                                7 -> R.drawable.h
                                8 -> R.drawable.i
                                else -> R.drawable.j
                            }
                        ),
                        contentDescription = "Curved Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(70.dp)
                            .clip(CircleShape)
                    )

                    Spacer(modifier = Modifier.padding(5.dp))

                    Text(
                        text = items[index],
                        style = MaterialTheme.typography.h6
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = "Curved Logo Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(120.dp)
                    .height(150.dp)
                    .clip(RoundedCornerShape(20.dp))
            )
        }
    }
}