package com.mmartosdev.photofx.materials.asset01

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

private const val xPixels = 8
private const val yPixels = 8

@Composable
fun FragmentShader(
    modifier: Modifier = Modifier,
    vm: FragmentShaderViewModel = viewModel { FragmentShaderViewModel() },
) {
    val highlightedPixelSet by vm.highlightedPixelSet.collectAsState()
    Column(modifier = modifier) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Text(text = "Pixel Coordinates", style = MaterialTheme.typography.titleLarge)
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Fragment Shader", style = MaterialTheme.typography.titleLarge)
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                modifier = Modifier.padding(horizontal = 8.dp)
            )
            Text(text = "Pixel Colour", style = MaterialTheme.typography.titleLarge)
        }
        BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
            val pixelSize = 1f / (max(xPixels, yPixels) + 2) * min(maxWidth.value, maxHeight.value)
            Row(modifier = modifier) {
                AnimatedContent(
                    targetState = highlightedPixelSet.pixels,
                    transitionSpec = {
                        fadeIn(animationSpec = tween(220, delayMillis = 90)).togetherWith(
                            fadeOut(
                                animationSpec = tween(90)
                            )
                        )
                    },
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()
                        .padding(top = pixelSize.dp)
                ) {
                    Column(
                        verticalArrangement = spacedBy(2.dp),
                    ) {
                        it.forEach {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxWidth(),
                            ) {
                                Text(
                                    text = "f(${it.x},${it.y}) = ",
                                    style = MaterialTheme.typography.titleMedium.copy(fontFamily = FontFamily.Monospace)
                                )
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .background(it.color, shape = CircleShape)
                                        .border(
                                            width = 1.dp,
                                            color = Color.Black,
                                            shape = CircleShape
                                        )
                                )
                            }
                        }
                    }
                }
                Box(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxSize()
                ) {
                    ScreenBuffer(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .drawWithContent {
                                drawContent()
                                drawRect(
                                    Brush.radialGradient(
                                        0.00f to Color.Transparent,
                                        0.60f to Color.Transparent,
                                        0.65f to Color.White,
                                        center = Offset.Zero,
                                        radius = sqrt((size.width * size.width) + (size.height * size.height))
                                    ),
                                    topLeft = Offset(-size.width * 0.05f, -size.height * 0.05f),
                                    size = size * 1.1f,
                                )
                            },
                        vm = vm,
                        xPixels = xPixels,
                        yPixels = yPixels,
                        pixelSize = pixelSize * LocalDensity.current.density,
                    )
                }
            }
        }
    }
}