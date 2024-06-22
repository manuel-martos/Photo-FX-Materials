package com.mmartosdev.photofx.materials.asset01

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun FragmentShaderContent(modifier: Modifier = Modifier) {
    val vm = viewModel { FragmentShaderViewModel() }
    FragmentShader(
        modifier = modifier.fillMaxSize(),
        vm = vm,
    )
    LaunchedEffect(Unit) {
        launch {
            while (true) {
                delay(500)
                vm.highlightPixel(0, 0, Color.hsl(222f, 0.70f, 0.86f), 1000)
                delay(2000)
                vm.highlightPixel(1, 0, Color.hsl(222f, 0.71f, 0.80f), 1000)
                delay(2000)
                vm.highlightPixel(2, 0, Color.hsl(222f, 0.72f, 0.74f), 1000)
                delay(2000)
                vm.highlightPixel(3, 0, Color.hsl(222f, 0.73f, 0.69f), 1000)
                delay(2000)
                vm.highlightPixel(4, 0, Color.hsl(222f, 0.74f, 0.61f), 1000)
                delay(2000)
                vm.highlightPixel(5, 0, Color.hsl(222f, 0.75f, 0.53f), 1000)
                delay(2000)
                vm.highlightPixel(6, 0, Color.hsl(222f, 0.76f, 0.59f), 1000)
                delay(2000)
                vm.highlightPixel(7, 0, Color.hsl(222f, 0.77f, 0.68f), 1000)
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 1, Color.hsl(210f, 0.83f, 0.86f)),
                    Pixel(1, 1, Color.hsl(210f, 0.82f, 0.80f)),
                    Pixel(2, 1, Color.hsl(210f, 0.81f, 0.74f)),
                    Pixel(3, 1, Color.hsl(210f, 0.80f, 0.69f)),
                    Pixel(4, 1, Color.hsl(210f, 0.79f, 0.61f)),
                    Pixel(5, 1, Color.hsl(210f, 0.78f, 0.53f)),
                    Pixel(6, 1, Color.hsl(210f, 0.77f, 0.59f)),
                    Pixel(7, 1, Color.hsl(210f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 2, Color.hsl(204f, 0.83f, 0.86f)),
                    Pixel(1, 2, Color.hsl(204f, 0.82f, 0.80f)),
                    Pixel(2, 2, Color.hsl(204f, 0.81f, 0.74f)),
                    Pixel(3, 2, Color.hsl(204f, 0.80f, 0.69f)),
                    Pixel(4, 2, Color.hsl(204f, 0.79f, 0.61f)),
                    Pixel(5, 2, Color.hsl(204f, 0.78f, 0.53f)),
                    Pixel(6, 2, Color.hsl(204f, 0.77f, 0.59f)),
                    Pixel(7, 2, Color.hsl(204f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 3, Color.hsl(198f, 0.83f, 0.86f)),
                    Pixel(1, 3, Color.hsl(198f, 0.82f, 0.80f)),
                    Pixel(2, 3, Color.hsl(198f, 0.81f, 0.74f)),
                    Pixel(3, 3, Color.hsl(198f, 0.80f, 0.69f)),
                    Pixel(4, 3, Color.hsl(198f, 0.79f, 0.61f)),
                    Pixel(5, 3, Color.hsl(198f, 0.78f, 0.53f)),
                    Pixel(6, 3, Color.hsl(198f, 0.77f, 0.59f)),
                    Pixel(7, 3, Color.hsl(198f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 4, Color.hsl(192f, 0.83f, 0.86f)),
                    Pixel(1, 4, Color.hsl(192f, 0.82f, 0.80f)),
                    Pixel(2, 4, Color.hsl(192f, 0.81f, 0.74f)),
                    Pixel(3, 4, Color.hsl(192f, 0.80f, 0.69f)),
                    Pixel(4, 4, Color.hsl(192f, 0.79f, 0.61f)),
                    Pixel(5, 4, Color.hsl(192f, 0.78f, 0.53f)),
                    Pixel(6, 4, Color.hsl(192f, 0.77f, 0.59f)),
                    Pixel(7, 4, Color.hsl(192f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 5, Color.hsl(188f, 0.83f, 0.86f)),
                    Pixel(1, 5, Color.hsl(188f, 0.82f, 0.80f)),
                    Pixel(2, 5, Color.hsl(188f, 0.81f, 0.74f)),
                    Pixel(3, 5, Color.hsl(188f, 0.80f, 0.69f)),
                    Pixel(4, 5, Color.hsl(188f, 0.79f, 0.61f)),
                    Pixel(5, 5, Color.hsl(188f, 0.78f, 0.53f)),
                    Pixel(6, 5, Color.hsl(188f, 0.77f, 0.59f)),
                    Pixel(7, 5, Color.hsl(188f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 6, Color.hsl(181f, 0.83f, 0.86f)),
                    Pixel(1, 6, Color.hsl(181f, 0.82f, 0.80f)),
                    Pixel(2, 6, Color.hsl(181f, 0.81f, 0.74f)),
                    Pixel(3, 6, Color.hsl(181f, 0.80f, 0.69f)),
                    Pixel(4, 6, Color.hsl(181f, 0.79f, 0.61f)),
                    Pixel(5, 6, Color.hsl(181f, 0.78f, 0.53f)),
                    Pixel(6, 6, Color.hsl(181f, 0.77f, 0.59f)),
                    Pixel(7, 6, Color.hsl(181f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(1000)
                vm.highlightPixels(
                    Pixel(0, 7, Color.hsl(171f, 0.83f, 0.86f)),
                    Pixel(1, 7, Color.hsl(171f, 0.82f, 0.80f)),
                    Pixel(2, 7, Color.hsl(171f, 0.81f, 0.74f)),
                    Pixel(3, 7, Color.hsl(171f, 0.80f, 0.69f)),
                    Pixel(4, 7, Color.hsl(171f, 0.79f, 0.61f)),
                    Pixel(5, 7, Color.hsl(171f, 0.78f, 0.53f)),
                    Pixel(6, 7, Color.hsl(171f, 0.77f, 0.59f)),
                    Pixel(7, 7, Color.hsl(171f, 0.76f, 0.68f)),
                    duration = 500,
                )
                delay(4000)
                vm.fadeOutPixels(1000)
                delay(1000)
                vm.clear()
            }
        }
    }
}