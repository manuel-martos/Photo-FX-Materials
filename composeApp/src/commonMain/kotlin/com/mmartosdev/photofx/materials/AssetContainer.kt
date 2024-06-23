package com.mmartosdev.photofx.materials

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.math.max

@Composable
fun AssetContainer(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit,
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
    ) {
        val scaleWidth = maxWidth / 736.dp
        val scaleHeight = maxHeight / 448.dp
        val scale = max(scaleWidth, scaleHeight)
        // Here, we are assuming that ideal screen size is 736x448 (mobile size)
        content.invoke(Modifier.scale(scale))
    }
}
