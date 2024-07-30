package com.mmartosdev.photofx.materials.asset03

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameMillis
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import com.mmartosdev.photofx.modifiers.shader
import kotlinx.coroutines.isActive
import org.jetbrains.skia.RuntimeEffect
import org.jetbrains.skia.RuntimeShaderBuilder

private val STRIPES_SHADER = """
    uniform float2 resolution;
    
    half4 main(vec2 fragCoord) {
        float colour = step(.5, mod(32.0 * fragCoord.x / resolution.x, 1.0));
        return half4(vec3(colour), 1.0);
    }
""".trimIndent()

@Composable
fun StripeContent(
    modifier: Modifier = Modifier,
) {
    var currentSize by remember { mutableStateOf(IntSize.Zero) }
    val stripesShader = remember(currentSize) {
        RuntimeShaderBuilder(
            effect = RuntimeEffect.makeForShader(STRIPES_SHADER),
        ).apply {
            uniform("resolution", currentSize.width.toFloat(), currentSize.height.toFloat())
        }.makeShader()
    }
    var time by remember { mutableFloatStateOf(0f) }
    LaunchedEffect(Unit) {
        var firstFrame = 0f
        while (isActive) {
            withFrameMillis {
                val lastFrame = it / 1000f
                if (firstFrame == 0f) {
                    firstFrame = lastFrame
                }
                time = (lastFrame - firstFrame)
            }
        }
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged { currentSize = it }
            .shader(STRIPES_SHADER)
    )
}
