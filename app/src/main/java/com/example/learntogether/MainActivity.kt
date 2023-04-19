package com.example.learntogether

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learntogether.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        val image = painterResource(id = R.drawable.header_background)

        HomeScreenHeader(image)

        ArticleTitle()

        ArticleBody()
    }
}

@Composable
fun HomeScreenHeader(
    image: Painter,
    modifier: Modifier = Modifier
) {
    Image(
        painter = image,
        contentDescription = null,
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun ArticleTitle(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(id = R.string.article_title),
        modifier = modifier.padding(16.dp),
        fontSize = 24.sp,
    )
}

@Composable
fun ArticleBody(modifier: Modifier = Modifier) {
    Column {
        ArticleParagraph(
            contentId = R.string.intro_paragraph_1,
            paddingType = stringResource(R.string.start_and_end_padding)
        )
        ArticleParagraph(
            contentId = R.string.intro_paragraph_2,
            paddingType = stringResource(R.string.all_padding)
        )
    }
}

@Composable
fun ArticleParagraph(
    contentId: Int,
    paddingType: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = contentId),
        modifier = if (paddingType == "startAndEnd") modifier.padding(
            start = 16.dp,
            end = 16.dp
        ) else modifier.padding(16.dp),
        textAlign = TextAlign.Justify
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LearnTogetherPreview() {
    ComposeArticleTheme {
        HomeScreen()
    }
}