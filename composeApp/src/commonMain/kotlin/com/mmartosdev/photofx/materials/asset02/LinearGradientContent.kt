package com.mmartosdev.photofx.materials.asset02

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mmartosdev.photofx.modifiers.shader

private val LINEAR_GRADIENT_SHADER = """
    uniform float2 resolution;
    uniform float4 colour;
    
    half4 main(vec2 fragCoord) { 
        return half4(colour.rgb * fragCoord.x / resolution.x, 1.);
    }
""".trimIndent()

@Composable
fun LinearGradientContent(
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        var hue by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .shader(LINEAR_GRADIENT_SHADER) {
                    uniform("colour", Color.hsl(hue, 1f, 0.5f))
                }
        )
        Slider(
            value = hue,
            onValueChange = { hue = it },
            modifier = Modifier.fillMaxWidth(),
            valueRange = 0f..360f,
        )
    }

}
