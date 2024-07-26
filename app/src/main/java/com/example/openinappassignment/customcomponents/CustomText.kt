package com.example.openinappassignment.customcomponents

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun CustomText24Weight600(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.W600,
        color = color,
        modifier = modifier
    )
}

@Composable
fun CustomText16Weight600(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        color = color,
        modifier = modifier
    )
}

@Composable
fun CustomText16Weight400(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.W400,
        color = color,
        modifier = modifier
    )
}

@Composable
fun CustomText14Weight600(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.W600,
        color = color,
        modifier = modifier
    )
}

@Composable
fun CustomText14Weight400(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        color = color,
        modifier = modifier
    )
}

@Composable
fun CustomText12Weight400(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black
) {
    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        color = color,
        modifier = modifier
    )
}
