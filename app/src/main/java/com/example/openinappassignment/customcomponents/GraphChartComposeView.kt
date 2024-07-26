package com.example.openinappassignment.customcomponents

import OverallUrlChart
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.model.GradientColor


@Composable
fun GraphChartComposeView(overallUrlChart: OverallUrlChart) {
    val context = LocalContext.current
    val labels =
        listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec")
    val dataEntries = listOf(
        Entry(0f, overallUrlChart.n0000.toFloat()),
        Entry(1f, overallUrlChart.n0100.toFloat()),
        Entry(2f, overallUrlChart.n0200.toFloat()),
        Entry(3f, overallUrlChart.n0300.toFloat()),
        Entry(4f, overallUrlChart.n0400.toFloat()),
        Entry(5f, overallUrlChart.n0500.toFloat()),
        Entry(6f, overallUrlChart.n0600.toFloat()),
        Entry(7f, overallUrlChart.n0700.toFloat()),
        Entry(8f, overallUrlChart.n0800.toFloat()),
        Entry(9f, overallUrlChart.n0900.toFloat()),
        Entry(10f, overallUrlChart.n1000.toFloat()),
        Entry(11f, overallUrlChart.n1100.toFloat()),
        Entry(12f, overallUrlChart.n1200.toFloat()),
        Entry(13f, overallUrlChart.n1300.toFloat()),
        Entry(14f, overallUrlChart.n1400.toFloat()),
        Entry(15f, overallUrlChart.n1500.toFloat()),
        Entry(16f, overallUrlChart.n1600.toFloat()),
        Entry(17f, overallUrlChart.n1700.toFloat()),
        Entry(18f, overallUrlChart.n1800.toFloat()),
        Entry(19f, overallUrlChart.n1900.toFloat()),
        Entry(20f, overallUrlChart.n2000.toFloat()),
        Entry(21f, overallUrlChart.n2100.toFloat()),
        Entry(22f, overallUrlChart.n2200.toFloat()),
        Entry(23f, overallUrlChart.n2300.toFloat())
    )


    val lineDataSet = LineDataSet(dataEntries, "Data").apply {
        color = Color(0xff0E6FFF).toArgb()
        setDrawFilled(true)
        fillAlpha = 50
    gradientColors= listOf(GradientColor(0xff0E6FFF.toInt(),(0xff0E6FFF.toInt())))
        setDrawValues(false)
        setDrawCircles(false)
    }


    val lineData = LineData(lineDataSet)
    val lineChart = LineChart(context).apply {
        data = lineData
        description.isEnabled = false
        xAxis.apply {
            data = lineData
            description.isEnabled = false
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            axisLeft.setDrawGridLines(true)
            legend.isEnabled=false
            setTouchEnabled(false)
            xAxis.valueFormatter = IndexAxisValueFormatter(labels)
            xAxis.setLabelCount(24, true)
        }

        axisRight.isEnabled = false
        legend.isEnabled = false
        setVisibleXRangeMaximum(12f)
        invalidate()
    }


    AndroidView(factory = { lineChart }, modifier = Modifier.fillMaxSize())

}