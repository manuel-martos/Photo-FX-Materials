import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import com.mmartosdev.photofx.materials.AssetContainer
import com.mmartosdev.photofx.materials.asset01.FragmentShaderContent

fun main() = application {
    val windowState = rememberWindowState(width = 800.dp, height = 600.dp)
    Window(onCloseRequest = ::exitApplication, state = windowState) {
        MaterialTheme {
            AssetContainer(
                modifier = Modifier
                    .background(Color.White)
            ) { modifier ->
                FragmentShaderContent(modifier)
            }
        }
    }
}
