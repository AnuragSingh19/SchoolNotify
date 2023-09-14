package com.cy.schoolnotify.screens.onboarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cy.schoolnotify.CommonViewModel
import com.cy.schoolnotify.R
import com.cy.schoolnotify.comon_utils.AsyncImageView
import com.cy.schoolnotify.comon_utils.BodyMediumTextWithSemiBoldFont
import com.cy.schoolnotify.comon_utils.HeadTitleTextWithBoldFont
import com.cy.schoolnotify.comon_utils.TitleMediumTextWithSemiBoldFont
import com.cy.schoolnotify.ui.theme.BlueColor
import com.cy.schoolnotify.ui.theme.LightPink
import com.cy.schoolnotify.ui.theme.SNTypography
import com.cy.schoolnotify.ui.theme.SecondaryTextColor
import com.cy.schoolnotify.ui.theme.TextColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(uiState: CommonViewModel.CommonUIState) {
    val scope = rememberCoroutineScope()
    val pageState = rememberPagerState()
    Column(modifier = Modifier.fillMaxSize()) {
        TopSkipButton {
            if (pageState.currentPage + 1 < uiState.OnboardingScreenList.size) scope.launch {
                pageState.scrollToPage(uiState.OnboardingScreenList.size)
            }
        }
        HorizontalPager(
            count = uiState.OnboardingScreenList.size,
            state = pageState,
            modifier = Modifier
                .fillMaxHeight(0.8f)
                .fillMaxWidth()
        ) { page ->
            OnBoardingItem(image = "", title = "", description = "")
        }
        BottomIndicatorWithFAndBButton(
            size = uiState.OnboardingScreenList.size,
            index = pageState.currentPage,
            isBackButtonVisible = pageState.currentPage != 0,
            isNextButtonVisible = pageState.currentPage != uiState.OnboardingScreenList.size - 1,
            onNextClick = {
                if (pageState.currentPage + 1 < uiState.OnboardingScreenList.size) scope.launch {
                    pageState.scrollToPage(pageState.currentPage + 1)
                }
            },
            onBackClick = {
                if (pageState.currentPage + 1 > 1) scope.launch {
                    pageState.scrollToPage(pageState.currentPage - 1)
                }
            }
        )

    }


}

@Composable
fun TopSkipButton(onSkipClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 12.dp, top = 12.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        TextButton(
            onClick = { onSkipClick() },
            border = BorderStroke(1.dp, color = BlueColor),
            shape = RoundedCornerShape(4.dp),
            contentPadding = PaddingValues(start = 24.dp, end = 24.dp),

            ) {
            TitleMediumTextWithSemiBoldFont(value = "Skip", color = BlueColor)
        }
    }

}

@Composable
fun BoxScope.Indicators(size: Int, index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.Center)
    ) {
        repeat(size) {
            Indicator(isSelected = it == index)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy), label = ""
    )

    Box(
        modifier = Modifier
            .height(10.dp)
            .width(width.value)
            .clip(CircleShape)
            .background(
                color = if (isSelected) BlueColor else LightPink
            )
    ) {

    }
}

@Composable
fun OnBoardingItem(image: String, title: String, description: String) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        AsyncImageView(
            data = image,
            context = LocalContext.current,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.75f)
                .height(250.dp)
        )

        Spacer(modifier = Modifier.height(32.dp))
        HeadTitleTextWithBoldFont(value = title, color = TextColor)
        Spacer(modifier = Modifier.height(20.dp))
        BodyMediumTextWithSemiBoldFont(
            value = description,
            color = SecondaryTextColor,
            textAlign = TextAlign.Center
        )
    }

}

@Composable
fun BottomIndicatorWithFAndBButton(
    size: Int,
    index: Int,
    onNextClick: () -> Unit,
    onBackClick: () -> Unit,
    isBackButtonVisible: Boolean,
    isNextButtonVisible: Boolean
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        if (isBackButtonVisible) {
            Card(
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .width(48.dp)
                    .height(24.dp)
                    .clickable { onBackClick() },
                colors = CardDefaults.cardColors(containerColor = BlueColor),
                shape = RoundedCornerShape(12.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_arrow_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }

            }
        }


        // Indicators
        Indicators(size, index)

        if (isNextButtonVisible) {
            Card(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .width(48.dp)
                    .height(24.dp)
                    .clickable { onNextClick() },
                colors = CardDefaults.cardColors(containerColor = BlueColor),
                shape = RoundedCornerShape(12.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.farword_arrow_24),
                        contentDescription = "",
                        tint = Color.White
                    )
                }

            }
        }/*else{
            Card(
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .clickable { },
                colors = CardDefaults.cardColors(containerColor = BlueColor),
                shape = RoundedCornerShape(12.dp)


            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                   Text(text = "Navigate App", style = SNTypography.labelMedium)
                }

            }
        }*/


    }
}

data class OnboardingData(val image: String, val title: String, val description: String)

@Preview
@Composable
fun OnboardingItemPreview() {
    Column {
        /*  TopSkipButton(onSkipClick = {})
          OnBoardingItem(
              image = "https://fastly.picsum.photos/id/395/536/354.jpg?hmac=AvFdhapvSH2jATcZEUwVQx6FXvwxnTmonRJtAUjWodE",
              title = "What is Lorem Ipsum?",
              description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
          )*/

        /* BottomIndicatorWithFAndBButton(
             size = 3,
             index = 0,
             onNextClick = {},
             onBackClick = {},
             isBackButtonVisible = false
         )*/
        //  OnBoardingScreen()
    }

}