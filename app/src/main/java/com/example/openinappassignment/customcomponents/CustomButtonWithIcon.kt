package com.example.openinappassignment.customcomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomButtonWithIcon(
    boxColor: Color,
    boxBorderColor: Color,
    boxIcon: ImageVector,
    buttonText: String,
    iconColor: Color, onClick: () -> Unit
) {
    Box(
        modifier = Modifier

            .fillMaxWidth()
            .height(50.dp)
            .background(boxColor)
            .border(1.dp, color = boxBorderColor, shape = RoundedCornerShape(5.dp))
            .clickable { onClick() }
    ) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(10.dp)) {
            Icon(imageVector = boxIcon, contentDescription = "box icon", tint = iconColor)
            Spacer(modifier = Modifier.width(10.dp))
            CustomText16Weight600(text = buttonText)
        }
    }
}

@Composable
fun CustomButtonWithIconNoTint(buttonText: String, onClick: () -> Unit, icon: ImageVector) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .border(
                width = 1.dp,
                color = Color(0xffD8D8D8),
                shape = RoundedCornerShape(5.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick() }
    ) {
        Row {
            Icon(imageVector = icon, contentDescription = "icon")
            Spacer(modifier = Modifier.width(10.dp))
            CustomText16Weight600(buttonText)
        }

    }
}