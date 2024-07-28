package com.mmartosdev.photofx.materials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.min

@Composable
fun AssetContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    BoxWithConstraints(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        // Here, we are assuming that ideal screen size is 800x600
        val scale = min(maxWidth / 800.dp, maxHeight / 600.dp)
        Box(
            Modifier
                .requiredSize(800.dp, 600.dp)
                .scale(scale)
        ) {
            content.invoke()
        }
    }
}
