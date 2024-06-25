package com.mmartosdev.photofx.materials.asset01

import androidx.compose.animation.core.animate
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ScreenBuffer(
    xPixels: Int,
    yPixels: Int,
    pixelSize: Float,
    modifier: Modifier = Modifier,
    vm: FragmentShaderViewModel = viewModel { FragmentShaderViewModel() },
) {
    val highlightedPixelSet by vm.highlightedPixelSet.collectAsState()
    val pixels by vm.pixels.collectAsState()
    val fadeOutPixels by vm.fadeOutPixels.collectAsState()
    var alpha by remember(highlightedPixelSet) { mutableStateOf(0f) }
    var fadeOut by remember(fadeOutPixels) { mutableStateOf(1f) }
    LaunchedEffect(highlightedPixelSet) {
        animate(
            initialValue = 0f,
            targetValue = 1f,
            animationSpec = tween(durationMillis = highlightedPixelSet.duration)
        ) { value, _ ->
            alpha = value
        }
    }
    LaunchedEffect(fadeOutPixels) {
        fadeOutPixels?.run {
            animate(
                initialValue = 1f,
                targetValue = 0f,
                animationSpec = tween(durationMillis = this)
            ) { value, _ ->
                fadeOut = value
            }
        }
    }
    val textMeasure = rememberTextMeasurer()
    Canvas(modifier = modifier) {
        highlightedPixelSet.pixels.forEach {
            drawRect(
                color = it.color.copy(alpha = alpha),
                topLeft = Offset(
                    x = center.x - xPixels * pixelSize / 2f + it.x * pixelSize,
                    y = center.y - xPixels * pixelSize / 2f + it.y * pixelSize,
                ),
                size = Size(pixelSize, pixelSize),
            )
        }

        fadeOutPixels?.run {
            pixels.forEach {
                drawRect(
                    color = it.color.copy(alpha = fadeOut),
                    topLeft = Offset(
                        x = center.x - xPixels * pixelSize / 2f + it.x * pixelSize,
                        y = center.y - xPixels * pixelSize / 2f + it.y * pixelSize,
                    ),
                    size = Size(pixelSize, pixelSize),
                )
            }
        } ?: pixels.forEach {
            drawRect(
                color = it.color,
                topLeft = Offset(
                    x = center.x - xPixels * pixelSize / 2f + it.x * pixelSize,
                    y = center.y - xPixels * pixelSize / 2f + it.y * pixelSize,
                ),
                size = Size(pixelSize, pixelSize),
            )
        }


        repeat(yPixels + 1) {
            drawLine(
                color = Color.Black,
                start = Offset(
                    x = center.x - xPixels * pixelSize / 2f,
                    y = center.y - xPixels * pixelSize / 2f + it * pixelSize
                ),
                end = Offset(
                    x = center.x + xPixels * pixelSize / 2f,
                    y = center.y - xPixels * pixelSize / 2f + it * pixelSize
                ),
                strokeWidth = density
            )
        }
        repeat(xPixels + 1) {
            drawLine(
                color = Color.Black,
                start = Offset(
                    x = center.x - xPixels * pixelSize / 2f + it * pixelSize,
                    y = center.y - xPixels * pixelSize / 2f
                ),
                end = Offset(
                    x = center.x - xPixels * pixelSize / 2f + it * pixelSize,
                    y = center.y + xPixels * pixelSize / 2f
                ),
                strokeWidth = density
            )
        }

        repeat(xPixels) {
            val text = it.toString()
            val result = textMeasure.measure(
                text = text,
            )
            drawText(
                textMeasurer = textMeasure,
                text = text,
                topLeft = Offset(
                    x = (pixelSize - result.size.width) / 2f + pixelSize * (it + 1),
                    y = (pixelSize - result.size.height) / 2f,
                ),
                size = Size(pixelSize, pixelSize),
            )
        }
        repeat(yPixels) {
            val text = it.toString()
            val result = textMeasure.measure(
                text = text,
            )
            drawText(
                textMeasurer = textMeasure,
                text = text,
                topLeft = Offset(
                    x = (pixelSize - result.size.width) / 2f,
                    y = (pixelSize - result.size.height) / 2f + pixelSize * (it + 1),
                ),
                size = Size(pixelSize, pixelSize),
            )
        }

        highlightedPixelSet.pixels.forEach {
            drawRect(
                color = Color.Black,
                topLeft = Offset(
                    x = center.x - xPixels * pixelSize / 2f + it.x * pixelSize,
                    y = center.y - xPixels * pixelSize / 2f + it.y * pixelSize,
                ),
                size = Size(pixelSize, pixelSize),
                style = Stroke(4f * density),
            )
        }

    }
}
