package com.example.openinappassignment.customcomponents

import ApiResponse
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

@Composable
fun LinkCard(
    linkData: ApiResponse,
    index: Int,

    ) {
    Column(modifier = Modifier.fillMaxSize())
    {
        if (index == 0) {
            linkData.data.topLinks.forEach { value ->

                LinkCardUI(
                    value.createdAt,
                    value.originalImage,
                    value.webLink,
                    value.title,
                    value.totalClicks
                )
                Spacer(modifier = Modifier.height(15.dp))
            }
        } else {
            linkData.data.recentLinks.forEach { value ->
                LinkCardUI(
                    value.createdAt,
                    value.originalImage,
                    value.webLink,
                    value.title,
                    value.totalClicks
                )
                Spacer(modifier = Modifier.height(15.dp))
            }


        }

    }

}


@Composable
fun LinkCardUI(
    createdAt: String,
    originalImage: String,
    webUrl: String,
    title: String,
    totalClicks: Long
) {
    val dateTime = ZonedDateTime.parse(createdAt, DateTimeFormatter.ISO_DATE_TIME)
    val formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy")
    val formattedDate = dateTime.format(formatter)
    val clipboardManager: ClipboardManager = LocalClipboardManager.current

    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = originalImage),
                contentDescription = null,
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(overflow = TextOverflow.Ellipsis,
                    text = title, maxLines = 1, fontSize = 14.sp, fontWeight = FontWeight.W400,
                    modifier = Modifier.fillMaxWidth(.7f),
                    color = Color.Black
                )
                CustomText12Weight400(formattedDate, color = Color.Gray)
            }
            Spacer(modifier = Modifier.weight(1f))
            Column (horizontalAlignment = Alignment.CenterHorizontally){
                CustomText14Weight600("${totalClicks}")
                CustomText12Weight400("Clicks", color = Color.Gray)
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xffE8F1FF))
                .drawBehind {
                    val stroke = Stroke(
                        width = 2.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(6f, 6f), 0f)
                    )
                    drawRoundRect(
                        color = Color(0xffA6c7ff),
                        size = size,
                        style = stroke,
                        cornerRadius = CornerRadius(8.dp.toPx())
                    )
                }
        ) {
            Row(modifier = Modifier.padding(8.dp)) {
                Text(
                    text = webUrl,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    color = Color.Blue,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .clickable { /* Handle URL click */ }
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(
                    modifier = Modifier.size(25.dp),
                    onClick = {
                        clipboardManager.setText(AnnotatedString(webUrl))
                    }
                ) {
                    Image(
                        modifier = Modifier.size(20.dp),
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "content copy"
                    )
                }
            }
        }
    }
}
