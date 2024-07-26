package com.example.openinappassignment.screens

import ApiResponse
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Analytics
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.QuestionMark
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.TouchApp
import androidx.compose.material.icons.outlined.Web
import androidx.compose.material.icons.outlined.Whatsapp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


import com.example.openinappassignment.customcomponents.CustomButtonWithIcon
import com.example.openinappassignment.customcomponents.CustomButtonWithIconNoTint
import com.example.openinappassignment.customcomponents.CustomText14Weight400
import com.example.openinappassignment.customcomponents.CustomText16Weight400
import com.example.openinappassignment.customcomponents.CustomText24Weight600
import com.example.openinappassignment.customcomponents.GraphChartComposeView
import com.example.openinappassignment.customcomponents.LinkCard
import com.example.openinappassignment.viewmodels.DashboardViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(viewModel: DashboardViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
    LaunchedEffect(Unit) {
        viewModel.getDashboardData()
    }
    val dashboardData by viewModel.dashboardData.collectAsState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xff0E6FFF))
    ) {
        TopAppBar(
            title = { CustomText24Weight600("Dashboard", color = Color.White) },
            colors = TopAppBarDefaults.topAppBarColors(Color(0xff0E6FFF))
        )
        Spacer(modifier = Modifier.height(16.dp))
        DashboardCard(dashboardData)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DashboardCard(dashboardData: List<ApiResponse>) {
    val coroutineScope = rememberCoroutineScope()
    val list = listOf("Top Links", "Recent Links")
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val scrollState = rememberScrollState()
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .clip(shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp))
            .background(color = Color(0xFFF5F5F5))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        items(dashboardData.size) { it ->
            CustomText16Weight400(
                text = "Good morning",
                color = Color.LightGray
            )
            CustomText24Weight600(
                text = "Pranav Panwar 👋"
            )

            Spacer(modifier = Modifier.height(16.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column {
                    CustomText14Weight400(text = "Overview", color = Color.Gray)
                    GraphChartComposeView(dashboardData[it].data.overallUrlChart)
                }

            }

            Spacer(modifier = Modifier.height(16.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(scrollState)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp) // Adjust spacing between cards
                ) {
                    ClickCard(
                        icon = Icons.Outlined.TouchApp,
                        iconTint = Color(0xff5c33cf),
                        iconBackColor = Color(0x125C33CF),
                        title = "${dashboardData[it].todayClicks}",
                        subtitle = "Today's clicks"
                    )
                    ClickCard(
                        title = dashboardData[it].topLocation,
                        subtitle = "Top Location",
                        icon = Icons.Outlined.LocationOn,
                        iconBackColor = Color(0x120E6FFF),
                        iconTint = Color(0xff0E6FFF)
                    )
                    ClickCard(
                        title = dashboardData[it].topSource,
                        subtitle = "Top source",
                        icon = Icons.Outlined.Web,
                        iconBackColor = Color(0x12FF4E64),
                        iconTint = Color(0xFFFF4E64)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            CustomButtonWithIconNoTint(
                buttonText = "View Analytics",
                onClick = {},
                icon = Icons.Outlined.Analytics
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TabRow(
                    modifier = Modifier.fillMaxWidth(.7f),

                    divider = {},
                    containerColor = Color.Transparent,
                    selectedTabIndex = pagerState.currentPage,
                    indicator = { Box(modifier = Modifier) }
                ) {
                    list.forEachIndexed { index, text ->
                        Tab(
                            unselectedContentColor = Color.LightGray,
                            selectedContentColor = Color.White,
                            selected = index == pagerState.currentPage,
                            modifier = Modifier
                                .height(45.dp)
                                .then(
                                    if (index == pagerState.currentPage) {
                                        Modifier
                                            .clip(shape = RoundedCornerShape(20.dp))
                                            .background(Color(0xff0E6FFF))
                                    } else {
                                        Modifier
                                    }
                                ),
                            onClick = {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                            text = {
                                Text(
                                    text = text,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.W600,

                                    )
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .border(1.dp, color = Color.Gray, shape = RoundedCornerShape(5.dp))
                        .size(40.dp)
                ) {
                    Icon(
                        tint = Color.Gray,
                        imageVector = Icons.Outlined.Search,
                        contentDescription = "search"
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { index ->
                when (index) {
                    0 -> LinkCard(dashboardData[it], index)
                    1 -> LinkCard(dashboardData[it], index)
                }
            }

            CustomButtonWithIconNoTint(
                buttonText = "View All Links",
                onClick = {},
                icon = Icons.Outlined.Link
            )

            Spacer(modifier = Modifier.height(15.dp))

            CustomButtonWithIcon(
                boxColor = Color(0x1F4AD15F),
                boxBorderColor = Color(0x524AD15F),
                boxIcon = Icons.Outlined.Whatsapp,
                buttonText = "Talk with us",
                iconColor = Color(0xFF4AD15F),
                onClick = {
                    openWhatsAppChat(
                        context = context,
                        phoneNumber = dashboardData[it].supportWhatsappNumber
                    )
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            CustomButtonWithIcon(
                boxColor = Color(0xFfE8F1FF),
                boxBorderColor = Color(0x520E6FFF),
                boxIcon = Icons.Outlined.QuestionMark,
                buttonText = "Frequently Asked Questions",
                iconColor = Color(0xff0E6FFF), onClick = {}
            )
        }
    }

}

@Composable
fun ClickCard(
    title: String,
    subtitle: String,
    icon: ImageVector,
    iconBackColor: Color,
    iconTint: Color
) {
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
            .width(120.dp)

            .padding(10.dp)
    ) {
        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(25.dp),
            colors = IconButtonDefaults.iconButtonColors(iconBackColor)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "icons",
                tint = iconTint,
                modifier = Modifier.padding(3.dp)
            )
        }
        Text(
            title, fontSize = 16.sp, overflow = TextOverflow.Ellipsis, maxLines = 1,
            fontWeight = FontWeight.W600,
            color = Color.Black,
        )

        CustomText14Weight400(subtitle, color = Color.Gray)
    }
}

fun openWhatsAppChat(phoneNumber: String, context: Context) {

    try {
        val whatsappUri = Uri.parse("smsto:${phoneNumber}")
        val sendIntent = Intent(Intent.ACTION_SENDTO, whatsappUri)
        sendIntent.setPackage("com.whatsapp")
        context.startActivity(sendIntent)
    } catch (e: Exception) {
        Log.e("error", e.toString())
    }
}
